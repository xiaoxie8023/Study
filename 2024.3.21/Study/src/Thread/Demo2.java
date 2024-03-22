package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-22
 * Time: 11:52
 */

/** * @author xiaoxie
 * @date 2024年03月22日 11:52
 */
//多线程方法2
class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Demo2 {
    public static void main(String[] args)  {
        Thread t = new Thread(new MyThread());
        t.start();
        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
