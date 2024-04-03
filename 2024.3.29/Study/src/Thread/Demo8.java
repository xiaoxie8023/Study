package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-03
 * Time: 10:18
 */

/** * @author xiaoxie
 * @date 2024年04月03日 10:18
 */
public class Demo8 {
    public static int count;
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();//创建一个锁对象,无论是什么类型都可以为锁对象,
        //这里的锁对象只是做一个标识的作用
        Thread t1 = new Thread(()->{
                for (int i = 0; i < 50000; i++) {
                    synchronized (locker) {
                        count++;
                    }
                }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });
        t1.start();
        t2.start();
        //保证线程1和线程2执行完毕
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }
}
