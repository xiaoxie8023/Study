package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-26
 * Time: 14:52
 */

/** * @author xiaoxie
 * @date 2024年03月26日 14:52
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(()->{
            for(int i = 0;i < 3;i++) {
                System.out.println("hello thread2");
            }
            System.out.println("t2结束了");
        });
        Thread t1 = new Thread(()->{
            for(int i = 0;i < 5;i++) {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hello thread1");
            }
            System.out.println("t1结束了");
        });
        t1.start();
        t2.start();
        t2.join();
        t1.join();
    }
}
