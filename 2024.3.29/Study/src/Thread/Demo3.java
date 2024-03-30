package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-30
 * Time: 16:34
 */

/** wait()超时等待
 * 虽然说wait设置了超时时间,但也要和它一把锁的线程,释放锁后它才能继续执行
 * * @author xiaoxie
 * @date 2024年03月30日 16:34
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Thread t1 = new Thread(()-> {
            synchronized(locker) {
                System.out.println("t1等待2秒");
                try {
                    locker.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1等待后");
            }
        });
        Thread t2 = new Thread(()-> {
            synchronized(locker) {
                System.out.println("t2通知");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                locker.notify();
                System.out.println("t2通知后");
            }
        });
        t1.start();
        t2.start();
    }
}
