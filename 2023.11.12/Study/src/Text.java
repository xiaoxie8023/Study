import java.util.Scanner;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-12
 * Time: 16:12
 */
public class Text {
    public static void main3(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BigInteger[][] num = new BigInteger[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                num[i][j] = scan.nextBigInteger();
            }
        }
        for (int i = 0; i < n; i++) {
            BigInteger a = BigInteger.valueOf(0);
            a = BigInteger.valueOf(num[i][0].modPow(num[i][1], num[i][2]).longValue());
            System.out.println(a);
        }
    }



    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[][] num = new long[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                num[i][j] = scan.nextLong();
            }
        }
        for (int i = 0; i < n; i++) {
            long a = (long)(Math.pow(num[i][0],num[i][1]) %num[i][2]);
            System.out.println(a);
            }
        }*/
    public static int search(int[] nums, int target) {
        int left = nums.length - 1;
        int right = 0;
        int mid = 0;
        while (left >= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                left = mid - 1;
            } else if (nums[mid] < target) {
                right = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
        int target = 13;
        int ret = search(nums, target);
        System.out.println(ret);
    }
}
