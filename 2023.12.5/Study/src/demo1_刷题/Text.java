package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-05
 * Time: 16:24
 */

/**
 * 力扣刷题 https://leetcode.cn/problems/remove-element/ 27 移除元素
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int star = 0;
        int end = nums.length-1;
        while(star <= end) {
            if(nums[star] == val) {
                nums[star] = nums[end];
                end--;
            }else {
                star++;
            }
        }
        return star;
    }
}
/** 快慢指针
 * 力扣刷题 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/  26.删除排序数组中的重复项
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution1 {
    public int removeDuplicates(int[] nums) {
        int val = nums[0];
        int slow = 1;
        for(int fast = 1;fast < nums.length;fast++) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                val = nums[slow];
                slow++;
            }
        }
        return slow;
    }
}
/** 快慢指针
 * 力扣刷题 https://leetcode.cn/problems/move-zeroes/  283 移动零
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0;fast < nums.length;++fast) {
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        while(slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
/** 快慢指针
 * 力扣刷题 https://leetcode.cn/problems/backspace-string-compare/ 844. 比较含退格的字符串
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution3 {
    public boolean backspaceCompare(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        return exchange(ss).equals(exchange(tt));
    }
    private String exchange (char[] c) {
        int slow = 0,fast = 0;
        while(fast < c.length) {
            if(c[fast] != '#') {
                c[slow++] = c[fast++];
            }else {
                fast++;
                if(slow > 0) {
                    slow--;
                }
            }
        }
        return new String(c).substring(0,slow);
    }
}
/** 栈的思想 用StingBuilder来模拟
 * 力扣刷题 https://leetcode.cn/problems/backspace-string-compare/ 844. 比较含退格的字符串
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution4 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuilder ret = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }

}
/** 双指针
 * 力扣刷题 https://leetcode.cn/problems/squares-of-a-sorted-array/ 977. 有序数组的平方
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)除了存储答案的数组以外，我们只需要维护常量空间。
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution5 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0,j = n-1,pos = n-1; i <= j;--pos) {
            if(nums[i] * nums[i] >= nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                i++;
            }else {
                ans[pos] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }
}
/** 双指针
 * 力扣刷题 https://leetcode.cn/problems/squares-of-a-sorted-array/ 977. 有序数组的平方
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)除了存储答案的数组以外，我们只需要维护常量空间。
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution6 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int star = 0,end = 0;
        int sum = 0;
        for(;end < nums.length; end++) {
            sum += nums[end];
            while(sum >= target) {
                int subl = end - star+1;
                result = Math.min(subl,result);
                sum -=   nums[star++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
/**
 * 力扣刷题  https://leetcode.cn/problems/spiral-matrix-ii/ 59.螺旋矩阵II
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)除了存储答案的数组以外，我们只需要维护常量空间。
 * * @author xiaoxie
 * @date 2023年12月05日 16:24
 */
class Solution7 {
    public int[][] generateMatrix(int n) {
        int t = 0;//top
        int b = n-1 ;//bottom
        int l = 0;//left
        int r = n-1; //right
        int[][] ans = new int[n][n];
        int nums = 1,max = n * n;
        while(nums <= max) {
            //  从左到右
            for(int i = l;i <= r;i++) {ans[t][i] = nums++;};
            t++;
            //上到下
            for(int i = t;i <= b;i++) {ans[i][r] = nums++;};
            r--;
            //右到左
            for(int i = r;i >= l;i--) {ans[b][i] = nums++;};
            b--;
            //下到上
            for(int i = b;i >= t;i--) {ans[i][l] = nums++;};
            l++;
        }
        return ans;
    }
}
public class Text {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        int[] num = {1,1,1,1,1,1,1,1};
       s.generateMatrix(4);
    }
}
