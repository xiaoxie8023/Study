package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-07
 * Time: 19:55
 */

import java.util.PriorityQueue;

/** * @author xiaoxie
 * @date 2024年03月07日 19:55
 */
public class Text01 {
    /**
     * 力扣 2208. 将数组和减半的最少操作次数
     * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/description/
     * 使用贪心+大根堆
     * 贪心策略为每次把数组中最大的元素除于2,基于最大的元素这个前置条件
     * 所以可以使用大根堆的方法
     *  这题还是比较简单的
     * @author xiaoxie
     * @date 2024/3/7 19:56
     * @param nums
     * @return int
     */
    public int HalveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b)->b.compareTo(a));
        double sum = 0.0;
        for(int num : nums) {
            heap.offer((double)num);
            sum += num;
        }
        sum = sum / 2;
        int count = 0;
        while(sum > 0.0) {
            double t = heap.remove();
            t /= 2;
            sum -= t;
            heap.offer(t);
            count++;
        }
        return count;
    }
    /** 力扣 376. 摆动序列
     *   https://leetcode.cn/problems/wiggle-subsequence/description/
     *   利用贪心算法
     *   时间复杂度为 O(n)
     *   空间为O(1)
     *   贪心策略为: 第一个和最后一个肯定符合,在加上波峰和波底
     * @author xiaoxie
     * @date 2024/3/10 20:35
     * @param nums
     * @return int
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int count = 0,left = 0;
        for(int i = 0;i < n-1;i++) {
            int right = nums[i+1] -nums[i];
            //如果相同就跳过
            if(right == 0) {
                continue;
            }
            //这里只要是异号就说明不是波峰就是波底 等于0是为了加上第一个
            if(left * right <= 0) {
                count++;
            }
            left = right;
        }
        //最后一个肯定符合
        return count + 1;
    }
    /** 力扣 121. 买卖股票的最佳时机
     *  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
     *  利用的就是贪心加上动态变量
     *  很简单的一题
     *  时间复杂度为O(n);
     *  空间复杂度为O(1);
     * @author xiaoxie
     * @date 2024/3/10 21:48
     * @param prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        int res = 0,min = Integer.MAX_VALUE;
        for(int price : prices) {
            res = Math.max(res,price - min);
            min = Math.min(min,price);
        }
        return res;
    }
    /** 力扣 122. 买卖股票的最佳时机 II
     *  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
     *  时间复杂度为O(n);
     *  空间复杂度为O(1);
     *  同样是使用贪心的策略
     *  把一段的时间分为每一天来计算 例如
     *   prices[3] - prices[1] = prices[3] - prices[2] + prices[2] - prices[1]
     * @author xiaoxie 
     * @date 2024/3/10 22:23
     * @param prices 
     * @return int 
     */
    public int maxProfit2(int[] prices) {
        int ret = 0;
        for(int i = 0;i < prices.length-1;i++) {
            if(prices[i+1] > prices[i]) {
                ret += prices[i+1] -prices[i];
            }
        }
        return ret;
    }
    /**力扣 122. 买卖股票的最佳时机 II
     *  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
     *  时间复杂度为O(n);
     *  空间复杂度为O(1);
     *  同样是使用贪心的策略
     *  不过是使用双指针来解这题
     * @author xiaoxie
     * @date 2024/3/10 22:33
     * @param prices
     * @return int
     */
    public int maxProfit2_1(int[] prices) {
        int ret = 0;
        for(int i = 0;i < prices.length;i++) {
            int j = i;
            while(j+1 < prices.length  && prices[j+1] > prices[j]) j++;
            ret += prices[j] - prices[i];
            i = j;
        }
        return ret;
    }
    /** 力扣 1137. 第 N 个泰波那契数
     *  https://leetcode.cn/problems/n-th-tribonacci-number/description/
     *  动态规划的简单题目
     *  状态表示: dp表的dp[i]就为答案
     *  状态转移方程:  Tn+3 = Tn + Tn+1 + Tn+2
     *   时间复杂度为: O(n)
     *   空间复杂度为: O(n)
     * @author xiaoxie
     * @date 2024/3/11 22:44
     * @param n
     * @return int
     */
    public int TriBoNaCci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1] = 1;dp[2] = 1;
        for(int i = 3; i<= n; i++) {
            dp[i] = dp[i-3] + dp[i - 2] + dp[i-1];
        }
        return dp[n];
    }
    /** 力扣 1137. 第 N 个泰波那契数
     *  https://leetcode.cn/problems/n-th-tribonacci-number/description/
     *  动态规划的简单题目
     *  状态表示: dp表的dp[i]就为答案
     *  状态转移方程:  Tn+3 = Tn + Tn+1 + Tn+2
     *   时间复杂度为: O(n)
     *   空间复杂度为: O(1) 是对之前动态规划的空间优化 使用滚动数组的方式
     * @author xiaoxie
     * @date 2024/3/11 22:53
     * @param n
     * @return int
     */
    public int TriBoNaCci2(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int[] dp = new int[4];
        dp[0] = 0;dp[1] = 1;dp[2] = 1;
        for(int i = 3;i<= n;i++) {
            dp[3] = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}
