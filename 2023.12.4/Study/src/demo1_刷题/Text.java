package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-04
 * Time: 16:35
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaoxie
 * @date 2023/12/4 16:37
 * @param //力扣 https://leetcode.cn/problems/make-three-strings-equal/ 2937 使三个字符串相等
 * @return null
 */
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int min = Math.min(Math.min(s1.length(),s2.length()),s3.length());
        int i = 0;
        for( i = 0;i < min;i++) {
            if(s1.charAt(i) != s2.charAt(i) || s1.charAt(i) != s3.charAt(i)) {
                break;
            }
        }
        return i == 0 ? -1:s1.length()+s2.length()+s3.length()-3*i;

    }
}
/**
 *
 * @author xiaoxie
 * @date 2023/12/4 16:37
 * @param //力扣 https://leetcode.cn/problems/search-insert-position/ 35 搜索插入位置
 * @return null
 */
class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while(left+1 != right) {
            int mid = (right+left) >> 1;
            if(nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
/**
 *
 * @author xiaoxie
 * @date 2023/12/4 16:37
 * @param //力扣 https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/ 34 在排序数组中查找元素的第一个和最后一个位置
 * @return null
 */
class Solution3 {
    private int searchleft (int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while(left+1 != right) {
            int mid = left+((right-left) / 2);
            if(nums[mid] <= target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private int searchright (int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while(left+1 != right) {
            int mid = left+((right-left) / 2);
            if(nums[mid] <  target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
    public int[] searchRange(int[] nums, int target) {
        int leftindex = searchleft(nums,target);
        int rightindex = searchright(nums,target);
        if(leftindex >= rightindex && nums[leftindex] == target && nums[rightindex] == target) {
            return new int[] {rightindex,leftindex};
        }else {
            return new int[] {-1,-1};
        }
    }
}
/**
 *
 * @author xiaoxie
 * @date 2023/12/4 16:37
 * @param //力扣 69.x 的平方根https://leetcode.cn/problems/sqrtx/
 * @return null
 */
class Solution5 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while(left <= right) {
            int mid = left+((right-left) / 2 );
            if((long)mid * mid <= x) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }

        }
        return ans;
    }
}
/**
 *
 * @author xiaoxie
 * @date 2023/12/4 16:37
 * @param //力扣 https://leetcode.cn/problems/valid-perfect-square/  367.有效的完全平方数(opens new window)
 * @return null
 */
class Solution6 {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while(left <= right) {
            int mid = left+((right-left) /2);
            if((long) mid *mid <  num) {
                left = mid +1;
            } else if((long) mid *mid >  num){
                right = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
/**
 *
 * @author xiaoxie
 * @date 2023/12/4 16:37
 * @param //力扣
 * @return null
 */

public class Text {
    public static void main(String[] args) {
     Solution2 s = new Solution2();
     int[] num = {1,3,5,6};
     int i = 2;
        System.out.println(s.searchInsert(num, i));
    }
}
