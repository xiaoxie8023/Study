package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-23
 * Time: 16:44
 */

/** * @author xiaoxie
 * @date 2024年03月23日 16:44
 */
//前台线程设置为后台进程
public class Demo8 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 4; i++) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.setDaemon(true);
        t.start();

    }

}
