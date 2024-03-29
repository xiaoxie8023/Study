package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-27
 * Time: 14:35
 */

/** 线程的等待
 * * @author xiaoxie
 * @date 2024年03月27日 14:35
 */
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("hello thread1");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 4; i++) {
                System.out.println("hello thread2");
            }
        });
        t2.start();
        t1.start();
        t2.join();
    }
}
