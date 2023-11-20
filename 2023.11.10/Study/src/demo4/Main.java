package demo4;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:洛谷题
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 21:05
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String q = scan.next();
        String p = scan.next();
        String r = scan.next();
        System.out.println(exchange(q, p, r));
    }

    public static int conversion(String q, int r) {
        int number = 0;
        int n = 0;
        for (int i = q.length() - 1; i >= 0; i--) {
            int x = Integer.parseInt(q.charAt(i) + ""); // 将字符串q的第i个字符转换为整数
            if (x >= r) {
                return -1; //
            }
            number += x * Math.pow(r, n); // 将转换后的数字按照进制转换为十进制
            n++;
        }
        return number; // 返回转换后的十进制数
    }
    public static int exchange(String q, String p, String r) {
        for (int i = 2; i < 17; i++) {
            double a = conversion(q, i);
            double b = conversion(p, i);
            double c = conversion(r, i);
            if (a != -1 &&b != -1 && c != -1) { // 如果转换结果均不为-1
                if (a * b == c) {
                    return i;
                }
            }
        }
        return 0;
    }
}
