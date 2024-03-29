package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-28
 * Time: 18:21
 */

/** * @author xiaoxie
 * @date 2024年03月28日 18:21
 */
class Locker {
    public int count;
    synchronized public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Locker locker = new Locker();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                locker.add();
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 50000; i++) {
                locker.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = "+locker.getCount());
    }
}
