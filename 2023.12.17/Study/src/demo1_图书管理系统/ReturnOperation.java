package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 22:49
 */

import java.util.Scanner;

/** * @author xiaoxie
 * @date 2023年12月17日 22:49
 */
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要归还的图书名字:");
        String name = scan.nextLine();
        int count = bookList.getSize();
        int i = 0;
        for (; i < count; i++) {
            if (bookList.getList(i).getName().equals(name) ) {
                bookList.getList(i).setBorrowed(false);
                System.out.println("归还成功，欢迎下次光临");
                return;
            }
        }
        if(i == count) {
            System.out.println("没有找到这本书");
        }
    }
}
