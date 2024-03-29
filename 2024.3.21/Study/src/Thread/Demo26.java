package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 11:03
 */

/** * @author xiaoxie
 * @date 2024年03月29日 11:03
 */
public class Demo26 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }

}
