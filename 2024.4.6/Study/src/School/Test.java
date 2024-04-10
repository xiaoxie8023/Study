package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-07
 * Time: 8:36
 */

import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年04月07日 8:36
 */

public class Test{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请选择要计算的内容：");
        System.out.println("1. 计算圆的面积和周长");
        System.out.println("2. 计算两个整数的和");

        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("请输入圆的半径：");
            double radius = input.nextDouble();

            double area = Math.PI * radius * radius;
            double circumference = 2 * Math.PI * radius;

            System.out.println("圆的面积为：" + area);
            System.out.println("圆的周长为：" + circumference);
        } else if (choice == 2) {
            System.out.print("请输入第一个整数：");
            int num1 = input.nextInt();

            System.out.print("请输入第二个整数：");
            int num2 = input.nextInt();

            int sum = num1 + num2;

            System.out.println("两整数之和为：" + sum);
        } else {
            System.out.println("输入无效，请重新运行程序并输入有效选项。");
        }

        input.close();
    }
    }
