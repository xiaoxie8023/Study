package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-12
 * Time: 20:11
 */

import java.util.*;

/**
 * 哈希思想
 * 力扣刷题 /leetcode.cn/problems/intersection-of-two-arrays-ii/ 350. 两个数组的交集 II
 * @author xiaoxie
 * @date 2023/12/12 20:16
 * @param /null
 * @return null
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2,nums1);//保持左小右大
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1) {
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        int[] ans = new int[nums1.length];
        int index = 0;
        for(int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if(count > 0) {
                ans[index++] = num;
                count--;
                if(count > 0) {
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }
    /**
     * 排序和双指针
     * 力扣刷题 /leetcode.cn/problems/intersection-of-two-arrays-ii/ 350. 两个数组的交集 II
     * @author xiaoxie
     * @date 2023/12/12 20:16
     * @param /null
     * @return int[]
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] ans = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                ans[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

}

class Solution2 {
    /**
     * 哈希集合的思想，如果循环集合内就有数
     * 力扣刷题 https://leetcode.cn/problems/happy-number/ 202. 快乐数
     * @author xiaoxie
     * @date 2023/12/12 20:16
     * @param /null
     * @return int[]
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1) {
            set.add(n);
            n = getSum(n);
            if(!set.add(n)) {
                return false;
            }
        }
        return true;
    }
    private int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            int tmp = n % 10;
            sum += tmp*tmp;
            n /= 10;
        }
        return sum;
    }
    /**
     * 可以把求和的这些数看成一个链表，如果循环就说明有环，使用快慢指针判断
     * 力扣刷题 https://leetcode.cn/problems/happy-number/ 202. 快乐数
     * @author xiaoxie
     * @date 2023/12/12 20:16
     * @param //快慢指针来解
     * @return int[]
     */
    public boolean isHappy2(int n) {
        int slow = n,fast = getSum(n);
        while(slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return slow == 1;
    }
}

public class Text {
    public static void main(String[] args) {
       Solution2 s = new Solution2();
       s.isHappy2(4);
    }
}
