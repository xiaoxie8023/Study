package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-17
 * Time: 14:26
 */

import java.util.TimerTask;
import java.util.concurrent.*;

/** 线程池的几种创建方式
 * * @author xiaoxie
 * @date 2024年04月17日 14:26
 */
public class Demo17 {
    public static void main(String[] args) {
        //使用Executors工厂类创建固定线程的线程池
        ExecutorService fixExecutor = Executors.newFixedThreadPool(5);
        //使用Executors工厂类创建可扩容线程的线程池
        ExecutorService Executor = Executors.newCachedThreadPool();
        //使用Executors工厂类创建单线程的线程池
        ExecutorService Executor2 = Executors.newSingleThreadExecutor();
        //使用Executors工厂类创建多线程任务耗时的线程池
        ExecutorService Executor3 = Executors.newScheduledThreadPool(10);
        //最大线程数
        int MaxPoolSize = 20;
        //核心线程数
        int corePoolSize = 10;
        //非核心线程存在时间
        Long keepAliveTime = 100L;
        //非核心线程存在时间单位
        TimeUnit timerTask = TimeUnit.MICROSECONDS;
        //任务等待队列
        BlockingQueue<Runnable> q = new LinkedBlockingQueue<>();
        //线程工厂类
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //拒绝策略
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,MaxPoolSize,keepAliveTime,
                timerTask,q,threadFactory,rejectedExecutionHandler);
        for (int i = 0; i < 100000; i++) {
            int id = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程+"+Thread.currentThread().getName() + "执行" + id);
                }
            });
        }
    }
}
