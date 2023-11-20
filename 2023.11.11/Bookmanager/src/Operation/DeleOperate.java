package Operation;

import Book.Book;
import Book.Booklist;
import User.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 0:04
 */
public class DeleOperate implements IOperate {
    @Override
    public void work(Booklist booklist) {
        System.out.println("请输入你要删除的书籍的书名：");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int User = booklist.getUser();
        // 检查图书是否已存在
        int idex = -1;
        int i = 0;
        for (; i < User; i++) {
            if (booklist.getBooks(i).getName().equals(name)) {
                idex = i;
                break;
            }
        }if(idex == -1) {
            System.out.println("没有这本书");
        }else{//说明找到了
            for (int j = idex; j < User-1; j++) {
                booklist.setBooks(booklist.getBooks(),j);
            }
            booklist.getBooks()[User] = null;
            booklist.setUser(User-1);
            System.out.println("删除成功");
            return;
        }
    }
}
