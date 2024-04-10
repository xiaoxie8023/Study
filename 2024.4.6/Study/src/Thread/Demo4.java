package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-10
 * Time: 18:19
 */

/** * @author xiaoxie
 * @date 2024年04月10日 18:19
 */
class MyQueue {
    private int[] elem;
    private volatile int head;
    private volatile int tail;
    private volatile int size;
    public MyQueue(int capacity) {
        this.elem = new int[capacity];
    }
    public void put(int value) throws InterruptedException {
        synchronized(this){
            while (size >= elem.length) {
                this.wait();
            }
            elem[tail++] = value;
            if (tail >= elem.length) {
                tail = 0;
            }
            size++;
            this.notify();
        }
    }
    public int take() throws InterruptedException {
        synchronized (this){
            while (size == 0) {
                this.wait();
            }
            int ret = elem[head++];
            if (head >= elem.length) {
                head = 0;
            }
            size--;
            this.notify();
            return ret;
        }
    }
}
public class Demo4 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(1000);
        Thread t1 = new Thread(() -> {
            try {
                int count = 1;
                while (true) {
                    queue.put(count );
                    System.out.println("生产" + count);
                    Thread.sleep(1000);
                    count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    int result = queue.take();
                    System.out.println("消费" + result);
                    //Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
