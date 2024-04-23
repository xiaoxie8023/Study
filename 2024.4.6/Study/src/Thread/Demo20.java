package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-21
 * Time: 17:42
 */

import java.util.concurrent.locks.ReentrantLock;

/** * @author xiaoxie
 * @date 2024年04月21日 17:42
 */
public class Demo20 {
    public static void main(String[] args) {
        //这里可以设为true 就变为公平锁
        ReentrantLock locker = new ReentrantLock(true);
        locker.lock();//上锁
        try{
            // 受保护的代码
        }finally {//使用try - finally 确保一定会执行locker.unlock();
            locker.unlock();
        }
    }
}
