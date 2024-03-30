package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-30
 * Time: 16:28
 */

import java.util.Scanner;

/** wait解锁的同时阻塞等待
 *  notify 通知唤醒等待
 * * @author xiaoxie
 * @date 2024年03月30日 16:28
 */
public class Demo2 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(()-> {
            synchronized(locker) {
                System.out.println("t1等待前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1等待后");
            }
        });
        Thread t2 = new Thread(()-> {
            synchronized(locker) {
                Scanner scan = new Scanner(System.in);
                System.out.println("t2通知前");
                //scan.next();
                locker.notify();
                System.out.println("t2通知后");
            }
        });
        t1.start();
        t2.start();
    }
}
