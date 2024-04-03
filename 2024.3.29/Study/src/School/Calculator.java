package School;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-03
 * Time: 16:42
 */

/** * @author xiaoxie
 * @date 2024年04月03日 16:42
 */
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        System.out.println('A'-'A');
    }
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请选择要计算的功能：");
        System.out.println("1. 计算圆的面积和周长");
        System.out.println("2. 计算两个整数的和");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("请输入圆的半径：");
            double r = input.nextDouble();

            double area = Math.PI * r * r;
            double c= 2 * Math.PI * r;

            System.out.println("圆的面积为：" + area);
            System.out.println("圆的周长为：" + c);
        } else if (choice == 2) {
            System.out.print("请输入第一个整数：");
            int num1 = input.nextInt();
            System.out.print("请输入第二个整数：");
            int num2 = input.nextInt();
            int sum = num1 + num2;
            System.out.println("两整数之和为：" + sum);
        } else {
            System.out.println("无效的选择");
        }
    }
}