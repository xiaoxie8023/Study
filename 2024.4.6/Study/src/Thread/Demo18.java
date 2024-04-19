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
class MyTimerTask implements Comparable<MyTimerTask>{
    private  Runnable runnable;
    private  long time;
    public MyTimerTask(Runnable runnable,long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }
    public long getTime() {
        return time;
    }
    public void run(){
         runnable.run();
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return(int)( this.getTime() - o.getTime());
    }
}
class MyTimer{
    private  PriorityQueue<MyTimerTask> q = new PriorityQueue<>();
    private Object locker = new Object();
    public MyTimer() {
        Thread t = new Thread(()->{
           try{
               while (true) {
                   synchronized (locker) {
                       if(q.size() == 0) {
                           locker.wait();
                       }
                       MyTimerTask myTimerTask = q.peek();
                       long nowTime = System.currentTimeMillis();
                       if(nowTime >= myTimerTask.getTime()) {
                           myTimerTask.run();
                           q.poll();
                       }else {
                           locker.wait(myTimerTask.getTime()-nowTime);
                       }
                   }
               }
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        });
        t.start();
    }
    public void schedule(Runnable runnable, long delay) {
        synchronized(locker) {
            MyTimerTask myTimerTask = new MyTimerTask(runnable, delay);
            q.offer(myTimerTask);
            locker.notify();
        }
    }
}
public class Demo18 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        }, 3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        }, 2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        }, 1000);
    }
}
