package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-23
 * Time: 14:11
 */

/** * @author xiaoxie
 * @date 2024年03月23日 14:11
 */
//创建线程的第四种方法 匿名内部类实现Runnable接口
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
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
