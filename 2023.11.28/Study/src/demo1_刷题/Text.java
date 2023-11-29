package demo1_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-27
 * Time: 23:04
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** * @author xiaoxie
 * @date 2023年11月27日 23:04
 */
class Solution2 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int star = 0;
        int end = 0;
        for (int i = 0; i < l.length || i < r.length; i++) {
            star = l[i];
            end = r[i];
            list.add(ans(nums, star, end));
        }
        return list;
    }

    private Boolean ans(int[] nums, int star, int end) {
        Arrays.sort(nums);
        while (star <= end) {
            if(nums[star+1] - nums[star] != nums[1] - nums[0]) {
                return false;
            }
            star++;
        }
        if(end == 0 || end == 1) {
            return false;
        }return true;
    }
}
 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode prv = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val == val) {
                    prv.next = cur.next;
                    cur = cur.next;
                } else {
                    prv = cur;
                    cur = cur.next;
                }
            }
            if (head.val == val) {
                head = head.next;
            }
            return head;
        }
    }
}
/*
 * 双指针
 * @author xiaoxie
 * @date 2023/11/29 19:27
 * @param https://leetcode.cn/problems/reverse-linked-list/submissions/ 力扣 206 反转链表
 * @return null
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode prv = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prv;
            prv = cur;
            cur = temp;
        }
        return prv;
        }
    }
    /*
     *  快慢指针
     * @author xiaoxie
     * @date 2023/11/29 19:29
     * @param https://leetcode.cn/problems/middle-of-the-linked-list/  力扣 876链表的中间节点
     * @return null
     */
    class Solution3 {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    /*
     * 快慢指针
     * @author xiaoxie
     * @date 2023/11/29 19:36
     * @param 牛客网 链表中倒数第k个结点
     * @return null
     */
 class Solution4{
    public ListNode FindKthToTail(ListNode head,int k) {
        int count = 0;
        ListNode fast = head;
        ListNode slow = head;
        if(head == null) {
            return null;
        }
        while (count != k-1) {
            fast = fast.next;
            count++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
/*
 * 虚拟头结点
 * @author xiaoxie
 * @date 2023/11/29 19:51
 * @param https://leetcode.cn/problems/merge-two-sorted-lists/ 力扣 21 合并两个有序的链表
 * @return null
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newhead = new ListNode(-1);
        ListNode temp = newhead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                temp.next = cur1;
                cur1 = cur1.next;
                temp = temp.next;
            } else {
                temp.next = cur2;
                cur2 = cur2.next;
                temp = temp.next;
            }
        } if(cur1 == null) {
            temp.next = cur2;
        } if(cur2 == null) {
            temp.next = cur1;
        }
        return newhead.next;
    }
}
/*
 * 多个双指针改变链表结构
 * @author xiaoxie
 * @date 2023/11/29 20:54
 * @param https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/ 力扣 1721交换链表中的节点
 * @return null
 */
class Solution5 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        ListNode pvr1 = newhead;
        ListNode left = newhead.next;//第k个节点
        ListNode pvr2 = newhead;
        ListNode right = newhead.next;//倒数k个节点
        for (int i = 1; i < k;i++) {
            pvr1 = left;
            left = left.next;
        }
        ListNode cur = left;
        while (cur != null) {
            pvr2 = right;
            right = right.next;
            cur = cur.next;
        }
        if(right == pvr1) {//如果倒数第k个为第k个的前驱
           right.next = left.next;
           left.next = right;
           pvr2.next = left;
        }else {
            if(left == pvr2) {
                left.next = right.next;
                right.next = left;
                pvr1.next = right;
            }
            ListNode temp = right.next;
            right.next = left.next;
            pvr2.next = left;
            left.next = temp;
            pvr1.next = right;
        }
        return newhead.next;
    }
}


public class Text {
    public static void main(String[] args) {
      /*  Solution2 s = new Solution2();
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};*

    }  */
        int count = 0;
        for (int i = 0; i < 2; i++) {
            count +=1;
        }
        System.out.println(count);
    }
}