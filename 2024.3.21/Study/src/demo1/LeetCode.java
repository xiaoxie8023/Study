package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-19
 * Time: 22:40
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** * @author xiaoxie
 * @date 2024年03月19日 22:40
 */
public class LeetCode {
    /** 300. 最长递增子序列
     * https://leetcode.cn/problems/longest-increasing-subsequence/description/
     * 状态表示:
     *          dp[i]表示以i为结尾的所有子序列中,长度最长的严格递增子序列的长度
     * 状态转移方程:
     *            1.子序列等于1
     *            dp[i] = 1;
     *            因为再初始化的设为1,可以不考虑该情况
     *            2.子序列大于1
     *            设 0<=j <=i-1
     *            在 nums[j] < num(i)的前提下
     *            dp[i] = max(dp[j] + 1);
     * 初始化:
     *            dp数组里全为1
     * 返回值:     Math.max(dp[i])
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @author xiaoxie
     * @date 2024/3/20 14:45
     * @param nums
     * @return int
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length,max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
    /** 376. 摆动序列
     * https://leetcode.cn/problems/wiggle-subsequence/description/
     * 动态规划
     * 状态表示:
     *          f[i]以i位置为结尾的子序列,最后一个位置呈上升趋势的最长摆动子序列
     *          g[i]以i位置为结尾的子序列,最后一个位置呈下降趋势的最长摆动子序列
     * 状态转移方程:
     *         1.长度为1 f[i] = g[i] = 1
     *         2.长度大于1  x = nums[i-1] y = nums[i]
     *          1. x > y f[i] = 1 g[i] = f[i-1] + 1;
     *          2. x < y f[i] = g[i-1] + 1;g[i] = 1;
     *          3. x = y f[i] = 1,g[i] = 1;
     * 初始化:
     *         f[i] 和 g[i] 全为1;
     * 返回值:
     *         Math.max(Max(f[i]),Max(g[i]))
     * 时间复杂度: O(N*N)
     * 空间复杂度: O(N)
     * @author xiaoxie
     * @date 2024/3/20 15:19
     * @param nums
     * @return int
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length,max = 1;
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.fill(f,1);
        Arrays.fill(g,1);
        for(int i = 1; i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i]) {
                    f[i] = Math.max(f[i],g[j] + 1);
                }else if(nums[j] > nums[i]) {
                    g[i] = Math.max(g[i],f[j] + 1);
                }
            }
            max = Math.max(max,Math.max(f[i],g[i]));
        }
        return max;
    }
    /**376. 摆动序列
     * https://leetcode.cn/problems/wiggle-subsequence/description/
     * 贪心算法
     * 找波峰波谷的个数
     * 时间复杂度为 O(n)
     * 空间复杂度为:O(1)
     * @author xiaoxie
     * @date 2024/3/20 15:27
     * @param nums
     * @return int
     */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int count = 0,left = 0;
        for(int i = 0; i < n-1;i++) {
            int right = nums[i+1] - nums[i];
            if(right == 0) {
                continue;
            }
            if(left * right <= 0) {
                count++;
            }
            left = right;
        }
        return count+1;
    }
    /** 673. 最长递增子序列的个数
     * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/description/
     * 状态表示:
     *          dp[i]表示以i为结尾的子序列中,最长递增子序列的长度
     *          count[i]表示以i为结尾的子序列中,最长递增子序列的个数
     * 状态转移方程:
     *            1.长度为1 count[i] = 1;dp[i] = 1
     *            0<= j <= i
     *            2.长度大于1 dp[i] = max(dp[j] + 1)
     *            if(dp[j] +1 == dp[i])
     *            count[i] += count[j];
     *            else if(dp[i] + 1 > dp[i])
     *            dp[i] = dp[j] + 1
     *            count[i] = count[j]
     *            else {
     *                 忽视
     *            }
     * 初始化:
     *          dp[i] 和 count[i]都为1;
     * 返回值,count[i]中最大的值
     * 时间复杂度: O(N * N)
     * 空间复杂度: O(N)
     * @author xiaoxie
     * @date 2024/3/21 15:13
     * @param nums
     * @return int
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int retlen = 1,ret = 1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }else if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(retlen == dp[i]) {
                ret += count[i];
            }else if(retlen < dp[i]){
                retlen = dp[i];
                ret = count[i];
            }
        }
        return ret;
    }
    /** 646. 最长数对链 目前只能先做到这种笨方法(动态规划) 等我更强以后可以尝试一下贪心加二分
     * https://leetcode.cn/problems/maximum-length-of-pair-chain/description/
     * 预处理:
     *          先把这个数对链排个序
     * 状态表示:
     *           dp[i]表示为以i位置为结尾, 最长数对链的长度
     * 状态转移方程:
     *           1.数对链长度为1  dp[i] = 1;
     *           2.数对链长度大于1 前提是得 (p[j][1] < p[i][0])dp[i] = max(dp[j] + 1)
     * 初始化:
     *           dp[i] 全部设为1;
     * 返回值:   Math.max(dp[i])
     * 时间复杂度: O(N*N)
     * 空间复杂度:O(N)
     * @author xiaoxie
     * @date 2024/3/21 22:46
     * @param pairs
     * @return int
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[0] - b[0]);
        int n = pairs.length,max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    /** 1218. 最长定差子序列
     * 这个代码思想巧妙,感觉自己还得多学
     * https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/description/
     * 状态表示:
     *        dp[i]表示为以i为结尾,所有子序列中,最长等差子序列的长度
     * 状态转移方程:
     *        1.长度为1,dp[i] = 1;
     *        2.长度大于1:
     *        arr[j] = arr[i] - d
     *        dp[i] = 离i最近的满足上述条件的arr[j] arr[j] + 1;
     * 初始化:
     *        根据上述的需求可以使用哈希表来模拟动态规划的需求
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @author xiaoxie
     * @date 2024/3/22 9:31
     * @param arr
     * @param difference
     * @return int
     */
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int ret = 1;
        for(int num : arr) {
            map.put(num,map.getOrDefault((num-difference),0) +1);
            ret = Math.max(ret,map.get(num));
        }
        return ret;
    }
    /** 873. 最长的斐波那契子序列的长度
     * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/description/
     * 优化:
     *       使用哈希表来使相应的值和下标有映射关系,减少时间复杂度
     * 状态表示:
     *         dp[i][j]:以i位置和j位置结尾的子序列,中最长的斐波那契子序列的长度并规定,i在前j在后
     * 状态转移方程:
     *           nums[k] = a,nums[i] = b,nums[j] = c
     *           if(a = c - b)
     *           1.a存在,并且,a < b dp[i][j] = dp[k][i] + 1
     *           2.a存在,并且,a > b dp[i][j] = 2;
     *           3.a不存在 dp[i][j] = 2
     * 初始化:
     *         dp[i][j]都设为2;
     * 填表顺序:  从上往下
     * 返回值:  Math.max(ret)  ret < 3 ? 0 : ret
     * 时间复杂度为: O(N*N)
     * 空间复杂度为: O(N*N)
     * @author xiaoxie
     * @date 2024/3/22 22:12
     * @param nums
     * @return int
     */
    public int lenLongestFibSubseq(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            map.put(nums[i],i);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n;j++) {
                dp[i][j] = 2;
            }
        }
        int ret = 2;
        for(int j = 2;j < n;j++) {
            for(int i = 1;i < j;i++) {
                int a = nums[j] - nums[i];
                if(a < nums[i] && map.containsKey(a)) {
                    dp[i][j] = dp[map.get(a)][i] + 1;
                    ret = Math.max(ret,dp[i][j]);
                }
            }
        }
        return ret < 3 ? 0 : ret;
    }
    /** 1027. 最长等差数列
     * https://leetcode.cn/problems/longest-arithmetic-subsequence/description/
     * 优化:
     *       一边dp,一边填下标到哈希表 固定倒数第二个,枚举倒数第一个;
     * 状态表示:
     *          dp[i][j] 表示以i结尾,以j结尾的所有子序列中,最长等差子序列的长度。i < j
     * 状态转移方程:
     *         nums[k] = a,nums[i] = b,nums[j] = c c-b = b-a ->  a = 2b-c;
     *         if(a存在 && a < i) dp[i][j] = dp[k][i] + 1
     *         else if(a存在 && a > i) dp[i][j] = 2;
     *         else (a不存在) dp[i][j] = 2
     * 初始化:
     *         dp[i][j]全设为2;
     * 填表顺序:
     *         固定倒数第二个,枚举倒数第一个;
     * 返回值:  Max(ret)
     * 时间复杂度: O(N*N)
     * 空间复杂度: O(N*N)
     * @author xiaoxie
     * @date 2024/3/22 23:05
     * @param nums
     * @return int
     */
    public int longestArithSeqLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],2);
        }
        int ret = 2;
        for(int i = 1; i < n;i++) {
            for(int j = i+ 1;j < n;j++) {
                int a = 2*nums[i] - nums[j];
                if(map.containsKey(a)){
                    dp[i][j] = dp[map.get(a)][i] + 1;
                    ret = Math.max(ret,dp[i][j]);
                }
            }
            map.put(nums[i],i);
        }
        return ret;
    }

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
    }
}
