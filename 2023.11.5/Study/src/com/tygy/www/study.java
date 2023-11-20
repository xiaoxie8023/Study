package com.tygy.www;
import java.io.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-05
 * Time: 10:12
 */
import java.util.Arrays;
import java.util.Scanner;
public class study {
    public static void main(String[] args) {

    }
    public static void main15(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int count = 0 ;
        while(n != 1 ) {
            if(n % 2 == 0){
                n /= 2;
                count++;
            }else {
                n =n*3+1;
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main12(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n/=10;
        }
        System.out.println(sum);
    }

    public static void main11(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum +=(i*(i+1))/2;
        }
        System.out.println(sum);
    }
    public static void main10(String[] args) {
        //输入一个整数n,计算 1+1/（1-3）+1/（1-3+5）+...+1/(1-3+5-...((-1)^(n-1))*(2n-1))的值
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        double a=0.0;
        double b=0.0;
        for(int i=1;i<=n;i++){
            b=b+Math.pow(-1,i-1)*(2*i-1);
            a=a+1.0/b;
        }
        System.out.printf("%.3f",a);

    }
    public static void main9(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arry = new int[n];
        double sum = 0.0;
        for (int i = 0; i < arry.length; i++) {
            arry[i] = i+1;
        }
        for (int i = 0; i < arry.length; i++) {
            sum+=1.0/arry[i];

        }
        System.out.printf("%.6f",sum);
    }
    public static void main8(String[] args) {
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.printf("%d*%d=%2d ",j,i,i*j);
            }
            System.out.println();
        }
    }
    public static void main7(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arry = new int[n];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arry.length; i++) {
            arry[i] = i;
        }
        for (int i = 0; i < arry.length; i++) {
            if(arry[i] % 2 == 0) {
                count1++;
            }else {
                count2++;
            }
        }
        System.out.println(count1+" "+count2);
    }
    public static void main6(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long sum=(1+n)*n/2;
        System.out.println(sum);
    }
    public static void main5(String[] args) {
       String[] arry1 = new String[11];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arry1.length; i++) {
            arry1[i] = scanner.nextLine();
        }
        Arrays.sort(arry1);
        System.out.println(Arrays.toString(arry1));
       /* int[] arry2 = new int[9];

        for (int i = 0; i < arry2.length; i++) {
             sum+= (arry2[i]*i);
        }
        if(sum/ arry2.length == arry2[arry2.length-1]) {
            System.out.println("Right");
        }

*/
    }
    public static void main4(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = null;
        while ((arr = br.readLine()) != null) {
            String str[] = arr.split(" ");
            int y = Integer.parseInt(str[0]);
            int math = Integer.parseInt(str[1]);
            int English = Integer.parseInt(str[2]);
            if((y+math+English)/3 >=60) {
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = null;
        int day = 0;
        while ((arr = br.readLine()) != null) {
            String str[] = arr.split(" ");
            int year = Integer.parseInt(str[0]);
            int month = Integer.parseInt(str[1]);
            if(((year % 4 ==0 && year % 100 !=0)||year % 400 == 0)&&month == 2) {
                day = 29;
            }else {
                if(month == 2) {
                    day = 28;
                }
            }
            if(month ==1 ||month ==3 ||month == 5 ||month == 7 ||month == 8||month == 10||month == 12 ) {
                day = 31;
            }else {
                if(month != 2) {
                    day = 30;
                }
            }
            System.out.println(day);
        }

    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Data data = new Data(x, y);
            System.out.println(data.getX() + data.getY());
            }
        }

    }

    class Data {

        private int x;
        private int y;

       public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }

       public int getX() {
            return x;
        }

       public int getY() {
            return y;
        }

    }

