package demo1_力扣刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-27
 * Time: 20:13
 */

import java.util.ArrayList;
import java.util.List;

/** * @author xiaoxie
 * @date 2023年11月27日 20:13
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if(nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
            }
        return i+1;
        }
}
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length-1;
        while (n > 0) {
            if(m > 0 && nums1[m-1] <= nums2[n-1]) {
                nums1[i] = nums2[n-1];
                i--;
                n--;
            }else {
                nums1[i] = nums1[m-1];
                m--;
                i--;
            }
        }
    }
}

public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,2};
        s.removeDuplicates(nums);

    }
}
