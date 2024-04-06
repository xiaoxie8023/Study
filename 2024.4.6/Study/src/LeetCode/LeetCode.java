package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-06
 * Time: 19:59
 */

import java.util.Arrays;

/** 力扣刷题加油
 * * @author xiaoxie
 * @date 2024年04月06日 19:59
 */
public class LeetCode {
    /** 283. 移动零
     * https://leetcode.cn/problems/move-zeroes/description/
     * 找到0区间的起点补0,前面的值覆盖即可
     * 使用双指针把数组分为三个区间
     * 1.[0,dest] 非0 2. [dest + 1,cur] 0 3.[cur + 1,n-1]待处理区间
     * 最后补0
     * @author xiaoxie
     * @date 2024/4/6 20:36
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    /**1089. 复写零
     * https://leetcode.cn/problems/duplicate-zeros/description/'
     *  1.找到最后一次复写的位置
     *  2.从后向前完成复写操作
     *  O(N)时间复杂度
     *  O(1)空间复杂度
     * @author xiaoxie
     * @date 2024/4/6 21:27
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int cur = 0;
        int n = arr.length;
        int dest = -1;
        while (cur < n) {
            if (arr[cur] != 0) {
                dest++;
            } else {
                dest += 2;
            }
            if (dest >= n - 1) {
                break;
            }
            cur++;
        }
        if (dest == n) {
            arr[n - 1] = 0;
            dest-= 2;
            cur--;
        }
        while (dest >= 0) {
            if (arr[cur] != 0) {
                arr[dest--] = arr[cur--];
            } else {
                arr[dest--] = 0;
                arr[dest--] = 0;
                cur--;
            }
        }
    }
    /** 11. 盛最多水的容器
     * https://leetcode.cn/problems/container-with-most-water/description/
     * 利用单调性的问题分析后然后在,在使用双指针方法
     * @author xiaoxie
     * @date 2024/4/6 22:28
     * @param height
     * @return int
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int star = 0;
        int end = height.length-1;
        int ret = 0;
        while(star < end) {
            ret = height[star] > height[end] ?
                    Math.max(ret,(end-star)*height[end--]) :
                    Math.max(ret,(end-star) * height[star++]);
        }
        return ret;
    }
    /** 611. 有效三角形的个数
     * https://leetcode.cn/problems/valid-triangle-number/
     * 利用单调性的问题分析后然后在,在使用双指针方法
     * @author xiaoxie
     * @date 2024/4/6 23:00
     * @param nums
     * @return int
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;
        int ret = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 2; i--) {
            int c = nums[i];
            int right = i - 1;
            int left = 0;
            while (left < right) {
                if (nums[left] + nums[right] > c) {
                    ret += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }
}
