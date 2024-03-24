package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-19
 * Time: 22:40
 */

import java.util.*;

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
    /** 446. 等差数列划分 II - 子序列
     *  https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
     *  优化:
     *       使用哈希表把nums[i],的值和下标数组有映射关系;
     * 状态表示:
     *          dp[i][j]以i为结尾,和以j为结尾的所有子序列中,所有等差子序列的数目 其中 i < j
     * 状态转移方程:
     *          nums[k] = a,nums[i] = b,nums[j] = c;
     *          if(a = 2b-c)
     *          dp[i][j] += dp[k][i] + 1(这里加1)是因为至少有三个元素 可能会出现,只有a,b 两个元素的情况
     * 初始化:
     *         dp[i][j]全为0
     * 填表顺序:
     *         先固定最后一个,在枚举倒数第二个
     * 返回值:
     *         dp[i][j].sum();
     * 时间复杂度: O(N*N)
     * 空间复杂度: O(N*N)
     * @author xiaoxie
     * @date 2024/3/23 0:29
     * @param nums
     * @return int
     */
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++) {
            long tmp = (long)nums[i];
            if(!map.containsKey(tmp)) {
                map.put(tmp,new ArrayList<Integer>());
            }
            map.get(tmp).add(i);
        }
        int sum = 0;
        int[][] dp = new int[n][n];
        for(int j = 2; j < n;j++) {
            for(int i = 1;i < j;i++) {
                long a = 2L*nums[i] - (long)nums[j];
                if(map.containsKey(a)) {
                    for(int k : map.get(a)) {
                        if(k < i) {
                            dp[i][j] += dp[k][i] + 1;
                        }else {
                            break;
                        }
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
    /** 647. 回文子串
     * https://leetcode.cn/problems/palindromic-substrings/description/
     * 前提,我们可以把所有的回文信息填到dp表中--N*N 很重要
     * 状态表示 :
     *           dp[i][j]表示s在[i,j]位置是否为回文子串 i <= j
     * 状态转移方程:
     *           if(s.charAt(i) == s.charAt(j))
     *           1.i ==  j -> true
     *           2.i + 1  == j -> true;
     *           3. i + 1 < j dp[i][j] = dp[i+1][j-1];
     * 填表顺序:
     *           从下往上
     * 返回值:
     *           dp[i][j]中true的个数
     * 时间复杂度: O(N*N)
     * 空间复杂度: O(N*N)
     * @author xiaoxie
     * @date 2024/3/23 17:51
     * @param s
     * @return int
     */
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ret = 0;
        for(int i = n-1;i>= 0;i--) {
            for(int j = i;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 < j ?dp[i+1][j-1] : true;
                    if(dp[i][j] == true)
                        ret++;
                }
            }
        }
        return ret;
    }
    /**5. 最长回文子串
     * https://leetcode.cn/problems/longest-palindromic-substring/description/
     * 状态表示:
     *          dp[i][j]表示s在[i,j]位置上的是否为回文子串
     * 状态转移方程:
     *          if(s.charAt(i) == s.charAt(j))
     *          1.i == j true
     *          2.i + 1 = j true
     *          3.i + 1  < j dp[i][j] = dp[i+1][j-1];
     * 填表顺序:
     *          从下往上
     * 返回值:
     *        返回最大的回文子串(s.substring())
     * 时间复杂度:O(N*N)
     * 空间复杂度:O(N*N)
     * @author xiaoxie
     * @date 2024/3/23 19:27
     * @param s
     * @return java.lang.String
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int x = 0,y = 0,max = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1;i>=0;i--) {
            for(int j = i;j<n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                    if(dp[i][j]&&(j-i) > max) {
                        x = i;
                        y = j;
                        max = j-i;
                    }
                }
            }
        }
        return s.substring(x,y+1);
    }
    /** 1745. 分割回文串 IV
     * https://leetcode.cn/problems/palindrome-partitioning-iv/description/
     * 状态表示:
     *          dp[i][j]表示s在[i,j]是否为回文子串
     * 状态转移方程:
     *           if(s.charAt(i) == s.charAt(j))
     *           1.i = j true
     *           2. i+1 = j true
     *           3. i+1 < j dp[i][j] = dp[i+1][j-1]
     * 填表顺序:
     *           从下往上
     * 返回值:
     *        判断
     *         dp[0,i-1]&&dp[i,j]&&dp[j+1,n-1]
     * 时间复杂度: O(N*N)
     * 空间复杂度: O(N*N)
     * @author xiaoxie
     * @date 2024/3/23 20:19
     * @param s
     * @return boolean
     */
    public boolean checkPartitioning(String s) {
        int n = s. length();
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1;i >= 0;i--) {
            for(int j = i;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i+1 < j ? dp[i+1][j-1] : true;
                }
            }
        }
        for(int i = 1;i < n-1;i++) {
            for(int j = i;j < n-1;j++) {
                if(dp[0][i-1] && dp[i][j] && dp[j+1][n-1]) {
                    return true;
                }
            }
        }
        return false;
    }
    /** 132. 分割回文串 II
     * https://leetcode.cn/problems/palindrome-partitioning-ii/description/
     * 优化: dp[i][j]表示s在位置[i,j]上是否为回文子串
     * 状态表示:
     *           dp[i]表示为s在[0,i]上的回文子串的最少分割次数
     * 状态转移方程:
     *           1.0-i位置的子串为回文子串 0
     *           2..0-i位置的子串不是回文子串,切割后为回文子串
     *           0 < j <=i
     *           1.j 到 i 位置为回文子串: Math.min(dp[j-1] + 1)
     *           2.j 到 i 位置不是回文子串:不考虑
     * 初始值:
     *           因为求的是最小值,所以dp[i]要被初始化成最小值
     * 返回值:
     *           dp[n-1];
     * 时间复杂度:O(N*N)
     * 空间复杂度:O(N*N)
     * @author xiaoxie
     * @date 2024/3/23 21:54
     * @param s
     * @return int
     */
    public int minCut(String s) {
        int n = s.length();
        boolean[][] ret = new boolean[n][n];
        for(int i = n-1;i>=0;i--) {
            for(int j = i;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    ret[i][j] = i + 1 < j ? ret[i+1][j-1] : true;
                }
            }
        }
        int val = 0x3f3f3f3f;
        int[] dp = new int[n];
        Arrays.fill(dp,val);
        for(int i = 0;i < n;i++) {
            if(ret[0][i]) {
                dp[i] = 0;
            }else {
                for(int j = 1;j <=i;j++) {
                    if(ret[j][i]) {
                        dp[i] = Math.min(dp[i],dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[n-1];
    }
    /**516. 最长回文子序列
     * https://leetcode.cn/problems/longest-palindromic-subsequence/description/
     * 状态表示:
     *          dp[i][j]在s[i,j]位置时的最长的回文子序列的长度
     * 状态转移方程:
     *              1.  s.charAt(i) == s.charAt(j)
     *                  1. i == j  1
     *                  2. i + 1 == j 2
     *                  3. i + 1 < j dp[i + 1][j-1] + 2
     *             2.   s.charAt(i) != s.charAt(j)
     *                  dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j-1]);
     * 填表顺序:
     *             从上往下,从左往右
     * 返回值为:    dp[0][n-1]
     * 时间复杂度:O(N*N)
     * 空间复杂度:O(N*N)
     * @author xiaoxie 
     * @date 2024/3/23 23:19
     * @param s 
     * @return int 
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1;i >= 0;i--) {
            dp[i][i] = 1;
            for(int j = i + 1; j < n;j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
    /**1312. 让字符串成为回文串的最少插入次数
     *https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
     * 状态表示:
     *           dp[i][j]表示s在[i,j]区间的子串中,使它成为回文串的最少插入次数
     * 状态转移方程:
     *             1.if(s.charAt(i) == s.charAt(j))
     *                1.i == j 0
     *                2.i + 1 = j 0;
     *                3.i + 1 < j dp[i+1][j-1]
     *             2. s.charAt(i) != s.charAt(j)
     *             Math.min(dp[i][j-1] + 1,dp[i+1][j]+1)
     * 填表顺序:
     *             从下到上,从左到右
     * 返回值
     *       dp[0][n-1]
     * 时间复杂度: O(N*N)
     * 空间复杂度: O(N*N)
     * @author xiaoxie 
     * @date 2024/3/23 23:50
     * @param s 
     * @return int 
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1;i >= 0;i--) {
            for(int j = i+1;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] =  Math.min(dp[i][j-1],dp[i+1][j]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }
    /** 1143. 最长公共子序列
     * https://leetcode.cn/problems/longest-common-subsequence/description/
     * 状态表示:
     *          dp[i][j]表示s1在[0,i]区间,s2在[0,j]区间内最长 公共子序列 的长度
     * 状态转移方程:
     *              1.s1.charAt(i) == s2.charAt(j)
     *              dp[i][j] = dp[i-1][j-1] +1
     *              2.s1.charAt(i) != s2.charAt(j)
     *               1. dp[i][j] = dp[i][j-1]
     *               2. dp[i][j] = dp[i][j-1]
     *               3. dp[i][j] = dp[i-1][j-1]
     *               1和2都包含了3,并且因为求的是最长的长度所以不需要考虑3
     * 初始化:
     *         引入空串的概念,所以要加一行一列 s1 = " "+s1;s2= " "+s2;
     * 返回值:
     *        dp[n][m]
     * 时间复杂度(n*m)
     * 空间复杂度(n*m)
     * @author xiaoxie
     * @date 2024/3/24 10:55
     * @param s1
     * @param s2
     * @return int
     */
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        s1 = " " + s1;
        s2 = " " + s2;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    /**1035. 不相交的线
     *https://leetcode.cn/problems/uncrossed-lines/description/
     * 这道题实际上是求最长公共子序列
     * 状态表示:
     *          dp[i][j]表示nums1在[0,i]区间,nums2在区间[0,j]中,最长公共子序列
     * 状态转移方程:
     *           1.nums1[i] = nums2[j] dp[i][j] = dp[i-1][j-1] + 1
     *           2.nums1[i] != nums2[j]
     *             1.dp[i][j] = dp[i][j-1]
     *             2.dp[i][j] = dp[i-1][j]
     *         求 1,2的最大值
     * 初始化:
     *         加一行一列
     * 返回值:
     *         dp[n][m];
     * @author xiaoxie 
     * @date 2024/3/24 15:33
     * @param nums1
     * @param nums2 
     * @return int 
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
    /** 115. 不同的子序列
     * https://leetcode.cn/problems/distinct-subsequences/
     * 状态表示:
     *         dp[i][j]表示s在[0,i]区间上的子序列,包含t在[0,j]区间上的子串的个数
     * 状态转移方程:
     *         1.子序列的结尾为i if(s.charAt(i) == t.charAt(i)) dp[i][j] = dp[i-1][j-1];
     *         2.子序列的结尾不为i dp[i][j] = dp[i-1][j];
     *         总的dp[i][j] = dp[i-1][j] +  dp[i-1][j-1](条件);
     * 初始化:
     *         因为j为空串的话,无论如何都会有1个,而s为空串,就不存在为0
     *         第一行除了第一个为1之外,别的为0,第一列为为1
     * 返回值: t 出现的个数
     * 时间复杂度: O(NM)
     * 空间复杂度: O(NM)
     * @author xiaoxie
     * @date 2024/3/24 16:43
     * @param s
     * @param t
     * @return int
     */
    public int numDistinct(String s, String t) {
        int n = s.length(),m = t.length();
        if(n < m) return 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i <=n;i++) {
            dp[i][0] = 1;
        }

        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }
    /** 44. 通配符匹配
     * https://leetcode.cn/problems/wildcard-matching/description/
     * 状态表示:
     *          dp[i][j]表示在p在区间[0,j]的字符串是否匹配s在[0,i]区间的字符串
     * 状态转移方程:
     *           1.p[j] 为普通字符
     *           dp[i][j] = s.charAt(i) == p.charAt(j) && dp[i-1][j-1] == true;
     *           2.p[j] 为"?"
     *           dp[i][j] = dp[i-1][j-1] = true;
     *           3.p[j] 为"*"
     *             1.p[j]表示空串 dp[i][j] = dp[i][j-1]
     *             2.p[j]表示1个字符 dp[i][j] = dp[i-1][j-1]
     *             3.p[j]表示2个字符 dp[i][j] = dp[i-2][j-1]
     *             4.p[j]表示3个字符 dp[i][j] = dp[i-3][j-1]
     *             5...........
     * 优化:    3.p[j] 为"*"
     *          1.数学方法
     *          dp[i][j]    = dp[i][j-1] + dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1] + .....
     *          dp[i-1][j]  =  dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1];
     *          dp[i][j]    = dp[i][j-1] || dp[i-1][j]
     *          2.根据状态表示以及实际情况
     *          1. p[j]表示空串 dp[i][j] = dp[i][j-1]
     *          2. p[j]表示1个字符但不清除   dp[i][j] =dp[i-1][j]  继续递推,下一个要么等于空串要么表示1个字符但不清除
     *           dp[i][j]    = dp[i][j-1] || dp[i-1][j]
     * 初始化:
     *         加一行和一列,分别表示s,t空串的情况
     *         1.s,t都为空串, true
     *         2.s为空串: 只要t有一个其他字符,就为false
     *         3.t为空串: falase
     * 返回值: dp[n][m]
     * 时间复杂度: O(N*M)
     * 空间复杂度: O(N*M)
     * @author xiaoxie
     * @date 2024/3/24 18:21
     * @param ss
     * @param pp
     * @return boolean
     */
    public boolean isMatch(String ss, String pp) {
        int n = ss.length(),m = pp.length();
        boolean[][] dp = new boolean[n+1][m+1];
        pp = " " + pp;
        ss = " " + ss;
        char[] p = pp.toCharArray();
        char[] s = ss.toCharArray();
        dp[0][0] = true;
        for(int i = 1;i <= m;i++) {
            if(p[i] == '*') {
                dp[0][i] = true;
            }else {
                break;
            }
        }
        for(int i = 1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(p[j] != '?' && p[j] != '*') {
                    dp[i][j] = s[i] == p[j] && dp[i-1][j-1];
                }else if(p[j] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    /** 10. 正则表达式匹配
     * https://leetcode.cn/problems/regular-expression-matching/description/
     * 状态表示:
     *                dp[i][j]表示在p在区间[0,j]的子序列是否匹配s在[0,i]区间的字符串
     *       状态转移方程:
     *                1.p[j] 为普通字符
     *                dp[i][j] = s.charAt(i) == p.charAt(j) && dp[i-1][j-1] == true;
     *                2.p[j] 为"?"
     *                dp[i][j] = dp[i-1][j-1] = true;
     *                3.p[j] 为"*"
     *                 1. p[j-1] = '.'
     *                   1. '.''*'表示空串 dp[i][j-2]
     *                   2. '.''*'表示1个字符 dp[i-1][j-2]
     *                   2. '.''*'表示2个字符 dp[i-2][j-2]
     *                   2. '.''*'表示3个字符 dp[i-3][j-2]
     *                   3  ................
     *     优化: 数学方法
     *                  dp[i][j] = dp[i][j-2] + dp[i-1][j-2] + dp[i-2][j-2]+dp[i-3][j-2]
     *                  dp[i-1][j] = dp[i-1][j-2] + + dp[i-2][j-2]+dp[i-3][j-2]
     *                  dp[i][j] = dp[i][j-2] ||  dp[i-1][j] && p[j-1] = '.'
     *                 1.p[j]表示空串 dp[i][j] = dp[i][j-2]
     *                  2.p[j]表示1个字符 dp[i][j] = p[j-1] == s[i] && dp[i-1][j-2]
     *                  3.p[j]表示2个字符 dp[i][j] = p[j-1] == s[i] && dp[i-2][j-2]
     *                  4.p[j]表示3个字符 dp[i][j] = p[j-1] == s[i] && dp[i-3][j-2]
     *                 5...........
     *       优化:    3.p[j] 为"*"
     *                1.数学方法
     *               dp[i][j]    = dp[i][j-2] + dp[i-1][j-1] + dp[i-2][j-2] + dp[i-3][j-2] + .....
     *               dp[i-1][j]  =  dp[i-1][j-2] + dp[i-2][j-2] + dp[i-3][j-2];
     *               dp[i][j]    = dp[i][j-2] || dp[i-1][j] &&  p[j-1] == s[i]
     *               2.根据状态表示以及实际情况
     *               1. p[j]表示空串 dp[i][j] = dp[i][j-2]
     *               2. p[j]表示1个字符但不清除   dp[i][j] =dp[i-1][j]  继续递推,下一个要么等于空串要么表示1个字符但不清除
     *                dp[i][j]    = dp[i][j-1] || dp[i-1][j] &&  p[j-1] == s[i]
     *      初始化:
     *              加一行和一列,分别表示s,t空串的情况
     *              1.s,t都为空串, true
     *             2.s为空串:必须'*' 为偶数位连续出现时,就为false
     *              3.t为空串: falase
     *      返回值: dp[n][m]
     *      时间复杂度: O(N*M)
     *      空间复杂度: O(N*M)
     * @author xiaoxie
     * @date 2024/3/24 21:55
     * @param ss
     * @param pp
     * @return boolean
     */
    public boolean isMatch2(String ss, String pp) {
        int n = ss.length(),m = pp.length();
        boolean[][] dp = new boolean[n+1][m+1];
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        dp[0][0] = true;
        for(int i = 2; i <= m;i+= 2) {
            if(p[i] == '*') dp[0][i] = true;
            else break;
        }
        for(int i = 1; i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(p[j] == '*') {
                    dp[i][j] = dp[i][j-2] || (p[j-1] == s[i] || p[j-1] == '.') && dp[i-1][j];
                }else {
                    dp[i][j] = (p[j] == '.' || p[j] == s[i]) && dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }

    /**97. 交错字符串
     *https://leetcode.cn/problems/interleaving-string/description/
     *状态表示:
     *          dp[i][j]表示s1在区间[0,i]和s2在区间[0,j]拼接而成的字符串能否匹配s3在区间[0,i+j]的字符串
     * 状态表示:
     *           1.s1[i] == s3[i+j]
     *             dp[i][j] = dp[i-1][j]
     *           2. s2[j] == s3[i+j]
     *             dp[i][j] = dp[i][j-1];
     * 初始化:
     *        引入空串的概念:
     *        dp[0][0] ->true
     *         第一行-> s1为空 s2[i] == s3[i] 只要有不同就为false
     *         第一列 -> s2 为空 s1[j] == s3[j]只要有不同就为false
     * 返回值:
     *          dp[n][m]
     * 时间复杂度: O(N*M)
     * 空间复杂度: O(N*M)
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(),m = s2.length();
        if(n+m != s3.length()) return false;
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        char[] s = s1.toCharArray();
        char[] p = s2.toCharArray();
        char[] t = s3.toCharArray();
        for(int i = 1; i <= m;i++) {
            if(p[i] == t[i]) dp[0][i] = true;
            else break;
        }
        for(int i = 1; i <= n;i++) {
            if(s[i] == t[i]) dp[i][0] = true;
            else break;
        }
        for(int i =1; i <= n; i++) {
            for(int j = 1; j <= m;j++) {
                dp[i][j] = (s[i] == t[i+j] && dp[i-1][j]) || (p[j] == t[i+ j] && dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
    }
}
