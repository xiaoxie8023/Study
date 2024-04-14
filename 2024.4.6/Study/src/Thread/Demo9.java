package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-14
 * Time: 20:32
 */

/** 自己实现了一个阻塞队列
 * * @author xiaoxie
 * @date 2024年04月14日 20:32
 */
class MyBlockQueue{
  private  int[] elem;
  private volatile int head ;
  private volatile int tail ;
  private volatile int size;
  public MyBlockQueue(int capacity) {
      this.elem = new int[capacity];
  }
  public void put(int s) throws InterruptedException {
      synchronized (this){
          while (size == elem.length) {
              wait();
          }
          elem[tail++] = s;
          if(tail  >= elem.length) {
              tail = 0;
          }
          size++;
          notify();
      }
  }
  public int take() throws InterruptedException {
      synchronized (this) {
          while(size == 0) {
              wait();
          }
          int ret = elem[head++];
          if(head >= elem.length) {
              head = 0;
          }
          size--;
          notify();
          return ret;
      }
  }
}
public class Demo9 {

    public static void main(String[] args) throws InterruptedException {
        MyBlockQueue myBlockQueue = new MyBlockQueue(100);
        Thread t1 = new Thread(()-> {
            int count = 0;
            for(int i = 0;i < 1000;i++) {
                try {
                    myBlockQueue.put(count);
                    System.out.println(Thread.currentThread().getName()+"生产了" + count++);
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for(int i = 0;i < 100;i++) {
                try {
                  int ret =  myBlockQueue.take();
                    System.out.println(Thread.currentThread().getName()+"消费了" + ret);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
