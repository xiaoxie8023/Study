package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-24
 * Time: 16:14
 */

import java.lang.reflect.Array;
import java.util.*;

/** * @author xiaoxie
 * @date 2023年11月24日 16:14
 */

class Solution{
    /*
     * 轮转数组 https://leetcode.cn/problems/rotate-array/ 189
     * @author xiaoxie
     * @date 2023/11/24 21:22
     * @param 方法一 创建新的数组
     * @return null
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newNums =  new int[n];
        int a = 0;
         for (int i = 0; i < n; i++) {
            newNums[(i+k) % n] = nums[i];
         }
         System.arraycopy(newNums, 0, nums, 0, n);
    }
    /*
     *  方法二 旋转数组，1. 7，6，5，4，3，2，1
     *                2. 5，6，7，4，3，2，1
     *                3. 5，6，7，1，2，3，4
     * @author xiaoxie
     * @date 2023/11/24 22:31
     * @param null
     * @return null
     */
    public  void rotate2(int[] nums, int k) {
        int n = nums.length;
        rever(nums,0,n-1);
        rever(nums,0,k-1);
        rever(nums,n-k,n-1);
    }
    public void rever(int[] nums,int star,int end) {
        while(star < end) {
            int temp = nums[star];
            nums[star] = nums[end];
            nums[end] = temp;
        }
    }
}

class Solution1 {
    /*
     * 双指针
     * @author xiaoxie
     * @date 2023/11/24 23:30
     * @param null
     * @return null
     */
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size(), ans = 0;
        for (int i = 1; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l+(r-l ) / 2;
                if (nums.get(mid) + nums.get(i) < target) l = mid;
                else r = mid - 1;
            }
            if (nums.get(r) + nums.get(i) < target) ans += r + 1;
        }
        return ans;
    }

}

public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1,2,3,4,5,6,7};
        int a = 3;
        //s.rotate2(num,a);
        Solution1 s1 = new Solution1();
        List<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, 1));
        int k = 2;
        System.out.println(s1.countPairs(nums, k));
    }
}
