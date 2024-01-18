package Text;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-18
 * Time: 9:56
 */

/** * @author xiaoxie
 * @date 2024年01月18日 9:56
 * 力扣刷题 https://leetcode.cn/problems/truncate-sentence/ 1816.截断句子
 */
class Solution {
    public String truncateSentence(String s, int k) {
        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == ' ') k--;
            if(k == 0) return s.substring(0,i);
        }
        return s;
    }
}
/** * @author xiaoxie
 * @date 2024年01月18日 9:56
 * 力扣刷题  https://leetcode.cn/problems/remove-duplicates-from-sorted-array/ 26. 删除有序数组中的重复项
 */
class Solution1 {
    public int removeDuplicates(int[] nums) {
        int i = 0,j = 1;
        while(j < nums.length) {
            if(nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }else
                j++;
        }
        return i+1;
    }
}
/** * @author xiaoxie
 * @date 2024年01月18日 9:56
 * 力扣刷题  https://leetcode.cn/problems/merge-two-sorted-lists/ 21. 合并两个有序链表
 */
 class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1,list2.next);
        return list2;
    }
}
/** * @author xiaoxie
 * @date 2024年01月18日 9:56
 * 力扣刷题 https://leetcode.cn/problems/largest-time-for-given-digits/  949. 给定数字能组成的最大时间
 */
//可以看成为A[i]A[j] : A[K]A[L] 使用暴力枚举的方法
class Solution3 {
    public String largestTimeFromDigits(int[] arr) {
        int ans = -1;
        for(int i = 0; i < 4;i++) {
            for(int j = 0;j < 4;j++) {
                if(i == j) {
                    continue;
                }for(int k = 0; k < 4;k++) {
                    if(i == k || k == j) {
                        continue;
                    }
                    int l = 6-(i+k+j);
                    int hours = 10 *arr[i] + arr[j];
                    int m = 10 * arr[k] + arr[l];
                    if(hours>=24 || m >= 60) {
                        continue;
                    }
                    ans = Math.max(ans,hours * 60+m);
                }
            }
        }
        return ans >= 0 ? String.format("%02d:%02d",ans/60,ans%60) : "";
    }
}

public class text {
    public static void main(String[] args) {
    }
}
