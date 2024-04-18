package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-14
 * Time: 21:15
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** * @author xiaoxie
 * @date 2024年04月14日 21:15
 */
class MyThreadPool {
    private BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(1000);
    ;
    private int maxPoolSize;
    private List<Thread> threadList = new ArrayList<>();

    public MyThreadPool(int corePoolSize, int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        for (int i = 0; i < corePoolSize; i++) {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        Runnable runnable = q.take();
                        runnable.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            threadList.add(t);
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        if (!q.offer(runnable)) {
            // 如果队列已满，并且线程数已经达到最大值，则拒绝新任务
            if (threadList.size() >= maxPoolSize) {
                throw new RuntimeException("线程池已达到极限,请勿添加任务");
            }
            // 否则创建新线程
            Thread t = addNewThread();
            t.start();
        }
    }

    private Thread addNewThread() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Runnable runnable = q.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; // 线程被中断时退出循环
                }
            }
        });
        threadList.add(t);
        return t;
    }
}
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(10,20);
        for(int i = 0;i < 10000;i++) {
            int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " +id + " "+Thread.currentThread().getName());
                }
            });
        }
    }
}
