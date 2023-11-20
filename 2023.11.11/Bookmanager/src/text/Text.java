package text;
import Book.Booklist;
import User.User;
import java.util.Scanner;
import User.MonUser;
import User.MaNUser;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 22:32
 */
public class Text {
    public static User login() {
        System.out.println("请输入您的姓名：");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("请选择您的身份：1.图书管理员   2.普通用户——》");
        int choice = scan.nextInt();
        if(choice == 1) {
            return new MaNUser(name);
        }else {
           return new MonUser(name);
        }
    }
    public static void main(String[] args) {
        Booklist booklist = new Booklist();
        User user = login();
        while(true) {
            int choice = user.menu();
            user.DoWork(booklist,choice);
        }
    }
}
