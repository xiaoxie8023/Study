package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-06
 * Time: 19:59
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
