package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-30
 * Time: 15:52
 */

import java.util.Scanner;

/** 为了解决jvm在多线程中,优化了指令load的存在,只读取缓存的count的值,
 * 导致了t2在内存中修改count的值,t1读取不到,造成内存可见性问题;
 * 这个时候就要使用volatile 关键字,它是专门解决内存可见性问题的
 * 使数据变得"变化无常"jvm就不会优化它,这个时候t1就可以读取到
 * t2对它的修改了
 * * @author xiaoxie
 * @date 2024年03月30日 15:52
 */
public class Demo1 {
    public volatile static int count;
    public static void main(String[] args) {
        Thread t1 =new Thread(()->{
            while (count == 0) {

            }
            System.out.println("t1结束了");
        });
        Thread t2 = new Thread(()-> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入");
            count = scanner.nextInt();

        });
        t1.start();
        t2.start();
    }
}
