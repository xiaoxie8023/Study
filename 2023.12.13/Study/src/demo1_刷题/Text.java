package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-13
 * Time: 19:30
 */

import java.util.*;

/**
 * 快慢指针的思路，因为有两个数可以相当于把这个数组当成链表的形式，有重复的数就说明有环，所以应该用快慢指针的思想
 * 力扣 https://leetcode.cn/problems/find-the-duplicate-number/ 287. 寻找重复数
 * @author xiaoxie
 * @date 2023/12/13 19:31
 * @param
 * @return null
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    /**
     * 二分查找的思路因为题目中说：长度为 n + 1 的数组，数值在 1 到 n 之间。
     * 因此长度为 len = n + 1，n = len - 1，搜索范围在 1 到 len - 1 之间；
     * 力扣 https://leetcode.cn/problems/find-the-duplicate-number/ 287. 寻找重复数
     * @author xiaoxie
     * @date 2023/12/13 19:31
     * @param
     * @return null
     */
    public int findDuplicate2(int[] nums) {
        int len = nums.length; // n + 1 = len, n = len - 1
        // 在 [1..n] 查找 nums 中重复的元素
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            // nums 中小于等于 mid 的元素的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 下一轮搜索的区间 [left..mid]
                right = mid;
            } else {
                // 下一轮搜索的区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }
}
/**
 * 哈希的思想来做这题
 * 力扣 https://leetcode.cn/problems/4sum-ii/ 454. 四数相加 II
 * @author xiaoxie
 * @date 2023/12/13 19:31
 * @param
 * @return null
 */
class Solution2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                int sum = num1+num2;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int ans = 0;
        for(int num1 : nums3) {
            for(int num2 : nums4) {
                ans += map.getOrDefault(0-num1-num2,0);
            }
        }
        return ans;
    }
}
/**
 * 利用排序和双指针来做这题，注意，遇到重复的数要跳过
 * 力扣 https://leetcode.cn/problems/3sum/ 15.三数之和
 * @author xiaoxie
 * @date 2023/12/13 19:31
 * @param
 * @return null
 */
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;
        Arrays.sort(nums);
        if(nums[0] > 0) return ans;
        int n = nums.length;
        for(int i = 0;i < n-2;i++) {
            int x = nums[i];
            if(i > 0 && x == nums[i-1]) continue;
            if(x + nums[n-1] + nums[n-2] < 0) continue;
            int left = i+1,right = n-1;
            while(left < right) {
                if(x + nums[left] + nums[right] < 0) ++left;
                else if (x + nums[left] + nums[right] > 0) --right;
                else {
                    ans.add(List.of(x,nums[left],nums[right]));
                    for(++left; left <right && nums[left] == nums[left - 1]; ++left);
                    for(--right;right > left && nums[right] == nums[right+1];--right);
                }
            }
        }
        return ans;
    }
}
public class Text {
    public static void main(String[] args) {
        int[] num = new int[]{1,3,4,2,2};
        Solution s = new Solution();
        s.findDuplicate2(num);
    }
}
