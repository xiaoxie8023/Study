package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-17
 * Time: 15:16
 */

import java.util.PriorityQueue;

/** * @author xiaoxie
 * @date 2024年04月17日 15:16
 */
class MyTimeTask implements Comparable<MyTimeTask>{
    private Runnable runnable;
    private long time;
    public MyTimeTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }
    public long getTime() {
        return time;
    }
    public void run() {
        runnable.run();
    }

    @Override
    public int compareTo(MyTimeTask o) {
        return (int)(this.time - o.time);
    }
}
class MyTimer {
    private PriorityQueue<MyTimeTask> queue = new PriorityQueue<MyTimeTask>();
    Object locker = new Object();
    public MyTimer() {
        //使用一个后台线程,不停的扫描上述的队列队首元素, 来确定是否要执行任务
       Thread t = new Thread(()->{
         try{
          while(true) {
              synchronized (locker) {
                 if(queue.size() == 0) {
                     locker.wait();
                 }
                 MyTimeTask myTimeTask = queue.peek();
                 long nowTime = System.currentTimeMillis();
                 if( nowTime >= myTimeTask.getTime()) {
                     myTimeTask.run();
                          queue.poll();
                      }else {
                     locker.wait(myTimeTask.getTime()-nowTime);
                      }
                  }
              }
          }catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
       });
       t.start();
    }
    public void Schedule(Runnable runnable,long delay) {
        synchronized (locker){
            MyTimeTask myTimeTask = new MyTimeTask(runnable, delay);
            queue.offer(myTimeTask);
            locker.notify();
        }
    }
}
public class Demo18 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        },3000);
        myTimer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        },2000);
        myTimer.Schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        },1000);
    }
}
