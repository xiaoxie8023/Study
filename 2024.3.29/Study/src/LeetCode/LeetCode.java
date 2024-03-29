package LeetCode;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-29
 * Time: 11:24
 */

import java.util.List;

/**  递归,dfs,回溯,剪枝问题专题
 * * @author xiaoxie
 * @date 2024年03月29日 11:24
 */
 class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class LeetCode {
    /** 面试题 08.06. 汉诺塔问题
     * https://leetcode.cn/problems/hanota-lcci/description/
     * @author xiaoxie
     * @date 2024/3/29 16:16
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A,B,C,A.size());
    }
    public void dfs(List<Integer> A, List<Integer> B, List<Integer> C,int n) {
        if(n == 1) {
            C.add(A.remove(A.size()-1));
            return;
        }
        dfs(A,C,B,n-1);
        C.add(A.remove(A.size()-1));
        dfs(B,A,C,n-1);
    }
    /** 21. 合并两个有序链表
     *  https://leetcode.cn/problems/merge-two-sorted-lists/description/
     *  使用递归
     * @author xiaoxie
     * @date 2024/3/29 19:50
     * @param list1
     * @param list2
     * @return LeetCode.ListNode
     */
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
    /** LCR 024. 反转链表
     * https://leetcode.cn/problems/UHnkqh/description/
     * 递归
     * @author xiaoxie
     * @date 2024/3/29 20:32
     * @param head
     * @return LeetCode.ListNode
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        //找到最后一个节点
        ListNode newhead =  reverseList(head.next);
        //修改指针变量;
        head.next.next =  head;
        head.next = null;
        return newhead;
    }
    /**24. 两两交换链表中的节点
     * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
     * 递归
     * @author xiaoxie 
     * @date 2024/3/29 20:51
     * @param head 
     * @return LeetCode.ListNode 
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmp = swapPairs(head.next.next);
        ListNode newhead = head.next;
        newhead .next = head;
        head.next = tmp;
        return newhead;
    }
}
