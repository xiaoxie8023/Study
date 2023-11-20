import java.lang.reflect.Array;
import java.io.*;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-02
 * Time: 23:35
 */
public class study {
    //从键盘输入a, b, c的值，编程计算并输出一元二次方程ax2 + bx + c = 0的根，
    // 当a = 0时，输出“Not quadratic equation”，当a ≠ 0时，
    // 根据△ = b2 - 4*a*c的三种情况计算并输出方程的根。
    //△ = 0，则两个实根相等，输出形式为：x1=x2=...。
    //△  > 0，则两个实根不等，输出形式为：x1=...;x2=...，其中x1  <=  x2。
    //△  < 0，则有两个虚根，则输出：x1=实部-虚部i;x2=实部+虚部i，
    // 即x1的虚部系数小于等于x2的虚部系数
    // 实部为0时不可省略。实部= -b / (2*a),虚部= sqrt(-△ ) / (2*a)
    //所有实数部分要求精确到小数点后2位，数字、符号之间没有空格。
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String arr = null;
            while ((arr = br.readLine()) != null) {
                String str[] = arr.split(" ");
                double a = Double.parseDouble(str[0]);
                double b = Double.parseDouble(str[1]);
                double c = Double.parseDouble(str[2]);
                double g = Math.pow(b, 2) - 4 * a * c;
                double x1 = 0.0;
                double x2 = 0.0;
                if (a == 0) {
                    System.out.println("Not quadratic equation");
                } else {
                    if (b == 0 && c == 0) {
                        System.out.println("x1=x2=0.00");
                    } else {
                        if (g == 0) {
                            x1 = (-b) / (2 * a);
                            System.out.println("x1=x2=" + String.format("%.2f", -b / (2 * a)));
                        } else if (g > 0) {
                            x1 = (-b - Math.sqrt(g)) / (2 * a);
                            x2 = (-b + Math.sqrt(g)) / (2 * a);
                            System.out.println("x1=" + String.format("%.2f",x1) + ";x2=" + String.format("%.2f", x2));
                        } else {
                            double x3 = 0.0;
                            double s = -b / (2 * a);//实部
                            x3 = Math.sqrt(-g) / (2 * a);//虚部
                            if (s > 0) {
                                System.out.println("x1=" + String.format("%.2f", s) + String.format("%.2f",x1) + "i;x2=" + String.format("%.2f", x3) + "+" + String.format("%.2f",x3) + "i");
                            } else {
                                if (s == -0.0) {
                                    s = 0.0;
                                }
                                System.out.println("x1=" + String.format("%.2f", s) + "-" + String.format("%.2f", x3) + "i;x2=" + String.format("%.2f",s) + "+" + String.format("%.2f", x3) + "i");
                            }
                        }
                    }
                }
            }
        }


    //牛牛有一个学习计划，他计划在 y 年 m 月 d 日开始学习，但在之前他是绝不会开始学习的
    // 但是他一旦开始学习就不会停下来，请你判断 y1 年 m1 月 d1 日牛牛应该学习吗。
    public static void main13(String[] args) {
        Scanner scan= new Scanner(System.in);
        int[] PlanStudy = new int[3];
        int[] StarStudy = new int[3];
        for (int i = 0; i < PlanStudy.length; i++) {
            PlanStudy[i] = scan.nextInt();
        }
        for (int i = 0; i < StarStudy.length; i++) {
            StarStudy[i] = scan.nextInt();
        }
        if(PlanStudy[0]<StarStudy[0]) {
            System.out.println("yes");
        } else if(PlanStudy[0]==StarStudy[0]) {
            if(PlanStudy[1]<StarStudy[1]) {
                System.out.println("yes");
            }else if(PlanStudy[1]==StarStudy[1]) {
                if(PlanStudy[2]<=StarStudy[2]) {
                    System.out.println("yes");
                }
            }else {
                System.out.println("no");
            }
        }else {
            System.out.println("no");
        }
    }
    public static void main12(String[] args) {
        Scanner scan= new Scanner(System.in);
        int[] YuanCoordinate = new int[2];
        int[] HouCoordinate = new int[2];
            for (int i = 0; i < 2; i++) {
                YuanCoordinate[i] = scan.nextInt();
            }
            for (int i = 0; i < 2; i++) {
                HouCoordinate[i] = scan.nextInt();
            }
            if(Math.abs((YuanCoordinate[0]-HouCoordinate[0])+(YuanCoordinate[1]-HouCoordinate[1]) )== 1) {
                if(YuanCoordinate[0]>HouCoordinate[0]) System.out.println( 'l');
                if(YuanCoordinate[0]<HouCoordinate[0]) System.out.println( 'r');
                if(YuanCoordinate[1]>HouCoordinate[1]) System.out.println( 'd');
                if(YuanCoordinate[1]<HouCoordinate[1]) System.out.println( 'u');
            }

    }
    //牛牛的通勤路上有两种选择，要么走路，要么打车，牛牛走路的速度是 1m/s 。打车的速度的 10m/s ，但是打车需要等出租车 10 s，请你计算牛牛想尽快到公司应该选择打车还是走路。
    public static void main11(String[] args) {
        Scanner scan= new Scanner(System.in);
        int l = scan.nextInt();
        if(l<=11) {
            System.out.println("w");
        }else {
            System.out.println("v");
        }
    }
    //牛牛正在寄快递，他了解到快递在 1kg 以内的按起步价 20 元计算，超出部分按每 kg 1元计算，不足 1kg 部分按 1kg计算。如果加急的话要额外付五元，请问牛牛总共要支付多少快递费
    public static void main10(String[] args) {
        Scanner scan= new Scanner(System.in);
        float a = scan.nextFloat();
        char b = scan.next().charAt(0);
        double prise = 0.0;
        if(a<=1) {
            prise = 20+(b == 'y'?5:0);
        }else {
            prise= (Math.ceil(a - 1)+20+(b == 'y'?5:0));
        }
        System.out.println(prise);
    }
    public static void main9(String[] args) {
        Scanner scan= new Scanner(System.in);
            double prise = scan.nextDouble();
            int month = scan.nextInt();
            int day = scan.nextInt();
            int coupon = scan.nextInt();
            if(month == 11 && day == 11) {
               prise *= 0.7;
               if(coupon == 1) {
                   prise -= 50;
               }
                }else if(month == 12 && day == 12) {
                prise *=0.8;
                if(coupon == 1) {
                    prise -= 50;
                }
            }
            prise=prise>0?prise:0;
            System.out.printf("%.2f",prise);

    }
        public static void main8(String args[]) throws IOException{
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            String str[]=bf.readLine().split(" ");
            int positive=0;
            int negative=0;
            int b[]=new int[str.length];
            for(int i=0;i<b.length;i++){
                b[i]=Integer.parseInt(str[i]);
            }
            for(int i=0;i<b.length;i++){
                if(b[i]>0){
                    positive++;
                }
                if (b[i]<0){
                    negative++;
                }
            }
            System.out.println("positive:"+positive);
            System.out.println("negative:"+negative);

        }
    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            if (a % 2 == 0)System.out.print(2 + " ");
            if (a % 3 == 0)System.out.print(3 + " ");
            if (a % 7 == 0)System.out.print(7);
            if (a % 2 != 0 && a % 3 != 0 && a % 7 != 0)System.out.print("n");
        }
    }

    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] grade = new double[n];
        for (int i = 0; i < grade.length; i++) {
            grade[i] = scan.nextDouble();
        }
        double max = 0.0;
        double min = 100.0;
        double avg = 0.0;
        double sum = 0.0;
        for (int i = 0; i < grade.length; i++) {
            if(grade[i] > max) {
                max = grade[i];
            }
            if(grade[i]<min) {
                min=grade[i];
            }
             sum += grade[i];
        }
        System.out.printf("%.2f %.2f %.2f\n", max, min, sum / n);
    }
    public static void main4(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int result = 2;
            if (n == 0) {
                result = 1;
            } else {
                for (int i = 1; i < n; i++) {
                    result <<= 1;
                }
            }
            System.out.println(result);
        }
    }
    public static void main3(String[] args) {
        //给定秒数 seconds ，把秒转化成小时、分钟和秒。
        Scanner scan = new Scanner(System.in);
        int seconds = scan.nextInt();
        int minutes = 0;
        int second = 0;
        int hours = seconds / 3600;
        seconds%=3600;
        minutes = seconds / 60;
        second = seconds % 60;
        System.out.println(hours + " " + minutes + " " + second);
    }
    public static void main2(String[] args) {
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            int N = scan.nextInt();
            int day = (x%7)+(N%7);
          if(day == 0) {
              System.out.println(7);
          }else {
              System.out.println(day);
          }
        }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int sum = x*100;
        System.out.println(sum);
    }
}
