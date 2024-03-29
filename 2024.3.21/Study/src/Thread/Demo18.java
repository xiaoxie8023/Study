package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-28
 * Time: 17:30
 */

/** * @author xiaoxie
 * @date 2024年03月28日 17:30
 */
class Sum {
    public int count;
    public void add() {
        synchronized (this) {
            ++count;
        }
    }

    public int getCount() {
        return count;
    }
}
public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        Sum sum =  new Sum();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                sum.add();
            }
        });
        Thread t2  = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                sum.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + sum.getCount());
    }
}
