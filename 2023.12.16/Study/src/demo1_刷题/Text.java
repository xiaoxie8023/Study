package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-16
 * Time: 16:46
 */

/**
 * 二分查找
 * @author xiaoxie
 * @date 2023/12/16 21:16
 * @param null
 * @return null
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = -1,right = nums.length;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            }else {
                left = mid;
            }
        }
        return left+1;
    }
}
public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1};
        s.findPeakElement(num);
    }
}
