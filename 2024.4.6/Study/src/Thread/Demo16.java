package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-17
 * Time: 14:09
 */

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** * @author xiaoxie
 * @date 2024年04月17日 14:09
 */
class MyThreadPool1{
    private BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(100);
    private int maxPoolSize;
    private ArrayList<Thread> ThreadList = new ArrayList<>();
    public MyThreadPool1(int corePoolSize,int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        for(int i = 0;i < corePoolSize;i++) {
            Thread t = new Thread(()->{
                while (true) {
                    try {
                        Runnable runnable = q.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
            ThreadList.add(t);
        }
    }
    public void submit(Runnable runnable) {
        if(!q.offer(runnable)) {
            if(ThreadList.size() >= maxPoolSize) {
                throw new RuntimeException("线程已满");
            }
        }
        Thread t = new Thread(()->{
            while (true) {
                try {
                    Runnable runnable1 = q.take();
                    runnable1.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        ThreadList.add(t);
    }
}
public class Demo16 {
    public static void main(String[] args) {
        MyThreadPool1 myThreadPool1 = new MyThreadPool1(10,20);
        for(int i = 0;i <= 10000;i++) {
            int id = i;
            myThreadPool1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程+"+Thread.currentThread().getName() + "执行" + id);
                }
            });
        }
    }
}
