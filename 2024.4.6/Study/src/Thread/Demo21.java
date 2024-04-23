package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-21
 * Time: 19:07
 */

/** * @author xiaoxie
 * @date 2024年04月21日 19:07
 */
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.BrokenBarrierException;

public class Demo21 {
    public static void main(String[] args) {
        int workerCount = 3;
        final CyclicBarrier barrier = new CyclicBarrier(workerCount,
                () -> System.out.println("所有的工作线程已经完成了它们的工作了."));

        for (int i = 0; i < workerCount; i++) {
            new Thread(() -> {
                System.out.println("Worker " + Thread.currentThread().getName() + " started.");
                doWork();
                try {
                    barrier.await(); // 等待其他工人
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private static void doWork() {
        try {
            // 模拟工作
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}