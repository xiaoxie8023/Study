package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-03
 * Time: 14:23
 */

import java.util.ArrayList;
import java.util.Arrays;

/** * @author xiaoxie
 * @date 2024年04月03日 14:23
 */
class Count {
    public static int count;
    Object locker = new Object();
    public static synchronized int add(){
        return ++count;
    }

    public static int getCount() {
        return count;
    }
}
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 50000; i++) {
                Count.add();
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 50000; i++) {
                Count.add();
            }
        });
        t1.start();
        t2.start();
        //保证线程1和线程2执行完毕
        t1.join();
        t2.join();
        System.out.println("count = " + Count.getCount());
    }
}
