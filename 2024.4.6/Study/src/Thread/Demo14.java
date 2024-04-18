package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-16
 * Time: 18:16
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** * @author xiaoxie
 * @date 2024年04月16日 18:16
 */
class MyBlockQueue1{
    private int[] elem;//这里为了方便就定义一个简单的int数组来模拟队列
    //为了防止多线程环境下的指令重排序和内存可见性问题使用volatile来修饰
    private volatile int head;
    private volatile int trial;
    private volatile int sz;
    public MyBlockQueue1(int capacity){
        this.elem = new int[capacity];//手动设置容量
    }
    public void put(int val) throws InterruptedException {
        synchronized (this){
            while (sz >= elem.length) {
                wait();
            }
            elem[trial++] = val;
            if(trial >= elem.length) {
                trial = 0;
            }
            sz++;
            notify();
        }
    }
    public int take() throws InterruptedException {
        synchronized (this) {
            while(sz == 0) {
                wait();
            }
            int tmp = elem[head++];
            if(head >= elem.length) {
                head = 0;
            }
            sz--;
            notify();
            return tmp;
        }
    }
}
public class Demo14 {
    public static void main(String[] args) {
       MyBlockQueue1 q = new MyBlockQueue1(1000);
        Thread t1 = new Thread(()-> {
            int count = 0;
            while (true) {
                try {
                    q.put(count);
                    System.out.println("t1生产了: " + count);
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()-> {
            while (true) {
                try {
                    int tmp = q.take();
                    System.out.println("t2消费了: " + tmp);
                    Thread.sleep(1000);//让我们可以看清生产者消费的过程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
