package demo1_图书管理系统;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-17
 * Time: 19:17
 */

import java.util.Scanner;

/** 管理员类，通过选择不同的角色然后多态实现这些每个角色不同的操作
 * * @author xiaoxie
 * @date 2023年12月17日 19:17
 */
public class Admin extends User{
    public Admin(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DeleteOperation(),
                new ShowOperation()
        };
    }

    public int menu() {
        System.out.println("********管理员菜单********");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("************************");
        System.out.println("请输入你的操作：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
