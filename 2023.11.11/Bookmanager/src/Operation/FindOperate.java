package Operation;

import Book.Book;
import Book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 0:04
 */
public class FindOperate implements IOperate{
    @Override
    public void work(Booklist booklist) {
        System.out.println("请输入你要查找的书名");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int User = booklist.getUser();
        for (int i = 0; i < User; i++) {
             Book book = booklist.getBooks(i);
           if(book.getName().equals(name)) {
               System.out.println("找到了!"+book.toString());
               return;
           }
        }
        System.out.println("没有你要找的这本书！");
    }
}
