package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-03
 * Time: 13:57
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** 生产者-消费者模型
 * * @author xiaoxie
 * @date 2024年04月03日 13:57
 */
public class Demo9 {
    public static volatile int count;
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);
        Thread t1 = new Thread(() ->{
            while (true) {
                try {
                    Thread.sleep(1000);
                    queue.put(count);
                    count++;
                    System.out.println("t1生产了: " + count);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() ->{
            while (true) {
                try {
                    Thread.sleep(1000);
                    queue.put(count);
                    count++;
                    System.out.println("t2生产了: " + count);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(() ->{
            while (true) {
                try {
                    queue.take();
                    System.out.println("t3消费了: " + count);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
