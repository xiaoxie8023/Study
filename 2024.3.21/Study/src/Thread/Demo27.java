package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 11:07
 */

/** 死锁的四个必要条件
 * 1.锁具有互斥性,即一个线程上锁后,另一个线程只能阻塞等待
 * 2.锁具有不可抢占性,即一个线程上锁后,另一个线程在上锁的线程解锁前,不可以抢占
 * 3.请求和保持 一个线程在获取一把所之后,在还没解锁之前又获取了另一把锁
 * 4.循环阻塞等待: 多个线程获取多把锁出现了循环阻塞等待的情况
 * * @author xiaoxie
 * @date 2024年03月29日 11:07
 */
public class Demo27 {
    public static int count1;
    public static int count2;
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Thread t1 = new Thread(()->{
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 500000; i++) {
                    count1++;
                }
                synchronized (locker1) {
                   count2++;
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 500000; i++) {
                    count2++;
                }
                synchronized (locker1) {
                    count1++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count1 = " + count1 + " count2 = " + count2);
    }
}
