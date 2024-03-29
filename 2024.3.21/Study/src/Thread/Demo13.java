package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-27
 * Time: 14:21
 */

/** * @author xiaoxie
 * @date 2024年03月27日 14:21
 */
public class Demo13 {
    public static int count = 0;
    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
             threads [i] = new Thread(() -> {
                System.out.println(count++);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ok");
    }
}
