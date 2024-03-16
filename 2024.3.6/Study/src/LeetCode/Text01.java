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
    /** 力扣63. 不同路径 II
     * https://leetcode.cn/problems/unique-paths-ii/description/
     * 状态表示: dp[i][j] 表示为到达i行j列所需要的方法总数
     *  状态转移方程: dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 初始化:一样是虚拟节点不过是增加1行1列,画图会更好理解,把dp[0][1] = 1;
     * 需要注意到下标的映射关系,因为加了1行1列所以,要访问原数组要统一减一
     * *返回值: dp[m][n]
     * 时间复杂度为O(M*N)
     * 空间复杂度为O(M*N)
     * @author xiaoxie
     * @date 2024/3/14 22:45
     * @param obstacleGrid
     * @return int
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
    /** 牛客 JZ47 礼物的最大价值
     * https://www.nowcoder.com/practice/2237b401eb9347d282310fc1c3adb134?tpId=265&tqId=39288&ru=/exam/oj
     * 状态表示: dp[i][j] 表示为到达i行j列时,换取的最大礼物值
     * 状态转移方程: dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
     * 初始化:一样是虚拟节点不过是增加1行1列,画图会更好理解,都为0;
     * 需要注意到下标的映射关系,因为加了1行1列所以,要访问原数组要统一减一
     * 返回值: dp[m][n]
     * 时间复杂度为O(M*N)
     * 空间复杂度为O(M*N)
     * @author xiaoxie
     * @date 2024/3/15 20:14
     * @param grid
     * @return int
     */
    public int maxValue (int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
    /**力扣 931. 下降路径最小和
     * https://leetcode.cn/problems/minimum-falling-path-sum/description/
     *状态表示: dp[i][j] 表示为到达i行j列时,下降路径的最小值
     *状态转移方程: dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])+matrix[i-1][j-1];
     *初始化:一样是虚拟节点不过是增加1行两列,画图会更好理解,除了第一行为0,其他的都为MAX_VALUE;
     *需要注意到下标的映射关系,因为加了1行1列所以,要访问原数组要统一减一 matrix[i][j] = matrix[i-1][j-1]
     *顺序:只需要从上往下即可
     *返回值: dp[n][] 的最小值
     *时间复杂度为O(N*N)
     *空间复杂度为O(M*N)
     * @author xiaoxie
     * @date 2024/3/15 21:03
     * @param matrix
     * @return int
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int val = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][m+2];
        for(int i = 1;i <= n;i++) {
            dp[i][0] = dp[i][n+1] = val;
        }
        for(int i =1;i<=n;i++) {
            for(int j = 1;j <= n;j++) {
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1])) + matrix[i-1][j-1];
            }
        }
        int ret = val;
        for(int i = 1;i<=m;i++) {
            ret = Math.min(dp[n][i],ret);
        }
        return ret;
    }
    /** 力扣 64. 最小路径和
     * https://leetcode.cn/problems/minimum-path-sum/description/
     * 状态表示: dp[i][j] 表示为到达i行j列时,换取的最短路径
     *  状态转移方程: dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
     *  初始化:一样是虚拟节点不过是增加1行1列,画图会更好理解,除了 dp[0][1] = dp[1][0] = 0 别的虚拟节点为Integer.MAX_VALUE;
     *  需要注意到下标的映射关系,因为加了1行1列所以,要访问原数组要统一减一
     *  返回值: dp[m][n]
     *  时间复杂度为O(M*N)
     *  空间复杂度为O(M*N)
     * @author xiaoxie
     * @date 2024/3/15 21:34
     * @param grid
     * @return int
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int val = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i <= n;i++) {
            dp[i][0] = val;
        }
        for(int i = 0;i <= m;i++) {
            dp[0][i] = val;
        }
        dp[0][1] = dp[1][0] = 0;
        for(int i = 1;i <=n;i++) {
            for(int j = 1;j <=m;j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
    /** 力扣 174. 地下城游戏
     * https://leetcode.cn/problems/dungeon-game/description/
     * 状态表示:: dp[i][j]以i行j列为开始,救到公主所所需的最低初始健康点数
     * 状态转移方程: dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j];
     *            同时 dp[i][j] = Math.max(1,dp[i][j]) 因为骑士最少要为一点健康点数
     * 初始化:一样是虚拟节点不过是增加1行1列,画图会更好理解,除了dp[n-1][m] = dp[n][m-1] = 1; 别的虚拟节点为Integer.MAX_VALUE;
     * 顺序:由于状态表示为dp[i][j]以i行j列为开始所以要以相反的的顺序来实现
     * 返回值: dp[0][0]
     * 时间复杂度为O(M*N)
     * 空间复杂度为O(M*N)
     * @author xiaoxie
     * @date 2024/3/15 22:22
     * @param dungeon
     * @return int
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        int val = Integer.MAX_VALUE;
        for(int i = 0;i<=n;i++) {
            dp[i][m] = val;
        }
        for(int i = 0;i<=m;i++) {
            dp[n][i] = val;
        }
        dp[n-1][m] = dp[n][m-1] = 1;
        for(int i = n-1; i >= 0;i--) {
            for(int j = m-1;j >= 0;j--){
                dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j];
                dp[i][j] = Math.max(1,dp[i][j]);//骑士最少要为一点健康点数
            }
        }
        return dp[0][0];
    }
    /** 力扣 面试题 17.16. 按摩师
     * https://leetcode.cn/problems/the-masseuse-lcci/description/
     * 状态表示:: dp[i]表示为到达i位置所要最长总预约时间
     *          细分为
     *          f[i] num[i]必选,所最长总预约时间
     *          g[i] num[i]不选,所最长总预约时间
     * 状态转移方程:
     * f[i] = g[i-1] + nums[i]
     * g[i] = Math.max(f[i-1],g[i-1])
     * 初始化:f[0] = nums[0],g[0] = 0还需要判断数组是否存在
     *返回值: :Math.max(f[n-1],g[n-1])
     * 时间复杂度为O(N)
     * 空间复杂度为O(N)
     * @author xiaoxie
     * @date 2024/3/15 22:55
     * @param nums
     * @return int
     */
    public int massage(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];g[0] = 0;
        for(int i = 1;i < n;i++) {
            f[i] = g[i-1] + nums[i];
            g[i] = Math.max(f[i-1],g[i-1]);
        }
        return Math.max(f[n-1],g[n-1]);
    }
    /** 使用滚动数组优化空间复杂度
     * 力扣 面试题 17.16. 按摩师
     * https://leetcode.cn/problems/the-masseuse-lcci/description/
     * 状态表示:: dp 表示为到达i位置所要最长总预约时间
     *          细分为
     *           f num[i]必选,所最长总预约时间
     *           g num[i]不选,所最长总预约时间
     * 状态转移方程:
     *    int res1 = g[i-1]+ nums[i];
     *    int res2 = Math.max(f,g);
     *    f = res1;
     *    g = res2;
     * 初始化:f = nums[0],g = 0还需要判断数组是否存在
     *返回值: :Math.max(f,g)
     * 时间复杂度为O(N)
      空间复杂度为O(1)
     * @author xiaoxie
     * @date 2024/3/15 23:00
     * @param nums
     * @return int
     */
    public int massage2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int f = nums[0];
        int g = 0;
        for(int i = 1;i < n;i++) {
            int res1 = g + nums[i];
            int res2 = Math.max(f,g);
            f = res1;
            g = res2;
        }
        return Math.max(f,g);
    }
    /** 213. 打家劫舍 II
     * https://leetcode.cn/problems/house-robber-ii/description/
     * 首先根据题意我们先把它分为两种情况
     * 1.nums[0] 偷 那么nums[1]和nums[n-1]就不可以偷,[2-n-2]之间就可以用打家劫舍1来解 nums[0] + rob1
     * 2..nums[0] 不偷,[1-n-1]之间就可以用打家劫舍1来解 rob1;
     * 状态表示:: dp 表示为到达i位置所要最长总预约时间
     *               细分为
     *            f num[i]必选,所最长总预约时间
     *             g num[i]不选,所最长总预约时间
     *  状态转移方程:
     *  int res1 = g[i-1]+ nums[i];
     *  int res2 = Math.max(f,g);
     *  f = res1;
     *  g = res2;
     * 初始化:f = nums[0],g = 0还需要判断数组是否存在
     * 返回值: :Math.max(f,g)
     *  时间复杂度为O(N)
     *  空间复杂度为O(1)
     * @author xiaoxie
     * @date 2024/3/16 17:51
     * @param nums
     * @return int
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int x = rob1(2,nums,n-2) + nums[0];
        int y = rob1(1,nums,n-1);
        return Math.max(x,y);
    }
    private int rob1(int i,int[] nums,int n) {
        if(i > n) return 0;
        int f = nums[i];
        int g = 0;
        for(i = i +1;i <=n;i++) {
            int ret1 = g + nums[i];
            int ret2 = Math.max(f,g);
            f = ret1;
            g = ret2;
        }
        return Math.max(f,g);
    }
    /** 力扣 740. 删除并获得点数
     * https://leetcode.cn/problems/delete-and-earn/
     *  把该问题可以转换成打家劫舍问题
     *     nums[2,2,3,3,3,4]
     *     array[0,0,4,9,4]
     *   状态表示:: dp 表示为到达i位置获得的最大点数。
     *        细分为
     *          f array[i]选,获得的最大点数
     *         g array[i]不选,获得的最大点数
     * 状态转移方程:
     *    int res1 = g[i-1]+ array[i];
     *    int res2 = Math.max(f,g);
     *     f = res1;
     *     g = res2;
     *    初始化:f = array[0],g = 0还需要判断数组是否存在
     *    返回值: :Math.max(f,g)
     *    时间复杂度为O(N)
     *    空间复杂度为O(n):创建了array数组
     * @author xiaoxie
     * @date 2024/3/16 18:43
     * @param nums
     * @return int
     */
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int val : nums) {
            max = Math.max(max,val);
        }
        int[] array = new int[max+1];
        for(int num:nums) {
            array[num] = array[num] +  num;
        }
        //打家劫舍问题
        int f = array[0];
        int g = 0;
        for(int i = 1;i < max+1;i++) {
            int ret1 = g + array[i];
            int ret2 = Math.max(f,g);
            f = ret1;
            g = ret2;
        }
        return Math.max(f,g);
    }
    /** LCR 091. 粉刷房子
     * https://leetcode.cn/problems/JEj789/description/
     * 状态表示: dp[i][0] 表示为到第i栋房子,粉刷红色所花费的钱
     *         dp[i][1] 表示为到第i栋房子,粉刷蓝色所花费的钱
     *         dp[i][2] 表示为到第i栋房子,粉刷绿色所花费的钱
     * 状态转移方程:
     *       dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0]
     *       dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1]
     *       dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + costs[i][2]
     * 初始化:
     *       增加一个虚拟节点初始化为0
     * 返回值:
     *  Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
     *  时间复杂度:O(n)
     *  空间复杂度:O(n)
     * * @author xiaoxie
     * @date 2024/3/16 20:44
     * @param costs
     * @return int
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        for(int i = 1; i <= n;i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + costs[i-1][2];
        }
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
    /**  LCR 091. 粉刷房子的空间优化
     * 空间复杂度:O(1)
     * @author xiaoxie
     * @date 2024/3/16 20:55
     * @param costs
     * @return int
     */
    public int minCost2(int[][] costs) {
        int n = costs.length;
        int a = 0,b = 0, c = 0;
        for(int i = 0;i < n;i++) {
            int ret1 = Math.min(b,c) + costs[i][0];
            int ret2 = Math.min(a,c) + costs[i][1];
            int ret3 = Math.min(b,a) + costs[i][2];
            a = ret1;
            b = ret2;
            c = ret3;
        }
        return Math.min(a,Math.min(b,c));
    }
    /** 力扣 309. 买卖股票的最佳时机含冷冻期
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
     *   状态表示:
     *             dp[i][0] 为第i天处于买入状态下,的最大利润
     *             dp[i][1] 为第i天处于可交易状态下,的最大利润
     *             dp[i][2] 为第i天处于冷却期状态下,的最大利润
     *    状态转移方程:
     *            买入: dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
     *          可交易: dp[i][1] = Math.max(dp[i-1][2],dp[i-1][1]);
     *          冷却期: dp[i][2] = dp[i-1][0] + prices[i]
     *     初始化: dp[0][0] = -prices[0] dp[0][1] = 0,dp[0][2] = 0;
     *     时间复杂度:O(n)
     *     空间复杂度:O(n)
     * @author xiaoxie
     * @date 2024/3/16 22:10
     * @param prices
     * @return int
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][3];
        dp[0][0] = -prices[0];
        for(int i = 1;i <=n;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][2],dp[i-1][1]);
            dp[i][2] = dp[i-1][0] + prices[i-1];
        }
        return Math.max(dp[n][1],dp[n][2]);
    }
    /** 714. 买卖股票的最佳时机含手续费
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
     *  状态表示:
     *             dp[i][0] 第i天为买入,获得的最大利润
     *             dp[i][1] 第i天为买出,获得的最大利润
     *     状态转移方程:
     *             dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
     *             dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+price[i]-fee)
     *     初始化:
     *       dp[0][0] = -prices[0]; dp[0][1] = 0;
     *       时间复杂度为O(n)
     *       空间复杂度为O(n)
     * @author xiaoxie
     * @date 2024/3/16 22:55
     * @param prices
     * @param fee
     * @return int
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = -prices[0];
        for(int i = 1;i <= n;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i-1]-fee);
        }
        return Math.max(dp[n][0],dp[n][1]);
    }
    /** 123. 买卖股票的最佳时机 III
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     *  状态表示:
     *       f[i][j] 到第i天,进行了j次交易,买入获得的最大价值
     *       g[i][j] 到第i天,进行了j次交易,卖出(没有持有股票)获得的最大价值
     *     状态转移方程:
     *       f[i][j] = Math.max(f[i-1][j],g[i-1][j] -prices[i]);
     *      // g[i][j] = Math.max(g[i-1][j],f[i-1][j-1] + prices);
     *        g[i][j] = g[i-1][j];
     *                 if(j-1 >= 0){
     *                     g[i][j] = Math.max(g[i][j],f[i-1][j-1] + prices[i-1]);
     *                 }
     *     初始化
     *     int val = -0x3f3f3f3f
     *       f[0][0] = -prices[0],其他为val
     *       g[0][0] = 0,其它为val;
     *       返回值,
     *       Math.max(g[n][0],Math.max(g[n][1],g[n][2]));
     *       时间复杂度为O(n*n)
     *       空间复杂度为O(n*n)
     * @author xiaoxie
     * @date 2024/3/16 23:54
     * @param prices
     * @return int
     */
    public int maxProfit4(int[] prices) {
        int n = prices.length;
        int j = 3;
        int[][] f = new int[n+1][j];
        int[][] g = new int[n+1][j];
        int val = -0x3f3f3f3f;
        f[0][0] = -prices[0];f[0][1] = f[0][2] = val;
        g[0][0] = 0;g[0][1] = g[0][2] = val;
        for(int i = 1;i <= n; i++) {
            for(j = 0;j < 3;j++) {
                f[i][j] = Math.max(f[i-1][j],g[i-1][j] -prices[i-1]);
                g[i][j] = g[i-1][j];
                if(j-1 >= 0){
                    g[i][j] = Math.max(g[i][j],f[i-1][j-1] + prices[i-1]);
                }
            }
        }
        return Math.max(g[n][0],Math.max(g[n][1],g[n][2]));
    }
    public static void main(String[] args) {
        int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
       minCostClimbingStairs(cost);
    }
}
