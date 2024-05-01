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
    /** 6. Z 字形变换
     * https://leetcode.cn/problems/zigzag-conversion/description/
     * 模拟,找规律
     * @author xiaoxie
     * @date 2024/4/14 17:43
     * @param s
     * @param numRows
     * @return java.lang.String
     */
    public String convert(String s, int numRows) {
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        if(n == 1 || numRows == 1) return s;
        int d = 2 * numRows - 2;
        //第一行
        char[] ch = s.toCharArray();
        for(int i = 0;i < n;i+= d) {
            ret.append(ch[i]);
        }
        //中间行
        for(int k = 1;k < numRows - 1;k++) {
            for(int i = k,j = d-k;i < n || j < n;i +=d,j += d) {
                if(i < n) ret.append(ch[i]);
                if(j < n) ret.append(ch[j]);
            }
        }
        //最后一行
        for(int i = numRows - 1;i < n;i+= d) {
            ret.append(ch[i]);
        }
        return ret.toString();
    }
    /** 38. 外观数列
     * https://leetcode.cn/problems/count-and-say/description/
     * 模拟
     * @author xiaoxie
     * @date 2024/4/14 18:04
     * @param n
     * @return java.lang.String
     */
    public String countAndSay(int n) {
        String ret = "1";
        for(int i = 1;i < n;i++) {
            StringBuilder tmp = new StringBuilder();
            int len = ret.length();
            for(int left = 0,right = 0;right < len;){
                while(right < len && ret.charAt(left) == ret.charAt(right)) {
                    right++;
                }
                tmp.append(Integer.toString(right-left));
                tmp.append(ret.charAt(left));
                left = right;
            }
            ret = tmp.toString();
        }
        return ret;
    }
    /** 1419. 数青蛙
     * https://leetcode.cn/problems/minimum-number-of-frogs-croaking/description/
     * 模拟加哈希表
     * @author xiaoxie
     * @date 2024/4/14 20:31
     * @param croakOfFrogs
     * @return int
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        char[] ch = croakOfFrogs.toCharArray();
        int len = croakOfFrogs.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('c', 0);
            put('r', 1);
            put('o', 2);
            put('a', 3);
            put('k', 4);
        }};
        int[] hash = new int[5];//c r o a k
        for(int i = 0;i < len;i++) {
            int index = map.get(ch[i]);
            if(ch[i] == 'c') {
                if(hash[4] != 0) hash[4]--;
                hash[0]++;
            }else {
                if(hash[index-1] == 0) {
                    return -1;
                }
                hash[index-1]--;
                hash[index]++;
            }
        }
        for(int i = 0;i < 4;i++) {
            if(hash[i] != 0) {
                return -1;
            }
        }
        return hash[4];
    }
    /** 75. 颜色分类
     * https://leetcode.cn/problems/sort-colors/description/
     * 三指针的思想
     * @author xiaoxie
     * @date 2024/4/15 10:45
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = -1,right = nums.length,i = 0;
        while(i < right) {
            if(nums[i] == 0) {
                swap(nums,++left,i++);
            }else if(nums[i] == 1) {
                i++;
            }else {
                swap(nums,--right,i);
            }
        }
    }
    private void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    /** 215. 数组中的第K个最大元素
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
     * 使用快速选择来解决topk问题
     * @author xiaoxie
     * @date 2024/4/15 16:00
     * @param nums
     * @param k
     * @return int
     */
    public int findKthLargest(int[] nums, int k) {
        return Qsort(nums,0,nums.length-1,k);
    }
    public int Qsort(int[] nums,int left,int right,int k) {
        if(left == right) return nums[left];
        int key = nums[new Random().nextInt(right-left + 1)+left];
        int i = left,l = left-1,r = right + 1;
        while(i < r) {
            if(nums[i] < key){
                swap(nums,++l,i++);
            }else if(nums[i] == key) {
                i++;
            }else {
                swap(nums,--r,i);
            }
        }
        //[left,l],[l + 1,r-1][r,right]
        int b = r-l -1,c = right-r + 1;
        if(c >= k) {
            return Qsort(nums,r,right,k);
        }else if(b + c >= k) {
            return key;
        }else {
            return Qsort(nums,left,l,k-b-c);
        }
    }
    /** 使用大根堆来解决问题
     *
     * @author xiaoxie
     * @date 2024/4/15 16:10
     * @param nums
     * @param k
     * @return int
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> a-b);
        for(int num : nums) {
            if(heap.size() < k) {
                heap.add(num);
            }else {
                if(num > heap.peek()) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.peek();
    }
    /** 面试题 17.14. 最小K个数
     * https://leetcode.cn/problems/smallest-k-lcci/description/
     * 快速选择算法
     * @author xiaoxie
     * @date 2024/4/15 16:41
     * @param arr
     * @param k
     * @return int[]
     */
    public int[] smallestK(int[] arr, int k) {
        qsort(arr,0,arr.length-1,k);
        int[] ret = new int[k];
        for(int i = 0;i < k;i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
    public void qsort(int[] arr,int left,int right,int k) {
        if(left >= right) return;
        int key = arr[new Random().nextInt(right-left+1)+left];
        int i = left,l = left - 1,r = right + 1;
        while(i < r) {
            if(arr[i] < key) {
                swap(arr,++l,i++);
            }else if(arr[i] == key) {
                i++;
            }else {
                swap(arr,--r,i);
            }
        }
        // [left,l] [l+1,r-1] [r,right];
        int a = l-left + 1, b = r-l-1;
        if(a > k) {
            qsort(arr,left,l,k);
        }else if(a + b >= k) {
            return;
        }else {
            qsort(arr,r,right,k-a-b);
        }
    }
    /** 88. 合并两个有序数组
     * https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     * 双指针
     * @author xiaoxie
     * @date 2024/4/21 16:28
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length-1;
        while(n > 0) {
            if(m > 0 && nums1[m-1] >= nums2[n-1]) {
                nums1[i] = nums1[m-1];
                m--;
            }else {
                nums1[i] = nums2[n-1];
                n--;
            }
            i--;
        }
    }
    /** 27. 移除元素
     * https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
     * 双指针
     * @author xiaoxie
     * @date 2024/4/21 16:35
     * @param nums
     * @param val
     * @return int
     */
    public int removeElement(int[] nums, int val) {
        int left = 0,right = nums.length-1;
        while(left <= right) {
            if(nums[left] == val) {
                nums[left] = nums[right--];
            }else {
                left++;
            }
        }
        return left;
    }
    /** 169. 多数元素
     * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
     * 只有一个为多数元素,使用投票法
     * @author xiaoxie
     * @date 2024/4/23 20:52
     * @param nums
     * @return int
     */
    public int majorityElement(int[] nums) {
        int d = nums[0];
        int count = 1;
        for(int i = 1;i < nums.length;i++) {
            if(d == nums[i]) {
                count++;
            }else if(count == 0) {
                d = nums[i];
                count++;
            }else {
                count--;
            }
        }
        return d;
    }
    /** 169. 多数元素
     * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
     * 摩尔投票法
     * @author xiaoxie
     * @date 2024/4/23 20:52
     * @param nums
     * @return int
     */
        public int majorityElement2(int[] nums) {
            // x表示当前的数是众数。
            // votes表示投票数。当前数是众数，则+1；不是，则-1
            int x = 0, votes = 0;
            for (int num : nums) {
                if (votes == 0) {
                    x = num;
                }
                votes += (num == x) ? 1 : -1;
            }
            return x;
        }
        /** LCR 170. 交易逆序对的总数
         * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/
         * 就是归并排序的变种
         * @author xiaoxie
         * @date 2024/4/23 21:59
         * @param null
         * @return null
         */
    int[] tmp;
    public int reversePairs(int[] record) {
        int n = record.length;
        tmp = new int[n];
        return marge(record,0,n-1);
    }
    private int marge(int[] record,int left,int right) {
        if(left >= right) return 0;
        int mid = (left + right) / 2;
        int ret = 0;
        ret += marge(record,left,mid);
        ret += marge(record,mid + 1,right);
        //[left, mid] [mid + 1,right]
        int cur1 = left,cur2 = mid + 1,i = 0;
        while(cur1 <= mid && cur2 <= right){
            if(record[cur1] <= record[cur2]) {
                tmp[i++] = record[cur1++];
            }else {
                tmp[i++] = record[cur2++];
                ret += mid - cur1 + 1;
            }
        }
        while(cur1 <= mid) tmp[i++] = record[cur1++];
        while(cur2 <= right) tmp[i++] = record[cur2++];
        for(int j = left;j <= right;j++){
            record[j] = tmp[j-left];
        }
        return ret;
    }
    /** 189. 轮转数组
     * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
     * 使用翻转即可  例:
     *     原.   1 2 3 4 5 6 7
     *     1.    7 6 5 4 3 2 1    因为有k个需要翻转
     *     2.    5 6 7 4 3 2 1
     *     3.    5 6 7 1 2 3 4
     *     k 如果大于 nums.length,就从来一圈就好
     *     k %= nums.length
     * @author xiaoxie
     * @date 2024/4/24 22:18
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int left,int right) {
        if(left == right) return;
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
    /** 228. 汇总区间
     * https://leetcode.cn/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
     * 使用同向双指针,把每个区域分成一段一段的
     * @author xiaoxie
     * @date 2024/4/24 22:35
     * @param nums
     * @return java.util.List<java.lang.String>
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int n = nums.length;
        int left = 0;
        while(left < n) {
            int star = left;
            left++;
            while(left < n && nums[left] == nums[left-1] + 1) {
                left++;
            }
            int end = left -1;
            StringBuilder tmp = new StringBuilder(Integer.toString(nums[star]));
            if(star != end) {
                tmp.append("->");
                tmp.append(Integer.toString(nums[end]));
            }
            ret.add(tmp.toString());
        }
        return ret;
    }
    /** 122. 买卖股票的最佳时机 II
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
     * 贪心
     * @author xiaoxie
     * @date 2024/4/26 19:51
     * @param prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ret = 0;
        for(int i = 1;i < n;i++) {
            if(prices[i] - prices[i-1] > 0) {
                ret += prices[i] - prices[i-1];
            }
        }
        return ret;
    }
    /** 114. 二叉树展开为链表
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150
     * 画图
     * @author xiaoxie
     * @date 2024/4/26 20:10
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
    /** 55. 跳跃游戏
     * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
     * 贪心
     * @author xiaoxie
     * @date 2024/4/27 12:37
     * @param nums
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int end = 0;
        for(int i = 0;i < n;i++) {
            if(i <= end) {
                end = Math.max(end,i+nums[i]);
            }
            if(end >= n-1) {
                return true;
            }
        }
        return false;
    }
    /**151. 反转字符串中的单词
     * https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
     * 字符串
     * @author xiaoxie
     * @date 2024/4/27 13:22
     * @param s
     * @return java.lang.String
     */
    public String reverseWords(String s) {
        char[] sArr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        // 倒着遍历
        for(int i=sArr.length-1;i>=0;i--){
            // 找到单词的结束位置
            while(i>=0 && sArr[i]==' '){
                --i;
            }
            int end = i;
            // 找到单词的起点
            while(i>=0 && sArr[i]!=' '){
                --i;
            }
            ans.append(" ").append(s.substring(i+1,end+1));
        }
        return ans.toString().trim();
    }
    /** 315. 计算右侧小于当前元素的个数
     * https://leetcode.cn/problems/count-of-smaller-numbers-after-self/description/
     * 归并排序(分治)
     * @author xiaoxie
     * @date 2024/4/27 22:29
     * @param null
     * @return null
     */
    //int[] tmp;之前有调用过
    int[]cur;
    int[]index;
    int[]ret;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        cur = new int[n];
        index = new int[n];
        ret = new int[n];
        for(int i = 1;i < n;i++) {
            index[i] = i;
        }
        marge1(nums,0,n-1);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : ret) {
            list.add(num);
        }
        return list;
    }
    public void marge1(int[] nums,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        marge1(nums,left,mid);
        marge1(nums,mid + 1,right);
        int cur1 = left,cur2 = mid + 1;
        int i = 0;
        while(cur1 <= mid && cur2 <= right) {
            if(nums[cur2] >= nums[cur1]) {
                tmp[i] = nums[cur2];
                cur[i++] = index[cur2++];
            }else {
                ret[index[cur1]] += right - cur2 + 1;
                tmp[i] = nums[cur1];
                cur[i++] = index[cur1++];
            }
        }
        while(cur1 <= mid) {
            tmp[i] = nums[cur1];
            cur[i++] = index[cur1++];
        }
        while(cur2 <= right) {
            tmp[i] = nums[cur2];
            cur[i++] = index[cur2++];
        }
        for(int j = left;j <= right;j++) {
            nums[j] = tmp[j-left];
            index[j] = cur[j-left];
        }
    }
    /** 493. 翻转对
     * https://leetcode.cn/problems/reverse-pairs/description/
     * 归并排序(分治)
     * @author xiaoxie
     * @date 2024/4/27 23:02
     * @param null
     * @return null
     */
    int[] tmpNum;
    public int reversePairs1(int[] nums) {
        int n = nums.length;
        tmpNum = new int[n];
        return marge2(nums,0,n-1);

    }
    public int marge2(int[] nums,int left,int right) {
        if(left >= right) return 0;
        int ret = 0;
        int mid = (left + right) / 2 ;
        ret +=marge2(nums,left,mid);
        ret +=marge2(nums,mid+1,right);
        int cur1 = left,cur2 = mid + 1,i = left;
        //先找到
        while(cur1 <= mid) {
            while(cur2 <= right && (long)nums[cur2] * 2 >= nums[cur1]) {
                cur2++;
            }
            if(cur2 > right) {
                break;
            }
            ret += (right - cur2 + 1);
            cur1++;
        }
        cur1 = left;cur2 = mid + 1;
        while(cur1 <= mid && cur2 <= right) {
            if(nums[cur1] <= nums[cur2]) {
                tmpNum[i++] = nums[cur2++];
            }else {
                tmpNum[i++] = nums[cur1++];
            }
        }
        while(cur1 <= mid) {
            tmpNum[i++] = nums[cur1++];
        }
        while(cur2 <=right) {
            tmpNum[i++] = nums[cur2++];
        }
        for(int j = left;j <= right;j++) {
            nums[j] = tmpNum[j];
        }
        return ret;
    }
    /** 45. 跳跃游戏 II
     * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
     * 贪心
     * @author xiaoxie
     * @date 2024/4/28 20:41
     * @param nums
     * @return int
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int max = 0,end =0,ret = 0;
        for(int i = 0;i < n-1;i++) {
            max = Math.max(max,nums[i] + i);
            if(i == end) {
                end = max;
                ret++;
            }
        }
        return ret;
    }
    /** 108. 将有序数组转换为二叉搜索树
     * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
     * 分治
     * @author xiaoxie
     * @date 2024/4/28 20:49
     * @param nums
     * @return LeetCode.TreeNode
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return margeTree(nums,0,nums.length-1);
    }
    public TreeNode margeTree(int[] nums,int left,int right) {
        if(left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = margeTree(nums,left,mid-1);
        cur.right = margeTree(nums,mid + 1,right);
        return cur;
    }
    /** 274. H 指数
     *https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
     * 使用二分查找
     * 1.找到这个数据的中间值
     * 2.遍历数组查看有多少篇数据被引用的值,有多少篇大于这个中间值
     * 3.如果大于就说明 H 的值,在 [mid,right]之中
     * 4.如果小于,就说明 H 的值,在[left,mid]之间
     * @author xiaoxie
     * @date 2024/4/30 17:21
     * @param cit
     * @return int
     */
    public int hIndex(int[] cit) {
        int n = cit.length;
        int left = 0,right = n,count = 0;
        while(left < right) {
            int mid = (left + right + 1) >> 1;
            count = 0;
            for(int i = 0;i < n;i++) {
                if(cit[i] >= mid) {
                    count++;
                }
            }
            if(count >= mid) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
    /** 9. 回文数
     * https://leetcode.cn/problems/palindrome-number/description/?envType=study-plan-v2&envId=top-interview-150
     * 这一题可以使用转成字符串的方法,但是这样就引入了额外的空间,所以可以使用反转数字一半来判断
     * 1.  143341        13231       x
     * 2.   1              1        14334     1323
     * 3.   14             13       1433      132
     * 4.   143            132      143       13
     * 5.   x == r || x == r / 10
     * @date 2024/4/30 17:37
     * @param x
     * @return boolean
     */
    public boolean isPalindrome(int x) {
        if(x < 0 ||(x > 0 && x % 10 == 0)) {
            return false;
        }
        //
        int reverseNum = 0;
        while(x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        //可能数字为奇数的情况
        return x == reverseNum || x == reverseNum / 10;

    }
    /** 112. 路径总和
     * https://leetcode.cn/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150
     * dfs
     * @author xiaoxie
     * @date 2024/4/30 18:00
     * @param root
     * @param targetSum
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left,targetSum - root.val) ||hasPathSum(root.right,targetSum-root.val) ;
    }
    /** 380. O(1) 时间插入、删除和获取随机元素
     * https://leetcode.cn/problems/insert-delete-getrandom-o1/description/
     * 时间复杂度为O(1)-> 哈希表
     *
     *  总体思路：用链表最后一个元素覆盖要删除的元素，然后把链表最后一个元素删掉，更新哈希表中的数据
     *   在哈希表中查找该数据在链表中的下标
     *   获取链表中最后一个元素
     *   把最后一个元素移到需要删除的元素处，替换掉
     *   把替换后的元素和它的新下标一起存入哈希表
     *   删掉链表最后一个元素
     *   删掉哈希表中要删除的元素
     * @author xiaoxie
     * @date 2024/5/1 21:29
     * @param null
     * @return null
     */
    class RandomizedSet {
        Map<Integer,Integer> hash;
        List<Integer> nums;
        Random random;
        public RandomizedSet() {
            hash = new HashMap<>();
            nums = new LinkedList<>();
            random = new Random();
        }
        public boolean insert(int val) {
            if(hash.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            hash.put(val,index);
            return true;
        }

        public boolean remove(int val) {
            if(!hash.containsKey(val)) {
                return false;
            }
            int index = hash.get(val);
            int end = nums.get(nums.size()-1);
            nums.set(index, end);
            hash.put(end, index);
            nums.remove(nums.size() - 1);
            hash.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }
}


