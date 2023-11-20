package Operation;

import Book.Book;
import Book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 10:24
 */
public class RetOperate implements IOperate {
    @Override
    public void work(Booklist booklist) {
        System.out.println("请输入你要归还的图书书名：");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int User = booklist.getUser();
        for (int i = 0; i < User; i++) {
            Book book = booklist.getBooks(i);
            if (book.getName().equals(name) && book.getisIsborrow() == true) {
                System.out.println("成功归还!");
                booklist.getBooks(i).setIsborrow(false);
                return;
            }
        }
        System.out.println("没有这本书");
    }
}
