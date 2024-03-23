package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-23
 * Time: 16:52
 */

/** * @author xiaoxie
 * @date 2024年03月23日 16:52
 */
//中断线程
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    System.out.println("线程中断");
                    break;
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}
