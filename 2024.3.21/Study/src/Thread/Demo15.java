package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-27
 * Time: 14:41
 */

/** 有时间限制的等待
 * * @author xiaoxie
 * @date 2024年03月27日 14:41
 */
public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hi t1");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i = 0; i < 5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("hi t2");
            }
        });
        t1.start();
        t2.start();
        t2.join(6000);
        System.out.println("main end");
    }
}
