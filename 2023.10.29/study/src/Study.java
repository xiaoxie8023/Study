import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-10-28
 * Time: 21:21
 */
/*import java.util.Scanner;
//一球从h米高度自由落下，每次落地后反弹回原高度的一半再落下，求它在第n次落地时共经过了多少米？第n次反弹多高？
public class study {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        float H = scanner.nextFloat();
        int n=scanner.nextInt();
        float ret=alenth(H,n);
        System.out.println(ret);
    }
    public static float alenth(float H,int n) {
        if (n==0) {
            return 0;
        } else {
            return H+2*alenth((float)(H/2.0),n-1);
        }
    }
}*/
/*import java.text.DecimalFormat;
import java.util.Scanner;
public class study {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double H = scanner.nextFloat();
        int n = scanner.nextInt();
        double totalDistance = RoundHeight(H, n)-reboundHeight(H, n);
        double  nthReboundHeight = reboundHeight(H, n);
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println("第" + n + "次落地时共经过了" + df.format(totalDistance) + "米");
        System.out.println("第" + n + "次反弹的高度为" + df.format(nthReboundHeight) + "米");
    }
//使用递归调用
    public static double RoundHeight(double  H, int n) {
        if (n == 0) {
            return 0;
        } else {
            return  H+2*RoundHeight(H / 2.0, n - 1);
          }
    }

    //计算小球的反弹高度
    public static double reboundHeight(double H, int n) {
        if (n == 0) {
            return H;
        } else {
            return H / (float) Math.pow(2, n);
        }
    }
}*/
/*
import java.text.DecimalFormat;
import java.util.Scanner;
public class study {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double H = scanner.nextFloat();
        int n = scanner.nextInt();
        double sum = 0.0;
        for(int i = 0;i<n;i++) {
            sum+=1.5*H;
            H /= 2;
        }
        sum-=H;
        System.out.println(String.format("%.3f",H)+" "+String.format("%.3f", sum));

    }
}*

 */
/*
public class Study {
    public static void main8(String[] args) {
        for(int i = 1;i<=100;i++) {
            if(i % 3 == 0&& i % 5 == 0) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}
*/
/*
import java.util.Scanner;
//键盘输入任意多个10000以内正整数（负数代表结束），求出它们的平均数，
public class Study {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double avg = 0.0;
        int count = 0;
        double sum = 0.0;
        while(true) {
            int num=scanner.nextInt();
            if(num<0) {
               break;
            } else {
                count++;
                 sum += num;
            }
            avg=sum/count;
        }
        System.out.printf("%.2f%n",avg);

    }
}
*/
/*
public class Study {

    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();
        int count = 0;
        if(num<=0) {
            System.out.println(num);
        } else {
            while (num != 0) {
                num /= 10;
                count++;
            }
            System.out.println(count);
        }
    }
}*/
/*
public class Study {
    public static void main(String[] args) {
       // Scanner scan = new Scanner(System.in);
        //int num = scan.nextInt();
        int m = 123%10;
        System.out.println(m);
*/
      /*  while(num!=0) {
            num=num%10;
            System.out.println(num);
        }
    }*/
   /* public static void main3(String[] args) {
        double sum = 0.0;
        int flag = 1;
        for(int i = 1;i<=100;i++) {
            sum+=flag*(1.0/i);
            flag=-flag;
        }
        System.out.println(sum);
    }
}*/
//

public class Study {
    //求两个数之间的最大公约数
    public static void main18(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入两个整数");
        try {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int ret = CommonDivisor(a, b);
            System.out.println("最大公约数为：" + ret);
        } catch (InputMismatchException e) {
            System.out.println("输入错误，请输入整数！");
        } finally {
            scan.close();
        }
    }
    //使用辗转相除法求最大公约数 n  m     24   18
    //                      m  n%m   18   6
    //                      m  n%m   6    0
    //可以使用递归
    public static int CommonDivisor(int n,int m) {
        if(m==0) {
            return n;
        } else {
            return CommonDivisor(m,n%m);
        }
    }




    //输出0-99999999之间的自恋数如：三阶的水仙花数：153=1^3+5^3+3^3
    public static void main12(String[] args) {
        int x = 0;
        for (int i = 1; i <= 9999999; i++) {
            int sum = 0;
            int count = 0;
            int temp = 0;
            temp = i;
            while (temp != 0) {
                temp /= 10;
                count++;
            }
            temp = i;
            while (temp != 0) {
                sum += Math.pow(temp % 10, count);
                temp /= 10;
            }
            if (i == sum) {
                x++;
                System.out.println(i);

            }
        }
        System.out.println("一共有："+x+"个自恋数");

    }


    //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
    public static void main11(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int a = scan.nextInt();;
        int b = scan.nextInt();;
        System.out.println("请输入三个小数");
        double c = scan.nextDouble();
        double d= scan.nextDouble();
        double e= scan.nextDouble();
        int ret1 = MAX(a,b);
        double ret2 = MAX(c,d,e);
        System.out.println("两个整数最大值为："+ret1);
        System.out.println("三个小数最大值为："+ret2);
    }
    public static int MAX(int x, int y) {
        return x*y;
    }
    public static double MAX(double x,double y,double z) {
        return x+y+z;
    }



    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static void main9(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int a = scan.nextInt();;
        int b = scan.nextInt();;
        System.out.println("请输入三个小数");
        double c = scan.nextDouble();
        double d= scan.nextDouble();
        double e= scan.nextDouble();
        int ret1 = ADD(a,b);
        double ret2 = ADD(c,d,e);
        System.out.println("两个整数和为："+ret1);
        System.out.println("三个小数和为："+ret2);
    }
    public static int ADD(int x, int y) {
        return x+y;
    }
    public static double ADD(double x,double y,double z) {
        return x+y+z;
    }




    //斐波那契数列
    public static void main8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = Fibonacci(n);
        System.out.println("第n项为："+ret);
    }
    public static int Fibonacci(int n) {

        if(n==1||n==2) {
            return 1;
        } else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
    //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
    //
    //   要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int ret2 = Max2(a,b);
        int ret3 = Max2(a,b,c);
        System.out.println("a和b的最大值为"+ret2);
        System.out.println("三个数的最大值为"+ret3);
    }
    public static int Max2(int x,int y) {
        return x>y?x:y;
    }
    public static int Max2(int x,int y,int z) {
        return Max2(x,y)>z?Max2(x,y):z;
    }








 //密码匹配
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        String possword = "123456";
        int count = 0;
        while(count<3) {
            System.out.println("请输入密码：");
            String n = scan.nextLine();
            if (n.equals(possword)) {
                System.out.println("登入成功");
                count++;
                break;
            } else {
                System.out.println("登入失败，请重新登入");
                count++;
            }
        }
        System.out.println("退出程序");
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (num != 0) {
            int tmp = 0;
            tmp = num % 10;
            num /= 10;
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

}

