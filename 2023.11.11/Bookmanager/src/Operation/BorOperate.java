package Operation;

import Book.Book;
import Book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 10:22
 */
public class BorOperate implements IOperate {

    @Override
    public void work(Booklist booklist) {
        System.out.println("请输入你要借的图书");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int User = booklist.getUser();
        for (int i = 0; i < User; i++) {
            Book book = booklist.getBooks(i);
            if (book.getName().equals(name)) {
                System.out.println("成功借阅!" );
                booklist.getBooks(i).setIsborrow(true);
                return;
            }
        }
    }
}
