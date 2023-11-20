/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-10-31
 * Time: 12:48
 */
import java.util.Arrays;
import java.util.Scanner;

public class study {
        public static void main(String[] args) {
            int length = 168; // 长方形的长度
            int width = 64; // 长方形的宽度
            int maxSquareSize = divideRectangle(length, width); // 调用分割长方形的方法

            System.out.println("最大正方形的边长为: " + maxSquareSize);
        }

        // 分割长方形的方法
        public static int divideRectangle(int length, int width) {
            // 如果长度和宽度相等，则直接返回边长
            if (length == width) {
                return length;
            }

            // 找到较大的一边和较小的一边
            int maxSide = Math.max(length, width);
            int minSide = Math.min(length, width);

            // 计算较大一边除以较小一边的商和余数
            int quotient = maxSide / minSide;
            int remainder = maxSide % minSide;

            // 如果余数为0，则表示可以整除，最大正方形边长为较小一边
            if (remainder == 0) {
                return minSide;
            }
            // 递归调用分割长方形的方法，对剩余部分进行分割
            return divideRectangle(minSide, remainder);
        }


    public static void main3(String[] args) {
        int[] arr = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        for(int j = 0;j<=2;j++) {
            int temp = arr[5-j];
            arr[5-j] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        int[][] arr={{25,63,87,78},{12,36,98,78},{45,36,52,5}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum+=arr[i][j];
            }

        }
        System.out.println(sum);
    }
}
