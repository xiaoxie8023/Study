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
    /** 力扣 三步问题
     * https://leetcode.cn/problems/three-steps-problem-lcci/
     * 动态规划的简单题目
     * 状态表示: dp表的dp[i]就为答案
     *  状态转移方程:  Tn+3 = Tn + Tn+1 + Tn+2
     *  时间复杂度为: O(n)
     *  空间复杂度为: O(1)
     * @author xiaoxie
     * @date 2024/3/12 16:19
     * @param n
     * @return int
     */
    public int waysToStep(int n) {
        final int m = (int)1e9 + 7;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        int a = 1,b = 2,c = 4,d = 0;
        for(int i = 4;i <= n;i++) {
            d = (c + (a + b)% m) % m;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
    /**
     * 快速幂运算
     * 以2的11次方为例
     *  2的8次方 加上 2的2次方 加上 2的1次方
     *  11 = 8 + 2 + 1
     *   1101
     *  &0001
     *  在右移
     *   101
     *  &001
     * @author xiaoxie
     * @date 2024/3/12 20:03
     * @return int
     */
    public static int fastPow() {
        final int Mod = 10000; // 只保留最后4位
        int a = 2024;
        int n = (int)1e9;
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans * a) % Mod;
            }
            a = (a * a) % Mod;
            n >>= 1;
        }
        return ans;
    }
    /** 使用矩阵快速幂
     * 「快速幂」和「矩阵乘法」
     *
     * @author xiaoxie
     * @date 2024/3/12 20:59
     * @param null
     * @return null
     */
    int N = 3;
    //[矩阵乘法」
    public int[][] mutil(int[][]a,int[][] b) {
        int[][]c = new int[N][N];
        for(int i = 0; i < N;i++) {
            for(int j = 0;j < N;j ++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] *b[2][j];

            }

        }
        return c;

    }
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[][] ans = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        int[][] mat = new int[][] {
                {1,1,1},
                {1,0,0},
                {0,1,0}
        };
        int k = n - 2;
        //快速幂
        while(k > 0) {
            if((k & 1) == 1) {
                ans = mutil(ans,mat);
            }
            mat = mutil(mat,mat);
            k >>= 1;
        }
        return ans[0][0] + ans[0][1];
    }
    /** 力扣 746. 使用最小花费爬楼梯
     * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
     * 动态规划加滚动数组
     * 状态表示为:
     *
     * dp[i] 表示为到达i位置,所花费的最小费用
     * 状态方程:
     * dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
     * 时间复杂度 O(N)
     * 空间复杂度 O (1)
     * @author xiaoxie
     * @date 2024/3/12 21:39
     * @param cost
     * @return int
     */
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int a = 0;//cost[i-2]
        int b = 0;//cost[i-1]
        for(int i = 2; i <=length; i++) {
            int ans = Math.min(a +cost[i-2],b + cost[i-1]);
            a = b;
            b = ans;
        }
        return b;
    }
    /** 力扣 746. 使用最小花费爬楼梯
     * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
     * 动态规划加滚动数组
     * 状态表示为:
     * 以i位置表示到达楼顶,所花费的最小费用
     * dp[i] 表示为以i位置出发到达楼顶,所花费的最小费用
     * 状态方程:
     * dp[i] = Math.min(dp[i+1] + cost[i],dp[i+2] + cost[i]);
     * 时间复杂度 O(N)
     * 空间复杂度 O (1)
     * @author xiaoxie
     * @date 2024/3/12 21:39
     * @param cost
     * @return int
     */
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int a = cost[n-1];
        int b = cost[n-2];
        for(int i = n-3;i>=0;i--) {
            int ans = Math.min(a+cost[i],b+cost[i]);
            a = b;
            b = ans;
        }
        return a > b ? b : a;
    }
    /** 力扣 91. 解码方法
     * https://leetcode.cn/problems/decode-ways/description/
     * 动态规划
     * 状态表示: dp[i]表示到达i位置时需要多少种方法
     * 状态转移方程: dp[i] = dp[i-1] + dp[i-2] 前提是不为'0'
     * 初始化: 使用虚拟节点 使dp[0]为1,就可以让之后的填表问题在循环中实现
     * 返回值:dp[n]
     * 时间复杂度: O(n)
     * 空间复杂度:O(1)
     * @author xiaoxie 
     * @date 2024/3/13 22:24
     * @param s 
     * @return int 
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;//虚拟的节点
        for(int i = 1;i <= n;i++) {
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            if(i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0') * 10 + (s.charAt(i-1) - '0') >= 10 &&(s.charAt(i-2)-'0') * 10 + (s.charAt(i-1) - '0')<=26)) {
                dp[i] +=dp[i-2];
            }
        }
        return dp[n];
    }
    /**力扣 91. 解码方法
     * https://leetcode.cn/problems/decode-ways/description/
     * 空间优化
     * 空间复杂度为O(1)
     * @author xiaoxie
     * @date 2024/3/13 22:32
     * @param s
     * @return int
     */
    public int numDecodings2(String s) {
        int n = s.length();
        int a = 0,b = 1,c = 0;
        for(int i = 1;i <= n;i++) {
            c = 0;//每次都需要先把c置为0
            if(s.charAt(i-1) != '0') {
                c += b;
            }
            if(i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2)-'0') * 10 + (s.charAt(i-1) - '0') >= 10 &&(s.charAt(i-2)-'0') * 10 + (s.charAt(i-1) - '0')<=26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
    /** 力扣 62. 不同路径
     * https://leetcode.cn/problems/unique-paths/description/
     * 状态表示: dp[i][j] 表示为到达i行j列所需要的方法总数
     * 状态转移方程: dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 初始化:一样是虚拟节点不过是增加1行1列,画图会更好理解,把dp[0][1] = 1;
     * 返回值: dp[m][n]
     * 时间复杂度为O(M*N)
     * 空间复杂度为O(M*N)
     * @author xiaoxie
     * @date 2024/3/13 22:38
     * @param m
     * @param n
     * @return int
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
       minCostClimbingStairs(cost);
    }
}
