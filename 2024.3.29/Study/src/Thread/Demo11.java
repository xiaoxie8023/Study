package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-03
 * Time: 14:59
 */

import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月03日 14:59
 */
public class Demo11 {
    public static volatile int count;//count被volatile修饰
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (count == 0) {
                // do nothing
            }
            System.out.println("线程t1发现count值已改变，不再为0");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("请输入count的值:");
            Scanner scan = new Scanner(System.in);
            count = scan.nextInt(); // 修改count的值
            scan.nextLine(); // 清除换行符
        });

        t1.start();
        t2.start();

        // 为了让t1有机会看到t2对count的修改，可以让主线程等待t2结束
        t2.join();
        System.out.println("主线程已确认t2线程结束，现在t1应能看到count的新值");
    }
}