package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-25
 * Time: 21:49
 */

/** * @author xiaoxie
 * @date 2024年03月25日 21:49
 */
public class DemoText {
    private static  int count = 0;
    public static void main(String[] args) throws InterruptedException {
       int a = (int) System.currentTimeMillis();
        Object locker = new Object();
        Thread t1 = new Thread(()-> {
            for(int i = 0;i < 50000;i++) {
                synchronized(locker) {
                    count++;
                }
            }
        });
        Thread t2 = new Thread(()-> {
            for(int i = 0;i < 50000;i++) {
                synchronized(locker) {
                    count++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        int b = (int) System.currentTimeMillis();
        System.out.println("count = " + count);
        System.out.println(a- b);
        }
}
