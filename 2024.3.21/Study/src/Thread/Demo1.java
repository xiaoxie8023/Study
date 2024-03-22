package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-22
 * Time: 9:02
 */

/** * @author xiaoxie
 * @date 2024年03月22日 9:02
 */
//1.多线程方法1
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
public class Demo1 {

    }
    public static void main(String[] args)  {
        Thread thread = new MyThread();
        thread.start();
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
