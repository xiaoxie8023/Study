import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-10-29
 * Time: 22:57
 */
public class study {
    //将用户输入的六个数字填入数组并找出数组中最大值和最小值
    public static void main(String[] args) {
        int[] nums = new int[6];
        int max;
        int min;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <nums.length ; i++) {
            nums[i]=scanner.nextInt();
        }
        int temp_max = nums[0];
        int temp_min = nums[0];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] >= temp_max) {
                temp_max = nums[j];
            }
            if (nums[j] <= temp_min) {
                temp_min = nums[j];
            }
        }
        System.out.printf("%d %d", temp_max, temp_min);

    }

    public static void main10(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Haoin(n,"A","B","C");
    }
    public static void Haoin(int n,String s1,String s2,String s3) {
        if(n>0) {
            Haoin(n - 1, s1, s3, s2);
            MOVE(n, s1, s3);
            Haoin(n - 1, s2, s3, s1);
        }
    }
    public static void MOVE(int n ,String p1,String p2) {
        System.out.println("第"+n+"个盘子"+"从"+p1+"->"+p2);
    }





    public static void main9(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = fib(n);
        System.out.println(ret);
    }
    public static int fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = Sum(n);
        System.out.println(n+"的各数相加和为"+ret);
    }
    public static int Sum(int n) {
        if(n < 10) {
            return n;
        }

        return n%10+Sum(n/10);


    }
    public static void main7(String[] args) {
        int n = 123456;
        print(n);
    }
    public static void print(int n) {
        if(n<10) {
            return;
        }
       print(n%10);
        System.out.println(n);
        n/=10;

    }
    public static void main6(String[] args) {
        int n = 10;
        int ret = add(n);
        System.out.println("1-10相加的和为："+ret);
    }
    public static int add(int n) {
        if(n == 1) {
            return n;
        }
        return n+add(n-1);
    }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = fac(n);
        System.out.println(n+"的阶乘为："+ret);
    }
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }

        return n*fac(n-1);
    }
    public static void main4(String[] args) {
        int n = 6;
        haoin(6, "A","B","C");
    }
    public static void haoin(int n,String s1,String s2,String s3) {
        if(n == 1) {
            move(s1,s3);
            return;
        }
        haoin(n-1,s1,s3,s2);
        move(s1,s3);
        haoin(n-1,s2,s1,s3);
    }
    public static void move(String m1,String m2) {
        System.out.println(m1+"->"+m2+" ");
    }
    public static void main3(String[] args) {
        Random random = new Random();
        int Rannum = random.nextInt(100);
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入你要猜的数字");
            int num = scan.nextInt();
            if(num>Rannum) {
                System.out.println("猜大了");
            } else if(num<Rannum) {
                System.out.println("猜小了");
            } else {
                System.out.println("恭喜你，猜对了");
                break;
            }
        }


    }
    public static void main2(String[] args) {

            int n = 11;
            //奇数位
            for (int i = 30; i >= 0; i -= 2) {
                System.out.print(((n >> i) & 1)+" ");
            }
            System.out.println();
            //偶数位
            for (int i = 31; i >= 1; i -= 2) {
                System.out.print( ((n >> i) & 1)+" ");
            }
        }
        //二进制数有几个1
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int n = scan.nextInt();
        while(n!=0) {
            n=n & (n-1);
            count++;
        }
        System.out.println(count);
    }


}
