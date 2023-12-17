package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 22:37
 */

import java.util.Scanner;

/** 借出书籍
 * * @author xiaoxie
 * @date 2023年12月17日 22:37
 */
public class BorrowedOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scan = new Scanner(System.in);
        int count1 = bookList.getSize();
        System.out.println("以下是图书馆的书单: ");
        for (int i = 0; i < count1; i++) {
            if (bookList.getList(i) != null) {
                System.out.println(bookList.getList(i));
            }
        }
        System.out.println("请输入你要借阅的图书名字:");
        String name = scan.nextLine();
        int count = bookList.getSize();
        int i = 0;
        for (; i < count; i++) {
            if (bookList.getList(i).getName().equals(name) ) {
                if(bookList.getList(i).isBorrowed()  ) {
                    System.out.println("书已被借走，请等归还后再来借阅");
                    return;
                }
                bookList.getList(i).setBorrowed(true);
                System.out.println("借阅成功，请于7天时间内归还");
                return;
            }
        }

        if(i == count) {
            System.out.println("没有找到这本书");
        }
    }
}
