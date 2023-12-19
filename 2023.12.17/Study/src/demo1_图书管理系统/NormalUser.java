package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 19:26
 */

import java.util.Scanner;

/** 普通用户类，通过选择不同的角色然后多态实现这些每个角色不同的操作
 * * @author xiaoxie
 * @date 2023年12月17日 19:26
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
       this.iOperations = new IOperation[] {
               new ExitOperation(),
               new  FindOperation(),
               new BorrowedOperation(),
               new ReturnOperation()
       };
    }
    @Override
    public int menu() {
        System.out.println("********普通用户菜单********");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("***************************");
        System.out.println("请输入你的操作：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
