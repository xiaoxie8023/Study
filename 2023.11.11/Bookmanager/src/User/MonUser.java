package User;

import Operation.*;

import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 23:14
 */
public class MonUser extends User {
    public MonUser(String name) {
        super(name);
        this.iOperates = new IOperate[]{
                new ExitOperate(),
                new FindOperate(),
                new BorOperate(),
                new RetOperate(),
                new ShowOperate()
        };
    }
    @Override
    public int menu() {
            System.out.println("******图书管理系统*****");
            System.out.println("******1.查找图书******");
            System.out.println("******2.借阅图书******");
            System.out.println("******3.归还图书******");
            System.out.println("******4.显示图书******");
            System.out.println("******0.退出系统******");
            System.out.println("********************");
            System.out.println("请输入您的操作-》");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
    }
}
