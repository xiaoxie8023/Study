package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 10:39
 */

/** * @author xiaoxie
 * @date 2024年03月29日 10:39
 */
public class Demo25 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           for(int i = 0; i <3;i++) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("hello Thread");
           }
            System.out.println("t1结束");
        });
        t1.setDaemon(true);//要在线程创建前,将线程设置为后台线程
        t1.start();
        for (int i = 0;i < 5;i++) {
            Thread.sleep(1000);
            System.out.println("hello main");
        }
        System.out.println("main结束");
    }
}
