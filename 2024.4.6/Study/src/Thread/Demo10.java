package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-14
 * Time: 21:06
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** * @author xiaoxie
 * @date 2024年04月14日 21:06
 */
public class Demo10 {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            int sum = 0;

            @Override
            public Integer call() throws Exception {
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        try {
            // 从Future中获取结果并打印
            Integer result = futureTask.get();
            System.out.println("结果为：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

