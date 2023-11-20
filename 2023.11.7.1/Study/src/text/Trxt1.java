package text;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-07
 * Time: 22:52
 */
public class Trxt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.close();
        int result = determineRadix(p, q, r);
        System.out.println(result);
    }
    private static int determineRadix(int p, int q, int r) {
        int radix = 2;
        while (radix <= 16) {
            int pInRadix = convertToGivenBase(p, radix);
            int qInRadix = convertToGivenBase(q, radix);
            int rInRadix = convertToGivenBase(r, radix);
            if (pInRadix * qInRadix == rInRadix) {
                return radix;
            }

            radix++;
        }

        return 0;
    }
    private static int convertToGivenBase(int number, int radix) {
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
}


