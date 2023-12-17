package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 22:29
 */

import java.util.Scanner;

/** 通过图书的名字来查找图书
 * * @author xiaoxie
 * @date 2023年12月17日 22:29
 */
public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要查找的图书名字");
        String name = scan.nextLine();
        int count = bookList.getSize();
        int i = 0;
        for (; i < count; i++) {
            if(bookList.getList(i).getName().equals(name)) {
                System.out.println("图书信息如下：");
                System.out.println(bookList.getList(i));
                break;
            }
        }
        if(i == count) {
            System.out.println("没有找到这本书");
        }
    }
}
