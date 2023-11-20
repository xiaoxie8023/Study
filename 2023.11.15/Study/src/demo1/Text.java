package demo1;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-15
 * Time: 13:06
 */
class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override//重写tostring 方法
    public String toString() {
        return "姓名：" + this.name + " " + "年龄: " + this.age;
    }
}

public class Text {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] ch = str.toCharArray();
        int sign = 1;
        int start = 0;
        if (ch[0] == '+') {
            start = 1;
        } else if (ch[0] == '-') {
            start = 1;
            sign = -1;
        }

        int result = 0;
        for (int i = start; i < ch.length; i++) {
            if (!Character.isDigit(ch[i])) {
                return 0;
            }
            int digit = ch[i] - '0';
            result = result * 10 + digit;
        }

        return sign * result;
    }

    public static void main12(String[] args) {
        String s = "hello";
        s += " world";
        System.out.println(s); // 输出：hello world
    }

    public static void main11(String[] args) {
        String s1 = " hello world  xie      ";
        String s2 = s1.trim();//去掉字符串中的左右空格,保留中间空格
        System.out.println(s2);

    }

    //字符串截取
    public static void main10(String[] args) {
        String s1 = "helloworld";
        String s2 = s1.substring(5);
        System.out.println(s2);
    }

    //字符串拆分
    public static void main9(String[] args) {
        String s1 = "hello world hai xie";
        String[] s2 = s1.split(" ");//以空格划分
        for (String ss : s2) {
            System.out.println(ss);//字符串的部分拆分
        }
        System.out.println("------------------------------");
        String s3 = "192.168.1.1";
        String[] s4 = s3.split("\\.");//拆分IP地址
        for (String s5 : s4) {
            System.out.println(s5);
        }
        System.out.println("------------------------------");
        String str = "name=zhangsan&age=18";
        String[] result = str.split("&");
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split("=");
            System.out.println(temp[0] + " = " + temp[1]);
        }
        System.out.println("------------------------------");
        String[] S9 = str.split("=|&");// 如果一个字符串中有多个分隔符，可以用"|"作为连字符.
        for (String s10 : S9) {
            System.out.println(s10);
        }
    }

    // 字符串替换
    public static void main8(String[] args) {
        String s1 = "hello";
        String s2 = s1.replace(s1, "col");//替换字符串
        System.out.println(s2);
        String s3 = "hello222";
        String s4 = s3.replaceFirst(s3, "abcdefg");
        System.out.println(s4);
        String str = "helloworld";
        System.out.println(str.replaceAll("l", "_"));//把指定的字符串转换
        System.out.println(str.replaceFirst("l", "_"));//就把第一个字符串修改
    }

    //字符串的转换
    public static void main7(String[] args) {
        String s1 = String.valueOf(125);//整形转换为字符串当然其他基本数据类型也可以
        String s2 = String.valueOf(new Student("张三", 15).toString());//类也可以转换为字符串
        System.out.println(s1);
        System.out.println("------------------------------");
        System.out.println(s2);
        System.out.println("------------------------------");
        String s3 = "hello";
        System.out.println(s3.toUpperCase());//大小写转换
        String s4 = "HELLO";
        System.out.println(s4.toLowerCase());//大小写转换
        System.out.println("------------------------------");
        String s5 = "hello";
        char[] ch = s5.toCharArray();//字符串转换为数组
        for (char ch1 : ch) {
            System.out.println(ch1);
        }
        System.out.println("------------------------------");
        String s6 = String.format("%d-%d-%d", 2023, 11, 15);//格式化
        System.out.println(s6);
    }

    //字符串查找
    public static void main6(String[] args) {
        String s1 = "abctyiuoagq";
        System.out.println(s1.charAt(1));//返回index位置上字符，
        // 如果index为负数或者越界，抛出IndexOutOfBoundsException异常
        System.out.println("------------------------------");
        int ret = s1.indexOf('y');//返回ch第一次出现的位置，没有返回-1
        System.out.println(ret);
        System.out.println("------------------------------");
        System.out.println(s1.indexOf('i', 4));//从fromIndex位置开始找ch第一次出现的位置，没有返回-1
        System.out.println("------------------------------");
        System.out.println(s1.indexOf("tyi"));//返回str第一次出现的位置，没有返回-1 也可以从fromIndex位置开始找
        System.out.println("------------------------------");
        System.out.println(s1.lastIndexOf('a'));//从后往前找,也可以从fromIndex位置开始从后往前找,字符串也可以
        System.out.println("------------------------------");
    }

    //字符串的比较
    public static void main5(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);//为什么是false呢因为s1和s2的地址不一样它们都new了一个对象
        System.out.println("------------------------------");
        System.out.println(s1.equals(s2));
        System.out.println("------------------------------");
        String s3 = "hello";
        String s4 = "hello";
        System.out.println(s3 == s4);//为什么是true 呢这和常量池的概念有关先记住结论
        System.out.println("------------------------------");
        String s5 = "hello";
        String s6 = "aello";
        System.out.println(s5.compareTo(s6));//先按照字典次序大小比较，如果出现不等的字符，直接返回这两个字符的大小差值
        // 如果前k个字符相等(k为两个字符长度最小值)，返回值两个字符串长度差值
        System.out.println("------------------------------");
        String s7 = "hello";
        String s8 = "hz";
        System.out.println(s7.compareTo(s8));//先按照字典次序大小比较，如果出现不等的字符，直接返回这两个字符的大小差值
        System.out.println("------------------------------");
        String s9 = "hello";
        String s10 = "helloworld";
        System.out.println(s9.compareTo(s10));// 如果前k个字符相等(k为两个字符长度最小值)，返回值两个字符串长度差值
        System.out.println("------------------------------");
        String s11 = "abc";
        String s12 = "aBC";
        System.out.println(s11.compareToIgnoreCase(s12));//忽略大小写
    }

    //引用
    public static void main4(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1;//表示s3指向s1所指向的对象
        System.out.println(s1);
        System.out.println(s3);

    }

    //字符串的构造
    public static void main3(String[] args) {
        String s1 = new String("abc");
        String s2 = "abc";
        char[] ch = {'a', 'b', 'c'};//通过构造数组
        String s3 = new String(ch);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    //六进制
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        String hexadecimalNumber = "";

        while (n != 0) {
            long remainder = n % 6;
            hexadecimalNumber = remainder + hexadecimalNumber;
            n /= 6;
        }
        System.out.println(hexadecimalNumber);
    }

    //反向输出
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 1; i <= 4; i++) {
            System.out.print(num % 10);
            num /= 10;
        }
    }

}
