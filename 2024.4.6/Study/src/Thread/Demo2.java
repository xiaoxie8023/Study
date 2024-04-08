package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-07
 * Time: 11:20
 */

/** * @author xiaoxie
 * @date 2024年04月07日 11:20
 */
public class Demo2 {
    public static void main(String[] args) {
        Object lockerA = new Object();
        Object lockerB = new Object();
        Thread A = new Thread(()->{
           synchronized(lockerA) {
               System.out.println("线程A获取锁A");
               synchronized(lockerB) {
                   System.out.println("线程A获取锁B");
               }
           }
        });
        Thread B = new Thread(()->{
            synchronized(lockerB) {
                System.out.println("线程B获取锁B");
                synchronized (lockerA) {
                    System.out.println("线程B获取锁A");
                }
            }

        });
        A.start();
        B.start();

    }
}
