package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-27
 * Time: 13:56
 */

import java.util.Random;

/** * @author xiaoxie
 * @date 2024年03月27日 13:56
 */
public class Demo12 {
    private static int sum1 = 0;
    private static int sum2 = 0;
    public static void main(String[] args) throws InterruptedException {
        int[] count = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < count.length; i++) {
            count[i] = random.nextInt(100) + 1;
        }

        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count.length; i += 2) {
                sum1 += count[i];
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < count.length; i += 2) {
                sum2 += count[i];
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int totalSum = sum1 + sum2;

        long end = System.currentTimeMillis();
        System.out.println("sum和: " + totalSum);
        System.out.println("运行时间: " + (end - begin) + "ms");
    }
}
