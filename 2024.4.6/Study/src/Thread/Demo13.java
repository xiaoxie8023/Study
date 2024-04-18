package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-16
 * Time: 17:59
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** * @author xiaoxie
 * @date 2024年04月16日 17:59
 */
public class Demo13 {
    public static void main(String[] args) {
        BlockingQueue<Integer> q = new LinkedBlockingQueue<>(1000);//阻塞队列
        Thread t1 = new Thread(()-> {
            int count = 0;
           while (true) {
               try {
                   q.put(count);
                   System.out.println("t1生产了: " + count);
                   count++;
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        Thread t2 = new Thread(()-> {
            while (true) {
                try {
                    int tmp = q.take();
                    System.out.println("t2消费了: " + tmp);
                    Thread.sleep(1000);//让我们可以看清生产者消费的过程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
