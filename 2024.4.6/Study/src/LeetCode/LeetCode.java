package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-06
 * Time: 19:59
 */

import javafx.util.Pair;

import java.util.*;

/** 力扣刷题加油
 * * @author xiaoxie
 * @date 2024年04月06日 19:59
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
   this.left = left;
         this.right = right;
   }
 }
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
    /** JZ57 和为S的两个数字
     * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&ru=/exam/oj
     * 利用单调性,双指针解决,无敌
     * @author xiaoxie
     * @date 2024/4/7 8:14
     * @param array
     * @param sum
     * @return java.util.ArrayList<java.lang.Integer>
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (array == null || array.length < 2) {
            return ret;
        }
        int n = array.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                ret.add(array[left]);
                ret.add(array[right]);
                return ret;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }
    /** 15. 三数之和
     * https://leetcode.cn/problems/3sum/description/
     * 使用排序加双指针
     * @author xiaoxie
     * @date 2024/4/7 9:05
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] < -x) {
                    left++;
                } else if (nums[left] + nums[right] > -x) {
                    right--;
                } else {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(x);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    ret.add(ans);
                    for (++left;nums[left] == nums[left - 1] && left < right; ++left);
                    for (--right;nums[right] == nums[right + 1] && right > left; --right);
                }
            }
        }
        return ret;
    }
    /** 18. 四数之和
     * https://leetcode.cn/problems/4sum/description/
     * 和前面三数和一样,都是根据两数之和的解法扩展
     * @author xiaoxie
     * @date 2024/4/7 9:39
     * @param nums
     * @param target
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        if(n < 4) {
            return ret;
        }
        Arrays.sort(nums);
        for(int i = 0;i < n-3;i++) {
            int x = nums[i];
            if(i > 0 && x == nums[i-1]) continue;
            if((long)x + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            if((long)x + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
            for(int j = i + 1; j < n-2;j++) {
                int y = nums[j];
                if(j > i + 1 && nums[j-1] == y) continue;
                if((long) x + y + nums[j+1]+nums[j+2] > target) break;
                if((long) x + y + nums[n-2] + nums[n-1] < target) continue;
                int left = j + 1,right = n-1;
                while(left < right) {
                    if((long) x + y + nums[left] + nums[right] < target) {
                        left++;
                    }else if((long) x + y + nums[left] + nums[right] > target) {
                        right--;
                    }else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(x);
                        ans.add(y);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        ret.add(ans);
                        for(++left;nums[left] == nums[left-1] && left < right;++left);
                        for(--right;nums[right] == nums[right+1] && right > left;--right);
                    }
                }
            }
        }
        return ret;
    }
    /** 209.长度最小的子数组
     * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
     * 滑动窗口(同向双指针)
     * 时间复杂度其实是O(N)虽然是两个循环,但实际上的两个指针移动的最多就为2n.(根据具体问题具体分析)
     * @author xiaoxie
     * @date 2024/4/7 20:27
     * @param target
     * @param nums
     * @return int
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length,sum = 0,ret = 0x3f3f3f3f,left = 0,right = 0;
        while(right != n) {
            sum += nums[right];//进窗口
            while(sum >= target) {//判断
                int len = right - left + 1;
                ret = Math.min(ret,len);//更新结果
                sum -= nums[left++];//出窗口
            }
            right++;
        }
        return ret == 0x3f3f3f3f ? 0 : ret;
    }
    /** 3. 无重复字符的最长子串
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
     * @author xiaoxie
     * @date 2024/4/7 21:04
     * @param s
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int[] hash = new int[128];
        int ret = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            hash[str[right]]++;
            while (hash[str[right]] > 1) {
                hash[str[left++]]--;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }

    /** 1004. 最大连续1的个数 III
     * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
     * 转化为求一个最长的子数组,0的个数不超过k
     * @author xiaoxie
     * @date 2024/4/7 21:46
     * @param nums
     * @param k
     * @return int
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, ret = 0, zero = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zero++;
                if (zero > k) {
                    while (zero > k) {
                        if (nums[left++] == 0) {
                            zero--;
                        }
                    }
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
    /** 1658. 将 x 减到 0 的最小操作数
     * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
     * 正难则反,转化成求一个最长的子数组,该子数组的和刚好等于sum - x
     * @author xiaoxie
     * @date 2024/4/7 22:31
     * @param nums
     * @param x
     * @return int
     */
    public int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0, ret = -1;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0)
            return -1;
        for (int left = 0, right = 0, ans = 0; right < n; right++) {
            ans += nums[right];
            while (ans > target) {
                ans -= nums[left++];
            }
            if (ans == target) {
                ret = Math.max(ret, (right - left + 1));
            }
        }
        return ret == -1 ? -1 : n - ret;
    }
    /**904. 水果成篮
     * https://leetcode.cn/problems/fruit-into-baskets/description/
     * @author xiaoxie
     * @date 2024/4/7 22:46
     * @param fruits
     * @return int
     */
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] hash = new int[n];
        int same = 0,ret = 0;
        for(int left = 0,right = 0;right < n;right++) {
            if(++hash[fruits[right]] == 1) {
                same++;
            }
            while(same > 2) {
                if(--hash[fruits[left++]] == 0) {
                    same--;
                }
            }
            ret = Math.max(ret, right -left+ 1);
        }
        return ret;
    }
    /** 438. 找到字符串中所有字母异位词
     * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
     * @author xiaoxie
     * @date 2024/4/8 15:37
     * @param s
     * @param p
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer>  findAnagrams(String s, String p) {
        int m = p.length();
        int n = s.length();
        char[] str = s.toCharArray();
        List<Integer> ret = new ArrayList<>();
        int[] hash = new int[27];
        if(m > n) return ret;
        for(char ch : p.toCharArray()) {
            hash[ch-'a']++;
        }
        for(int left = 0,right = 0;right <n;right++) {
            --hash[str[right]-'a'];
            while(hash[str[right]-'a'] < 0) {
                ++hash[str[left++]-'a'];
            }
            if(right - left + 1 == m) {
                ret.add(left);
            }
        }
        return ret;
    }
    /** 30. 串联所有单词的子串
     * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/
     * @author xiaoxie
     * @date 2024/4/9 12:27
     * @param s
     * @param words
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int len = words[0].length();
        int num = words.length;
        List<Integer> ret = new ArrayList<>();
        if (n < len * num){
            return ret;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for(int i = 0; i< len;i++) {
            Map<String, Integer> hash = new HashMap<>();
            for(int left = i,right = i,same = 0;right + len <= n;right += len) {
                String in = s.substring(right,right + len);
                hash.put(in,hash.getOrDefault(in,0)+1);
                if(hash.get(in) <= map.getOrDefault(in,0)) {
                    same++;
                }
                if(right - left + 1 > len * num) {
                    String out = s.substring(left,left +len);
                    if(hash.get(out) <= map.getOrDefault(out,0)) {
                        same--;
                    }
                    hash.put(out,hash.get(out)-1);
                    left += len;
                }
                if(same == num) {
                    ret.add(left);
                }
            }
        }
        return ret;
    }
    /** 76. 最小覆盖子串
     *  https://leetcode.cn/problems/minimum-window-substring/description/
     * @author xiaoxie
     * @date 2024/4/9 12:49
     * @param s
     * @param t
     * @return java.lang.String
     */
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m)
            return new String();
        int[] window = new int[128];
        for (char c : t.toCharArray()) {
            window[c]++;
        }
        char[] str = s.toCharArray();
        int minlen = 0x3f3f3f3f, minleft = 0;
        for (int left = 0, right = 0, same = m; right < n; right++) {
            if (window[str[right]]-- > 0) {
                same--;
            }
            while (same <= 0) {
                if (right - left + 1 < minlen) {
                    minlen = right - left + 1;
                    minleft = left;
                }
                if (window[str[left++]]++ == 0) {
                    same++;
                }
            }
        }
        return minlen == 0x3f3f3f3f ? "" : s.substring(minleft, minleft + minlen);
    }
    /** 704. 二分查找
     * https://leetcode.cn/problems/binary-search/description/
     * 简单的二分
     * 模板一
     * while(left <= right)
     * {
     *  int mid = left + ((right-left) >>1);
     *  if(........)
     *  {
     *   left = mid + 1;
     *  }
     *  else if(........)
     *  {
     *   right = mid - 1;
     *   }else
     *   {
     *    return .....;
     *          }
     *      }
     * @author xiaoxie
     * @date 2024/4/9 14:27
     * @param nums
     * @param target
     * @return int
     */
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right) {
            int mid = left + ((right-left) >>1);
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    /** 34. 在排序数组中查找元素的第一个和最后一个位置
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
     * 模板二:
     * 查找区间左端点的模板
     * while(left < right)
     * {
     *   int mid = left + ((right - left) >> 1);
     *     if(..........)
     *        left = mid + 1;
     *       else
     *        right = mid;
     *  查找区间右端点的模板
     *  while(left < right)
     * {
     *   int mid = left + ((right - left + 1) >> 1);
     *        if(..........)
     *        right = mid + 1;
     *         else
     *        left = mid;
     * @author xiaoxie
     * @date 2024/4/9 15:25
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[]{-1,-1};
        int right = searchRight(nums,target,n);
        int left = searchLeft(nums,target,n);
        return new int[]{left,right};
    }
    private int searchLeft(int[] nums,int target,int n) {
        int left = 0,right = n-1;
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
    private int searchRight(int[] nums,int target,int n) {
        int left = 0,right = n-1;
        while(left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if(nums[mid] <= target) {
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return nums[left] == target ? left : -1;
    }
    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2;
        int ans = -1;
        if(x == 0 || x == 1) {
            return x;
        }
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (mid * mid == x) {
                return mid;
            } else if(mid > x / mid) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
    /** 35. 搜索插入位置
     * https://leetcode.cn/problems/search-insert-position/description/
     * @author xiaoxie
     * @date 2024/4/9 16:13
     * @param nums
     * @param target
     * @return int
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = left + ((right-left + 1) >>1);
            if(nums[mid] <= target) {
                left = mid;
            }else {
                right = mid-1;
            }
        }
        if(nums[left] > target) return 0;
        return nums[left] == target ? left : left + 1;
    }
    /** 852. 山脉数组的峰顶索引
     * https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/
     * 二分
     * @author xiaoxie
     * @date 2024/4/9 16:36
     * @param arr
     * @return int
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1,right = arr.length-2;
        while(left < right) {
            int mid = left + ((right-left + 1)>>1);
            if(arr[mid] >= arr[mid-1]) {
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    /** 162. 寻找峰值
     * https://leetcode.cn/problems/find-peak-element/description/
     * @author xiaoxie
     * @date 2024/4/9 16:48
     * @param nums
     * @return int
     */
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = left + ((right-left)>>1);
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
    /** 724. 寻找数组的中心下标
     * https://leetcode.cn/problems/find-pivot-index/description/
     * @author xiaoxie
     * @date 2024/4/9 19:03
     * @param nums
     * @return int
     */
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
    /** 使用前缀积和后缀积的思想来解这题
     *f[i] 表示为[0,i-1]的所有乘积
     *g[i] 表示为[i+1,n-1]的所有乘积
     *f[i] = f[i-1] * nums[i-1];
     *g[i] = g[i+1] * nums[i+1];
     *g[i]可以在更新答案的时候逆序输入,就可以省去g[i]
     * @author xiaoxie
     * @date 2024/4/9 20:20
     * @param nums
     * @return int[]
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int[] f = new int[n];
        f[0] = 1;
        for(int i = 1;i < n;i++) {
            f[i] = f[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i = n-1;i >= 0;i--){
            ret[i] = f[i] * right;
            right *= nums[i];
        }
        return ret;
    }
    /** 560. 和为 K 的子数组
     * https://leetcode.cn/problems/subarray-sum-equals-k/description/
     * 定义一个以i位置为结尾的哈希表映射关系
     * 细节:
     * 在计算i位置之前,先计算[0,i-1]位置之前
     * 可以用滚动数组的思想来优化空间复杂度
     * map<int,int> - > <前缀和,前缀和出现的次数> 一边遍历一边填表
     * @author xiaoxie
     * @date 2024/4/9 20:57
     * @param nums
     * @param k
     * @return int
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0,count = 0;
        for(int i = 0; i < n;i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)) {
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return count;
    }
    /** 974. 和可被 K 整除的子数组
     * https://leetcode.cn/problems/subarray-sums-divisible-by-k/description/
     * 这题需要注意的地方
     * 1.入数组中可能包含负数，所以在计算和的余数时，
     * 我们需要使用(sum % k + k) % k来确保得到的余数在[0, k-1]范围内。这样可以避免负数对余数计算的影响。
     * 2.因为余数的范围是[0,k-1]所以hash数组的长度为k记录前缀和为k的余数的次数即可
     * @author xiaoxie
     * @date 2024/4/9 21:22
     * @param nums
     * @param k
     * @return int
     */
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] hash = new int[k];
        hash[0] = 1;
        int sum = 0,ret = 0;
        for(int i = 0;i < n;i++) {
            sum += nums[i];
            int modulus = (sum % k + k) % k;
            ret += hash[modulus];
            hash[modulus]++;
        }
        return ret;
    }
    /** 525. 连续数组
     * https://leetcode.cn/problems/contiguous-array/description/
     * @author xiaoxie
     * @date 2024/4/9 22:00
     * @param nums
     * @return int
     */
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0,ret = 0,n = nums.length;
        map.put(0,-1);
        for(int i = 0;i < n;i++) {
            if(nums[i] == 0) {
                sum += -1;
            }else {
                sum += 1;
            }
            if(map.containsKey(sum)) {
                ret = Math.max(ret,i-map.get(sum));
            }else{
                map.put(sum,i);/// 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
            }
        }
        return ret;
    }
    /** 1314. 矩阵区域和
     * https://leetcode.cn/problems/matrix-block-sum/description/
     * @author xiaoxie
     * @date 2024/4/9 22:57
     * @param mat
     * @param k
     * @return int[][]
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ret = new int[m][n];
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] + mat[i-1][j-1] - dp[i-1][j-1];
            }
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                int x1 = i-k >= 0 ? i-k : 0;
                int y1 = j-k >= 0 ? j-k : 0;
                int x2 = i+ k < m ? i+k : m-1;
                int y2 = j + k < n ? j + k : n-1;
                ret[i][j] = dp[x2 + 1][y2 + 1] - dp[x2+1][y1] - dp[x1][y2+1]+dp[x1][y1];
            }
        }
        return ret;
    }
    /** 191. 位1的个数
     * https://leetcode.cn/problems/number-of-1-bits/description/
     * 每次循环干掉最右侧的1
     * @author xiaoxie
     * @date 2024/4/10 12:30
     * @param n
     * @return int
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }
    /** 338. 比特位计数
     * https://leetcode.cn/problems/counting-bits/description/
     * 动态规划和位运算
     * @author xiaoxie
     * @date 2024/4/10 14:08
     * @param n
     * @return int[]
     */
    public int[] countBits(int n) {
        int[] bit = new int[n+1];
        for(int i = 1;i <= n;i++) {
            bit[i] = bit[i & (i-1)] + 1;
        }
        return bit;
    }
    /** 461. 汉明距离
     * https://leetcode.cn/problems/hamming-distance/description/
     * 先使用 ^ 把两个数的1放到一起
     * 再根据 s &= (s-1)
     * 每次把最右边的1给删去
     * @author xiaoxie
     * @date 2024/4/10 14:12
     * @param x
     * @param y
     * @return int
     */
    public int hammingDistance(int x, int y) {
        int s = x ^ y,ret = 0;
        while(s != 0) {
            s &= (s-1);
            ret++;
        }
        return ret;
    }
    /** 136. 只出现一次的数字
     * https://leetcode.cn/problems/single-number/description/
     * 利用一个性质 a ^ a = 0; a ^ 0 = a;
     * @author xiaoxie
     * @date 2024/4/10 14:24
     * @param nums
     * @return int
     */
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int num : nums) {
            ret ^= num;
        }
        return ret;
    }
    /** 260. 只出现一次的数字 III
     * https://leetcode.cn/problems/single-number-iii/description/
     * 第一次 ^ 运算,求得两个数字的异或和
     * sum & (-sum) 提前一个1,就可以把这两个数分为两类
     * @author xiaoxie
     * @date 2024/4/10 14:39
     * @param nums
     * @return int[]
     */
    public int[] singleNumber2(int[] nums) {
        int sum  = 0;
        for(int num : nums) {
            sum ^= num;
        }
        int tmp = sum == Integer.MAX_VALUE ? sum : sum & (-sum);
        int s1 = 0,s2 = 0;
        for(int num : nums) {
            if((num & tmp) != 0) {
                s1 ^= num;
            }else {
                s2 ^= num;
            }
        }
        return new int[]{s1,s2};
    }
    /** 面试题 01.01. 判定字符是否唯一
     * https://leetcode.cn/problems/is-unique-lcci/description/
     * 位图
     * @author xiaoxie
     * @date 2024/4/10 15:17
     * @param astr
     * @return boolean
     */
    public boolean isUnique(String astr) {
        if(astr.length() > 26) return false;
        int ret = 0;
        //规定 0 为 没出现过 1 为出现过位图的思想
        for(char ch : astr.toCharArray()) {
            int x = ch-'a';
            if(((ret>>x) &1)== 1) {
                return false;
            }else {
                ret |= (1<<x);
            }
        }
        return true;
    }
    /** 268. 丢失的数字
     * https://leetcode.cn/problems/missing-number/description/
     * 利用 ^ 结合率
     * @author xiaoxie
     * @date 2024/4/10 15:30
     * @param nums
     * @return int
     */
    public int missingNumber(int[] nums) {
        int ret = 0;
        for(int num : nums) {
            ret ^= num;
        }
        for(int i = 0;i <= nums.length;i++) {
            ret ^= i;
        }
        return ret;
    }
    /** 371. 两整数之和
     * https://leetcode.cn/problems/sum-of-two-integers/description/
     * 使用 ^ 运算的无进制位相加的特性
     * @author xiaoxie
     * @date 2024/4/10 15:42
     * @param a
     * @param b
     * @return int
     */
    public int getSum(int a, int b) {
        while(b != 0) {
            int tmp = (a & b )<< 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
    /** 137. 只出现一次的数字 II
     * https://leetcode.cn/problems/single-number-ii/description/
     * 使用位图
     * O(NlogC)
     * @author xiaoxie
     * @date 2024/4/10 16:19
     * @param nums
     * @return int
     */
    public int singleNumber3(int[] nums) {
        int ret = 0;
        for(int i = 0;i < 32;i++) {
            int sum = 0;
            for(int num : nums) {//计算所有num第i位为多少
                if(((num >>i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            if(sum == 1) {
                ret |= 1 << i;
            }
        }
        return ret;
    }
    /** 137. 只出现一次的数字 II
     * 时间复杂度为O(N)到时候再研究
     * @author xiaoxie
     * @date 2024/4/10 16:20
     * @param nums
     * @return int
     */
    public int singleNumber3_1(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;

    }
    /** 面试题 17.19. 消失的两个数字
     * https://leetcode.cn/problems/missing-two-lcci/description/
     * 这道题就是 丢死的数字 + 消失的数字||| 两题的结合版
     * @author xiaoxie
     * @date 2024/4/10 16:32
     * @param nums
     * @return int[]
     */
    public int[] missingTwo(int[] nums) {
        int sum = 0;
        int n = nums.length + 2;
        for(int num : nums) {
            sum ^= num;
        }
        for(int i = 1;i <= n;i++) {
            sum ^= i;
        }
        int tmp = sum == Integer.MAX_VALUE? sum : sum & (-sum);
        int s1 = 0,s2 = 0;
        for(int num : nums) {
            if ((num & tmp) != 0) {
                s1 ^= num;
            } else {
                s2 ^= num;
            }
        }
        for(int i = 1; i <= n; i++) {
            if ((i & tmp) != 0) {
                s1 ^= i;
            } else {
                s2 ^= i;
            }
        }
        return new int[]{s1,s2};
    }
    /** 1576. 替换所有的问号
     * https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/description/
     * 简单的模拟
     * @author xiaoxie
     * @date 2024/4/10 17:02
     * @param s
     * @return java.lang.String
     */
    public String modifyString(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        for(int i = 0;i < n;i++) {
            if(str[i] == '?') {
                for(char ch = 'a'; ch <= 'z';ch++) {
                    if((i== 0 || ch != str[i-1]) && (i == n-1 || ch != str[i+1])) {
                        str[i] = ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(str);
    }
    /** 495. 提莫攻击
     * https://leetcode.cn/problems/teemo-attacking/description/
     * 简单的模拟
     * @author xiaoxie
     * @date 2024/4/10 17:16
     * @param timeSeries
     * @param duration
     * @return int
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = 0,time = 0,n = timeSeries.length;
        for(int i = 0; i < n;i++) {
            if(timeSeries[i] >= time) {
                ret += duration;
            }else {
                ret += timeSeries[i] + duration - time;
            }
            time = timeSeries[i] + duration;
        }
        return ret;
    }
    /** 429. N 叉树的层序遍历
     * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/
     * 队列加层序遍历
     * @author xiaoxie
     * @date 2024/4/11 10:34
     * @param root
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0;i < sz;i++) {
                Node node = q.poll();
                tmp.add(node.val);
                for(Node child : node.children) {
                    if(child != null) {
                        q.add(child);
                    }
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
    /** 103. 二叉树的锯齿形层序遍历
     * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
     * 使用双端队列 + 层序遍历
     * @author xiaoxie
     * @date 2024/4/11 10:54
     * @param root
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int count = 0;//规定偶数从左往右,奇数从右往左
        while(!q.isEmpty()) {
            int sz = q.size();
            Deque<Integer> tmp = new LinkedList<>();
            for(int i = 0;i < sz;i++) {
                TreeNode cur = q.poll();
                if(count % 2 == 0) {
                    tmp.offerFirst(cur.val);
                }else {
                    tmp.offerLast(cur.val);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
                if(cur.left != null) {
                    q.offer(cur.left);
                }
            }
            count++;
            ret.add(new LinkedList<Integer>(tmp));
        }
        return ret;
    }
    /** 662. 二叉树最大宽度
     * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
     * 利用二叉树存储在数组中,孩子下标和双亲节点的关系为 x -> 2*x,2*x + 1
     * 利用上文的规则,在加上层序遍历(BFS)
     * @author xiaoxie
     * @date 2024/4/11 14:49
     * @param root
     * @return int
     */
    public int widthOfBinaryTree(TreeNode root) {
        int ret = 0;
        List<Pair<TreeNode,Integer>> q = new ArrayList<Pair<TreeNode, Integer>>();
        q.add(new Pair<TreeNode,Integer> (root , 1));
        while(!q.isEmpty()) {
            //求得每一层的最后一个元素减第一个元素
            Pair<TreeNode,Integer> t1 = q.get(0);
            Pair<TreeNode,Integer> t2 = q.get(q.size() - 1);
            ret = Math.max(ret,t2.getValue()-t1.getValue() + 1);
            List<Pair<TreeNode,Integer>> tmp = new ArrayList<Pair<TreeNode, Integer>>();
            for(Pair<TreeNode,Integer> t : q) {
                TreeNode cur = t.getKey();
                int index = t.getValue();
                if(cur.left != null) {
                    tmp.add(new Pair<TreeNode,Integer>(cur.left,index *2));
                }
                if(cur.right != null) {
                    tmp.add(new Pair<TreeNode,Integer>(cur.right,index *2 + 1));
                }
            }
            q = tmp; // 使用数组覆盖来模拟出队列;
        }
        return ret;
    }
    /** LCR 044. 在每个树行中找最大值
     * https://leetcode.cn/problems/hPov7L/description/
     * 简单的BFS
     * @author xiaoxie
     * @date 2024/4/11 15:01
     * @param root
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0;i < sz;i++) {
                TreeNode cur = q.poll();
                max = Math.max(max,cur.val);
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            ret.add(max);
        }
        return ret;
    }
    /**1046. 最后一块石头的重量
     * https://leetcode.cn/problems/last-stone-weight/description/
     * 优先级队列
     * @author xiaoxie
     * @date 2024/4/11 15:08
     * @param stones
     * @return int
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones) {
            heap.offer(stone);
        }
        while(heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            if(x > y) {
                heap.offer(x-y);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
    /** 347. 前 K 个高频元素
     * https://leetcode.cn/problems/top-k-frequent-elements/description/
     * 这题等五一的时候在写一边,手搓快排加二分,顺便把堆排也给复习一下
     * @author xiaoxie
     * @date 2024/4/11 15:37
     * @param nums
     * @param k
     * @return int[]
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            q.offer(new int[]{entry.getValue(),entry.getKey()});
        }
        while(q.size() > k) {
            q.poll();
        }
        int[] ret = new int[k];
        for(int i = 0;i < k;i++) {
            ret[i] = q.poll()[1];
        }
        return ret;
    }
    /** 1926. 迷宫中离入口最近的出口
     * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/
     * BFS
     * @author xiaoxie
     * @date 2024/4/11 17:08
     * @param null
     * @return null
     */
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    public int nearestExit(char[][] maze, int[] e) {
        int m = maze.length,n = maze[0].length;
        boolean[][] vis = new boolean [m][n];
        Queue<int[]> q = new LinkedList<>();
        int step = 0;
        q.add(new int[]{e[0],e[1]});
        vis[e[0]][e[1]] = true;
        while(!q.isEmpty()) {
            step++;
            int sz = q.size();
            for(int i = 0;i < sz;i++) {
                int[] tmp = q.poll();
                int a = tmp[0],b = tmp[1];
                for(int j = 0;j < 4;j++) {
                    int x = a + dx[j],y = b+ dy[j];
                    if(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.'&& !vis[x][y]) {
                        if(x == 0 || x == m-1 || y == 0 || y == n -1) {
                            return step;
                        }
                        q.add(new int[]{x,y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
    /** 433. 最小基因变化
     * https://leetcode.cn/problems/minimum-genetic-mutation/description/
     * BFS
     * @author xiaoxie
     * @date 2024/4/11 18:44
     * @param startGene
     * @param endGene
     * @param bank
     * @return int
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> vis = new HashSet<>();// 记录修改过的基因序列
        Set<String> hash = new HashSet<>();// 记录Bank的基因序列
        for (String str : bank) {
            hash.add(str);
        }
        if (startGene.equals(endGene))
            return 0;
        if (!hash.contains(endGene))
            return -1;
        int step = 0;
        char[] ch = { 'A', 'C', 'G', 'T' };
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        while (!q.isEmpty()) {
            step++;
            int sz = q.size();
            while (sz-- > 0) {
                String s = q.poll();
                for (int i = 0; i < 8; i++) {
                    char[] tmp = s.toCharArray();
                    for (int j = 0; j < 4; j++) {
                        tmp[i] = ch[j];
                        String check = new String(tmp);
                        if (hash.contains(check) && !vis.contains(check)) {
                            if (check.equals(endGene))
                                return step;
                            q.add(check);
                            vis.add(check);
                        }
                    }
                }
            }

        }
        return -1;
    }
    /** 127. 单词接龙
     * https://leetcode.cn/problems/word-ladder/
     * BFS解决图问题
     * @author xiaoxie
     * @date 2024/4/12 10:19
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return int
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> vis = new HashSet<>();// 修改后的单词
        Set<String> hash = new HashSet<>();
        for (String str : wordList) {
            hash.add(str);
        }
        int n = endWord.length();
        if (!hash.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vis.add(beginWord);
        int ret = 1;
        while (!q.isEmpty()) {
            ret++;
            int sz = q.size();
            while (sz-- > 0) {
                String tmp = q.poll();
                for (int i = 0; i < tmp.length(); i++) {
                    char[] next = tmp.toCharArray();
                    for (char change = 'a'; change <= 'z'; change++) {
                        next[i] = change;
                        String s = new String(next);
                        if (hash.contains(s) && !vis.contains(s)) {
                            if (s.equals(endWord))
                                return ret;
                            q.add(s);
                            vis.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
    /** 675. 为高尔夫比赛砍树
     * https://leetcode.cn/problems/cut-off-trees-for-golf-event/description/
     * BFS
     * @author xiaoxie
     * @date 2024/4/12 11:41
     * @param forest
     * @return int
     */
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(),n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();//记录下来树的高度
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i,j});
                }
            }
        }
        Collections.sort(trees,(a,b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
        //把每个问题分解成若干个迷宫问题
        int ret = 0;
        int x = 0,y = 0;//起点
        for(int[] tree : trees) {
            int next1 = tree[0];//终点
            int next2 = tree[1];
            int ans = bfs(forest,x,y,next1,next2);
            if(ans == -1) return -1;
            ret += ans;
            x = next1;//更新起点
            y = next2;
        }
        return ret;
    }

    private int bfs(List<List<Integer>> forest,int x,int y,int next1,int next2) {
        if(x == next1 && y == next2) return 0;
        Queue<int[]> q = new LinkedList<>();
        int m = forest.size();
        int n= forest.get(0).size();
        boolean[][] vis = new boolean[m][n];
        q.add(new int[]{x,y});
        vis[x][y] = true;
        int ret = 0;
        while(!q.isEmpty()) {
            ret++;
            int sz = q.size();
            while(sz-- > 0) {
                int[] tmp = q.poll();
                int t1 = tmp[0],t2 = tmp[1];
                for(int i = 0;i < 4;i++) {
                    int move1 = t1 + dx[i],move2 = t2 + dy[i];
                    if(move1 >= 0 && move1 < m && move2 >= 0 && move2 < n && !vis[move1][move2]
                            && forest.get(move1).get(move2)!= 0) {
                        if(move1 == next1 && move2 == next2) {
                            return ret;
                        }
                        q.add(new int[]{move1,move2});
                        vis[move1][move2] = true;
                    }
                }
            }
        }
        return -1;
    }
    /** 542. 01 矩阵
     * https://leetcode.cn/problems/01-matrix/description/
     *
     * @author xiaoxie
     * @date 2024/4/12 15:41
     * @param mat
     * @return int[][]
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int a = tmp[0], b = tmp[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                    q.add(new int[] { x, y });
                    dist[x][y] = dist[a][b] + 1;
                    vis[x][y] = true;
                }
            }
        }
        return dist;
    }
    /** 1020. 飞地的数量
     * https://leetcode.cn/problems/number-of-enclaves/description/
     * 和太平洋和大西洋的题很像都是先找到边缘的陆地和与边缘陆地相连的陆地
     * BFS
     * @author xiaoxie
     * @date 2024/4/12 16:16
     * @param grid
     * @return int
     */
    public int numEnclaves(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < m;i++) {
            if(grid[i][0] == 1) {
                q.add(new int[]{i,0});
                vis[i][0] = true;
            }
            if(grid[i][n-1] == 1) {
                q.add(new int[]{i,n-1});
                vis[i][n-1] = true;
            }
        }
        for(int j = 0;j < n;j++) {
            if(grid[0][j] == 1) {
                q.add(new int[]{0,j});
                vis[0][j] = true;
            }
            if(grid[m-1][j] == 1) {
                q.add(new int[]{m-1,j});
                vis[m-1][j] = true;
            }
        }
        while(!q.isEmpty()) {

                int[] tmp = q.poll();
                int a = tmp[0],b = tmp[1];
                for(int i = 0;i < 4;i++) {
                    int x = a + dx[i],y = b + dy[i];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !vis[x][y]) {
                        vis[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
        }
        int ret = 0;
        for(int i = 1;i < m;i++) {
            for(int j = 1; j < n;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    ret++;
                }
            }
        }
        return ret;
    }
    /** 1765. 地图中的最高点
     * https://leetcode.cn/problems/map-of-highest-peak/description/
     * @author xiaoxie
     * @date 2024/4/12 16:40
     * @param isWater
     * @return int[][]
     */
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length,n = isWater[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m;i++){
            Arrays.fill(dist[i], -1); // -1 表示该格子尚未被访问过
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {
                if(isWater[i][j] == 1) {
                    dist[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int a = tmp[0],b = tmp[1];
            for(int i = 0;i < 4;i++) {
                int x = a + dx[i],y = b + dy[i];
                if(x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[a][b] + 1;
                    q.add(new int[]{x,y});
                }
            }
        }
        return dist;
    }
    /** 1162. 地图分析
     * https://leetcode.cn/problems/as-far-from-land-as-possible/description/
     * @author xiaoxie
     * @date 2024/4/12 17:15
     * @param grid
     * @return int
     */
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(vis[i], -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }
        int count=q.size();
        if (count==n*n || count==0)
            return -1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int a = tmp[0], b = tmp[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y] == -1) {
                    vis[x][y] = vis[a][b] + 1;
                    q.add(new int[] { x, y });
                }
            }
        }
        int ret = -1;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == 0) {
                    ret = Math.max(ret,vis[i][j]);
                }
            }
        }
        return ret;
    }
    /** 207. 课程表
     * https://leetcode.cn/problems/course-schedule/description/
     * 拓扑排序
     * @author xiaoxie
     * @date 2024/4/12 19:46
     * @param num
     * @param p
     * @return boolean
     */
    public boolean canFinish(int num, int[][] p) {
        //使用Map来充当邻接表的容器
        int n = p.length;
        Map<Integer,List<Integer>> edges = new HashMap<>();
        //使用in数组来统计该点的入度信息
        int[] in = new int[num];
        //创建图
        for(int i = 0;i < n;i++) {
            int a = p[i][0],b = p[i][1]; // b -> a
            if(!edges.containsKey(b)) {
                edges.put(b,new ArrayList<>());
            }
            edges.get(b).add(a);
            in[a]++;
        }
        //拓扑排序
        Queue<Integer> q = new LinkedList<>();
        //判断一下入度为0的点
        for(int i = 0;i < num;i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        int vis = 0;
        while(!q.isEmpty()) {
            vis++;
            int t = q.poll();
            for(int edge : edges.getOrDefault(t,new ArrayList<>())) {
                in[edge]--;
                if(in[edge] == 0) {
                    q.add(edge);
                }
            }
        }
        return vis == num;
    }
    /** 210. 课程表 II
     * https://leetcode.cn/problems/course-schedule-ii/description/
     * 拓扑排序
     * @author xiaoxie
     * @date 2024/4/12 20:04
     * @param numCourses
     * @param p
     * @return int[]
     */
    public int[] findOrder(int numCourses, int[][] p) {
        int[] ret = new int[numCourses];
        int n = p.length;
        //准备容器
        Map<Integer,List<Integer>> edges = new HashMap<>();
        int[] in = new int[numCourses];
        //使用邻接表来创建图
        for(int i = 0;i < n;i++) {
            int a = p[i][0],b = p[i][1]; //b->a
            if(!edges.containsKey(b)) {
                edges.put(b,new ArrayList<>());
            }
            edges.get(b).add(a);
            in[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < numCourses;i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }
        int vis = 0;
        while(!q.isEmpty()) {
            int tmp = q.poll();
            ret[vis++] = tmp;
            for(int a : edges.getOrDefault(tmp,new ArrayList<>())) {
                in[a]--;
                if(in[a] == 0) {
                    q.add(a);
                }
            }
        }
        if(vis != numCourses) {
            return new int[0];
        }
        return ret;
    }
    /** LCR 114. 火星词典
     * https://leetcode.cn/problems/Jf1JuT/description/
     * 拓扑排序
     * 值得多
     * @author xiaoxie
     * @date 2024/4/12 22:04
     * @param null
     * @return null
     */
    Map<Character, Set<Character>> edges = new HashMap<>();// 使用邻接表建图
    Map<Character, Integer> dist = new HashMap<>();// 记录入度信息
    boolean check; // 检查是否合法

    public String alienOrder(String[] words) {
        // 初始化入度表
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                dist.put(str.charAt(i), 0);
            }
        }
        // 建图
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                add(words[i], words[j]);
                if (check == true)
                    return "";
            }
        }
        // 检查入度为0的字符
        Queue<Character> q = new LinkedList<>();
        for (char ch : dist.keySet()) {
            if (dist.get(ch) == 0) {
                q.add(ch);
            }
        }
        StringBuilder ret = new StringBuilder();
        while (!q.isEmpty()) {
            char tmp = q.poll();
            ret.append(tmp);
            if (!edges.containsKey(tmp))
                continue;
            for (char ch : edges.get(tmp)) {
                dist.put(ch, dist.get(ch) - 1);
                if (dist.get(ch) == 0)
                    q.add(ch);
            }
        }
        // 判断
        for (char ch : dist.keySet()) {
            if (dist.get(ch) != 0)
                return "";
        }
        return ret.toString();
    }

    public void add(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int min = Math.min(m, n);
        int i = 0;
        for (; i < min; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) {
                if (!edges.containsKey(c1)) {
                    edges.put(c1, new HashSet<>());
                }

                if (!edges.get(c1).contains(c2)) {
                    edges.get(c1).add(c2);
                    dist.put(c2, dist.get(c2) + 1);
                }
                break;
            }
        }
        if (i == n && i < m) {
            check = true;
        }
    }
    public static void main(String[] args) {
        int ret = 0;
        int year = 1900,tt = 1,rr = 1;
        int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        while(true) {
            if(year % 400 == 0  || (year % 4 == 0 && year % 100 != 0)) {
                month[2] = 29;
            }else {
                month[2] = 28;
            }
            if (year / 1000 + year / 100 % 10 + year / 10 % 10 + year % 10 == tt % 10 +tt / 10 + rr % 10
                    + rr / 10) { //把年份的每一位拆解，月份和天也拆解，判断是否数位相加之后相等
               ret++;
            }
            rr++;
            if(rr > month[tt]) {
                tt++;
                rr = 1;
                if(tt >12) {
                    year++;
                    tt = 1;
                }
            }

            if(year == 9999 && tt == 12 && rr == 31) {
                break;
            }

        }
        System.out.println(ret);
    }
}

