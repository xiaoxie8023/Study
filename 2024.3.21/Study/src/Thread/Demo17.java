package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-27
 * Time: 14:57
 */

/** * @author xiaoxie
 * @date 2024年03月27日 14:57
 */
public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("12");
        });
            Thread t2 = new Thread(() ->{
                try {
                    Thread.sleep(1000);
                    t1.join(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hello thread");
            });
        System.out.println(t1.getState());
        t1.start();
        t2.start();
        System.out.println(t1.getState());
        t2.join();
        System.out.println(t2.getState());
    }

}
