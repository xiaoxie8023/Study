package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-23
 * Time: 14:37
 */

/** * @author xiaoxie
 * @date 2024年03月23日 14:37
 */
//自定义异常操作
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        t.start();
        System.out.println("hello main");
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
