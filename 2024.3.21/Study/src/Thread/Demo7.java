package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-23
 * Time: 16:37
 */

/** * @author xiaoxie
 * @date 2024年03月23日 16:37
 */
//后台线程
public class Demo7 {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            for (int i = 0; i < 100000; i++) {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"自定义线程");
        t.start();
    }
}
