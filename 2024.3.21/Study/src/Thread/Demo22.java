package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-28
 * Time: 21:45
 */

import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年03月28日 21:45
 */
public class Demo22 {
    public static int count = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           while (count == 0){
               System.out.println("t111");
           }
            System.out.println("t1结束");
        });
        Thread t2 = new Thread(()->{
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入一个数");
            count = scan.nextInt();
        });
        t1.start();
        t2.start();
    }
}
