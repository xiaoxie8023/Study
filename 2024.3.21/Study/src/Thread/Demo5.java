package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-23
 * Time: 14:15
 */

/** 创建线程的第五种方法
 * 使用lambda表达式创建Thread
 * @author xiaoxie
 * @date 2024/3/23 14:17
 * @param null
 * @return null
 */

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
           while (true) {
               System.out.println("hello Thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        t.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
