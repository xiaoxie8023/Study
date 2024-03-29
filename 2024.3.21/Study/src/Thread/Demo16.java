package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-27
 * Time: 14:47
 */

/** sleep()表示的是"线程消耗的时间而不是两个代码执行的时间"
 * * @author xiaoxie
 * @date 2024年03月27日 14:47
 */
public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        System.out.println("begin:" + begin);
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("end:" + end);
    }
}
