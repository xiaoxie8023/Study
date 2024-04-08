package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-07
 * Time: 10:25
 */

/** * @author xiaoxie
 * @date 2024年04月07日 10:25
 */
public class Demo1 {
    public static int count;
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker) {
                    while (count % 3 != 0) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(Thread.currentThread().getName());
                    count++;
                    locker.notifyAll();
                }
            }
        },"A");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker) {
                    while (count % 3 != 1) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(Thread.currentThread().getName());
                    count++;
                    locker.notifyAll();
                }
            }
        },"B");
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker) {
                    while (count % 3 != 2) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                    count++;
                    locker.notifyAll();
                }
            }
        },"C");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
    }
}
