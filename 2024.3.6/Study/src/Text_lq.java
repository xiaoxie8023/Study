/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-10
 * Time: 16:36
 */

import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年03月10日 16:36
 */
public class Text_lq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int mod = 1000000007;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i >= a) {
                dp[i] = (dp[i] + dp[i - a]) % mod;
            }
            if (i >= b) {
                dp[i] = (dp[i] + dp[i - b]) % mod;
            }
            if (i >= c) {
                dp[i] = (dp[i] + dp[i - c]) % mod;
            }
        }

        System.out.println(dp[n]);
    }
    public static void main10(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 计算并输出结果
        long result = climbStairs(n, a, b, c);
        System.out.println(result);

        scanner.close();
    }

    /**
     * 计算到达第n级台阶的方案数，对1000000007取模
     */
    public static long climbStairs(int n, int a, int b, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 1; // 初始条件，到达第0级台阶有一种方案（不走）

        // 动态规划计算
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - a] + dp[i - b] + dp[i - c]) % MOD;
        }

        return dp[n] % MOD; // 返回结果并对1000000007取模
    }

    // 模数常量
    private static final long MOD = 1000000007L;

    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // Consume newline after rows and cols input
        char[][] matrix = new char[rows][cols];

        // Read the character matrix
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        int maxLength = findMaxY(matrix);
        System.out.println(maxLength);
    }

    private static int findMaxY(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max_length = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                char currentChar = matrix[i][j];
                if (matrix[i - 1][j - 1] == currentChar &&
                        matrix[i - 1][j] == currentChar &&
                        matrix[i][j + 1] == currentChar) {
                    int leftDiagonalLength = 1;
                    int rightDiagonalLength = 1;
                    int horizontalLength = 1;

                    while (i - leftDiagonalLength >= 0 && j - leftDiagonalLength >= 0 &&
                            matrix[i - leftDiagonalLength][j - leftDiagonalLength] == currentChar) {
                        leftDiagonalLength++;
                    }
                    while (i - rightDiagonalLength >= 0 && j + rightDiagonalLength < cols &&
                            matrix[i - rightDiagonalLength][j + rightDiagonalLength] == currentChar) {
                        rightDiagonalLength++;
                    }
                    while (i - horizontalLength >= 0 && matrix[i - horizontalLength][j] == currentChar) {
                        horizontalLength++;
                    }
                    max_length = Math.max(max_length, Math.min(leftDiagonalLength, Math.min(rightDiagonalLength, horizontalLength)));
                }
            }
        }
        return max_length;
    }

    public static int checkYLength(char[][] matrix, int i, int j, int n, int m) {
        int length = 0;
        while (i < n && j >= 0 && j < m && matrix[i][j] == matrix[i+1][j] && matrix[i+1][j] == matrix[i+1][j-1] && matrix[i+1][j] == matrix[i+1][j+1]) {
            length++;
            i++;
            j--;
            j++;
        }
        return length;
    }
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxMin = Integer.MIN_VALUE;
        int minMax = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                maxMin = Math.max(maxMin, arr[i]);
            }
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                minMax = Math.min(minMax, arr[i]);
            }
        }

        System.out.println(maxMin + " " + minMax);
    }
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (digit % 2 != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3])) + 1;
        }

        System.out.println(dp[n]);
    }
    public static void main4(String[] args) {
        int count = 0;
        for (int i = 1; i <= 1000000; i++) {
            if(isNum(i) && is23(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean isNum(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static boolean is23(int num) {
        int sum = 0;
        while (num > 0) {
            sum +=  num % 10;
            num /= 10;
        }
        if(sum == 23) {
            return true;
        }
        return false;
    }
    public static void main2(String[] args) {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100 ; j++) {
                if(i-j >= 10){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    /**
     * 2023有几个约数
     * @author xiaoxie
     * @date 2024/3/10 16:40
 * @param args
     */
    public static void main1(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2023; i++) {
            if(2023 % i == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
