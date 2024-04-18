package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-16
 * Time: 19:00
 */

import java.util.concurrent.*;

/** * @author xiaoxie
 * @date 2024年04月16日 19:00
 */
public class Demo15 {
    public static void main(String[] args) {
        //固定大小的线程池
        Executors.newFixedThreadPool(10);
        //能够根据任务数量扩容的线程池
        Executors.newCachedThreadPool();
        //设置一个固定线程大小,但是任务延时执行的线程池
        Executors.newScheduledThreadPool(100);
        //设置一个单线程的线程池
        Executors.newSingleThreadExecutor();
        // 定义线程池的核心线程数量
        int corePoolSize = 5;

// 定义线程池的最大线程数量
        int maximumPoolSize = 10;

// 定义保持活动时间的时长
        long keepAliveTime = 60;

// 定义保持活动时间的时间单位
        TimeUnit units = TimeUnit.SECONDS;

// 定义用于存储任务的阻塞队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

// 定义用于创建新线程的线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

// 定义拒绝执行任务的处理程序
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

// 创建一个ThreadPoolExecutor并设置参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,       // 核心线程数量
                maximumPoolSize,    // 最大线程数量
                keepAliveTime,      // 保持活动时间
                units,              // 保持活动时间的时间单位
                workQueue,          // 存储任务的队列
                threadFactory,      // 线程工厂
                handler             // 拒绝执行任务的处理程序
        );
    }
}
