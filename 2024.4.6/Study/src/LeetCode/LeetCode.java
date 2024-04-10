package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-06
 * Time: 19:59
 */

import java.util.*;

/** 力扣刷题加油
 * * @author xiaoxie
 * @date 2024年04月06日 19:59
 */
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

    public static void main(String[] args) {
        System.out.println();

    }
}
