package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 10:18
 */

/** * @author xiaoxie
 * @date 2024年03月29日 10:18
 */
public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hello thread");

        },"text1");
        t1.start();
        System.out.println("id = " + t1.getId());//获取线程的ID
        Thread.sleep(1000);
        System.out.println("hello main");

    }
}
