package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-28
 * Time: 18:24
 */

/** * @author xiaoxie
 * @date 2024年03月28日 18:24
 */
class Lockers {
    public static int count;
    synchronized public static void func(){
        count++;
    }

    public static int getCount() {
        return count;
    }
}
public class Demo20 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                Lockers.func();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                Lockers.func();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + Lockers.getCount());
    }
}
