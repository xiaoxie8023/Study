package leetcode;

import java.util.Arrays;

/**
 * program: untitled
 * <p>
 * description: 力扣刷题
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-07-17 20:59
 **/
public class LeetCode {
    /** 455. 分发饼干
     * <a href="https://leetcode.cn/problems/assign-cookies/description/">...</a>
     * 类似于田忌赛马先排序后使用双指针
     * Description: findContentChildren
     * Param: * @param g
     * @param s
     * return: int
     * Author: xiaoxie
     * Date: 21:12 2024/7/17
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0,ret = 0;
        int n = g.length;
        int m = s.length;
        while(i < n && j < m){
            if(g[i] <= s[j++]) {
                i++;
                ret++;
            }
        }
        return ret;
    }
    /** 553. 最优除法
     * <a href="https://leetcode.cn/problems/optimal-division/description/">...</a>
     * 贪心策略为: 前两个数除外其他数都放到分子上,进行简单的模拟
     * Description: optimalDivision
     * Param: * @param nums
     * return: java.lang.String
     * Author: xiaoxie
     * Date: 21:36 2024/7/17
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder ret = new StringBuilder();
        if (n == 1) {
            return String.valueOf(nums[0]);
        } else if (n == 2) {
            ret.append(nums[0]);
            ret.append("/");
            ret.append(nums[1]);
        } else {
            ret.append(nums[0]).append("/");
            ret.append("(");
            for (int i = 1; i < n - 1; i++) {
                ret.append(nums[i]).append("/");
            }
            ret.append(nums[n - 1]).append(")");
        }

        return ret.toString();
    }
    /** 45. 跳跃游戏 II
     * <a href="https://leetcode.cn/problems/jump-game-ii/description/">...</a>
     * 类似于层序遍历,找到每一次跳跃的左右端点
     * Description: jump
     * Param: * @param nums
     * return: int
     * Author: xiaoxie
     * Date: 22:03 2024/7/17
     */
    public int jump(int[] nums) {
        int n = nums.length,ret = 0,left = 0,right = 0,maxPos = 0;
        while(left <= right) {
            if(maxPos >= n-1) {
                return ret;
            }
            for(int i = left;i <= right;i++) {
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            left = right+1;
            right = maxPos;
            ret++;
        }
        return -1;
    }
    /** 55. 跳跃游戏
     * <a href="https://leetcode.cn/problems/jump-game/">...</a>
     * 和跳跃游戏Ⅱ差不多
     * Description: canJump
     * Param: * @param nums
     * return: boolean
     * Author: xiaoxie
     * Date: 21:41 2024/7/18
     */
    public boolean canJump(int[] nums) {
        int left = 0,right = 0,n = nums.length,maxPos = 0;
        while(left <= right) {
            if(maxPos >= n-1) {
                return true;
            }
            for(int i = left;i <= right;i++) {
                maxPos = Math.max(maxPos,nums[i]+i);
            }
            left = right+1;
            right = maxPos;
        }
        return false;
    }
}
