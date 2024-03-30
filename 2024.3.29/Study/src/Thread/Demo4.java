package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-30
 * Time: 16:45
 */
import java.util.ArrayList;
import java.util.List;

/**有三个线程，线程名称分别为：a，b，c。
 每个线程打印自己的名称。
 需要让他们同时启动，并按 c，b，a的顺序打印
 * * @author xiaoxie
 * @date 2024年03月30日 16:45
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"c");
        Thread t2 = new Thread(()->{
            try {
                t3.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());

        },"b");
        Thread t1 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                t3.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());

        },"a");
        t1.start();
        t2.start();
        t3.start();
    }
}
