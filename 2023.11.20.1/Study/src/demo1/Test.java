package demo1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:JAVASE复习
 * User: 谢忠涵7
 * Date: 2023-11-20
 * Time: 15:25
 */
/*
 *二分查找红蓝二分查找
 * @author xiaoxie
 * @date 2023/11/20 22:05
 * @param 力扣https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @return null
 */

class Solution {
    public int searchRangeLeft(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int searchRangeRight(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = searchRangeLeft(nums, target);
        int rightIndex = searchRangeRight(nums, target);
        if (leftIndex >= rightIndex && leftIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{rightIndex, leftIndex};
        }
        return new int[]{-1, -1};
    }
}

class UserPasswordException extends Exception {
    public UserPasswordException(String message) {
        super(message);
    }
}

/*
 *使用红蓝二分查找方法来解
 * @author xiaoxie
 * @date 2023/11/20 22:34
 * @param 来自https://leetcode.cn/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/力扣1498
 * @return int[]
 */
class Solution2 {
    private static final long MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        Long[] arr = new Long[nums.length];
        long ans = 0;
        arr[0] = (long) 1;
        for (int i = 1; i < nums.length; i++) {
            arr[i] = (arr[i - 1] << 1) % MOD;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = nums.length;
            while (left + 1 != right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] + nums[i] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (nums[left] + nums[i] <= target) {
                ans = (ans + arr[left - i]) % MOD;
            }
        }
        return (int) ans;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {2,3,3,4,6,7};
        int a = 12;
        Solution2 s2 = new Solution2();
        System.out.println(s2.numSubseq(num, a));
        System.out.println(Arrays.toString(s.searchRange(num, a)));
    }

    /*
     * 异常的运行时错误
     * @author xiaoxie
     * @date 2023/11/20 21:05
     * @param 运行时异常
     * @return void
     */
    public static void func() {
        //算数异常
        System.out.println(10 / 0);
    }

    /*
     * 异常的运行时错误
     * @author xiaoxie
     * @date 2023/11/20 21:08
     * @param 空指针异常
     * @return void
     */
    public static void func1() {
        int[] arr = null;
        System.out.println(arr.toString());
    }

    /*
     *finally的使用
     * @author xiaoxie
     * @date 2023/11/20 21:18
     * @param null,
     * @return null
     */
    public static void func2() {
        int[] arr = null;
        System.out.println(arr.toString());
    }

    public static void func(String possword) throws UserPasswordException {
        System.out.println("请输入密码: ");
        Scanner scan = new Scanner(System.in);
        String s = new String();
        s = scan.nextLine();
        if (s.equals(possword)) {
            System.out.println("密码正确");
        } else {
            throw new UserPasswordException("用户密码输入错误");
        }
    }

    public static void main1(String[] args) {
       /* try {
            func2();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }finally {
            System.out.println("你好呀🐖");
        }
        System.out.println("你可以看到我吗");*/
        //func();
        //func1();

        String possword = "123456";
        try {
            func(possword);
        } catch (UserPasswordException e) {
            e.printStackTrace();
        }
    }
}




