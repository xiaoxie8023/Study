import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-10-28
 * Time: 11:06
 */
public class Study {
    public static void main(String[] args) {

    }

        public static void main3(String[] args) {
            for(int i = 1; i <= 9; i++){
                for(int j = 1; j <= i; j++){
                    String result = String.format("%-2d*%-2d=%-2d", j, i, (i * j));
                    System.out.print(result + "  ");
                }
                System.out.println();
            }
        }
    public static void main2(String[] args) {
        Scanner console = new Scanner(System.in);
        int m = console.nextInt();
        int n = console.nextInt();
        int result = getCM(m, n);
        System.out.println(result);
    }
    public static int getCM(int m,int n) {
        return (m*n)/gcd(m,n);
    }
    public static int gcd(int m,int n) {
        if(n==0) {
            return m;
        } else {
            return gcd(n,m%n);
        }

    }
}
