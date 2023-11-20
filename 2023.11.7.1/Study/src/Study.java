import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-07
 * Time: 17:31
 */
public class Study {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p= in.nextInt();
        int q = in.nextInt();//乘数
        int r = in.nextInt();//积
        int n = 2;//进制数
        int ret = Binary(p, q, r, n);
        System.out.println(ret);
    }

    public static int Binary(int p,int q, int r, int n) {
        if (n > 16) {
            return 0;
        } else {
            //更新数字
            int p2 = newnnum(p, n);
            int q2 = newnnum(q, n);
            int r2 = newnnum(r, n);
            if (p2 * q2 == r2) {
                return n;
            }
            return Binary(p2, q2, r2, n + 1);
        }
    }

    private static int newnnum(int number, int radix) {
        String strNumber = Integer.toString(number);
        int length = strNumber.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(strNumber.charAt(length - i - 1));
            int power = calculatePower(radix, i);
            sum += digit * power;
        }

        return sum;
    }
    private static int calculatePower(int base, int exponent) {
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }


    /*  public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
         int p = in.nextInt();//乘数
          int q = in.nextInt();//乘数
          int r = in.nextInt();//积
          int n = 2;
          int ret = Binary(p,q,r,n);
          System.out.println(ret);
      }

     public static int Binary(int p,int q,int r,int n) {
          if(n >16) {
              return 0;
          } else {
              //更新数字
              int p2 = newnnum(p,n);
              int q2 = newnnum(q,n);
              int r2 = newnnum(r,n);
             if(p2 * q2 == r2) {
                 return n;
             }
              return Binary(p, q, r, n+1);
          }
      }
      public static int newnnum(int num, int base) {
          int result = 0;
          int multiplier = 1;
          while (num > 0) {
              result += num % (base * multiplier);
              num /=base;
              multiplier *= 10;
          }
          return result;
      }*/
    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] A = new int[n][m];
        int[][] B = new int[m][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                B[i][j] = in.nextInt();
            }
        }
        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int x = 0; x < m; x++) {
                    C[i][j] += A[i][x] * B[x][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        double avg = 0.0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
            sum += a[i];
        }
        avg = sum * 1.0 / a.length;
        System.out.printf("%d %.5f", sum, avg);

    }

    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] a = new double[n];
        double avg = 0.0;
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextDouble();
            sum += a[i];
        }
        avg = sum / a.length;
        System.out.printf("%.3f", avg);

    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0.0;
        int count = 0;
        while (scan.hasNextByte()) {
            byte age = scan.nextByte();
            sum += age;
            count++;
        }
        double averageAge = sum / count;
        System.out.printf("%.2f", averageAge);
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[1];
        int[] b = new int[1];
        int sum = 0;
        for (int i = 0; i < 1; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 0; i < 1; i++) {
            b[i] = scan.nextInt();
        }
        sum = a[0] + b[0];
        System.out.println(sum);
    }
}
