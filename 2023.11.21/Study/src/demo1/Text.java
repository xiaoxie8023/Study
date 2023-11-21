package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-21
 * Time: 12:38
 */

/** * @author xiaoxie
 * @date 2023年11月21日 12:38
 */
/*
 *二分查找
 * @author xiaoxie
 * @date 2023/11/21 16:36
 * @param二分查找 https://leetcode.cn/problems/binary-search/ 力扣704 简单
 * @return int
 */
 class Main {
    public  String func(String s) {
        int[] hx = new int[127];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< s.length();i++) {
            char ch = s.charAt(i);
            hx[ch]++;
            if(hx[ch] == 1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (right - left > 1) {
            int mid = (left+right) / 2;
            if(nums[mid] <= target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}
/*
 *二分查找
 * @author xiaoxie
 * @date 2023/11/21 16:36
 * @param二分查找 https://leetcode.cn/problems/search-insert-position/ 力扣35 简单
 * @return int
 */
class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (right - left > 1) {
            int mid = (left+right)/2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if(nums[left] > target) {
            return 0;
        }
        return left+1;
    }
}
/*
 * 求x的算数平方根
 * @author xiaoxie
 * @date 2023/11/21 17:12
 * @param https://leetcode.cn/problems/sqrtx/
 * @return int
 */
class Solution3 {
    public int mySqrt(int x) {
      if(x == 0 || x == 1) {
          return x;
      }
      int left = 0;
      int right = x / 2;
      while (left < right) {
          int mid = left + (right-left+1) / 2;
          if(mid*mid == x) {
              return mid;
          } else if (mid > x / mid) {
              right = mid -1;
          }else {
              left = mid+1;
          }
      }
      return left;
    }
}

class Solution6 {
    /*
     *
     * @author xiaoxie
     * @date 2023/11/21 23:03
     * @param null
     * @return null
     */
    public int maximumSum(int[] nums) {
        int[] hx = new int[82];
        int l = nums.length;
        int sum = -1;
        for(int num : nums) {
            int s = 0;
            for(int i = num;i > 0;i /= 10) {
                s += i % 10;
            }
            if(hx[s] > 0) {
                sum = Math.max(sum,num+hx[s]);
            }
            hx[s] = Math.max(hx[s],num);
        }
        return sum;
    }
}
public class Text {
    public static void main(String[] args) {
       /* Main m = new Main();
        String s = "abcqweracb";*/
        //System.out.println(m.func(s));
        /*Solution1 s = new Solution1();
        int[] nums = {1,3,5,6};
        int a = 2;
        System.out.println(s.searchInsert(nums, a));*/
        Solution6 s = new Solution6();
        int[] arr = {18,43,36,13,7};
        System.out.println(s.maximumSum(arr));
    }
}
