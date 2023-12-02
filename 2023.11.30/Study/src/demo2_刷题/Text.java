package demo2_刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-30
 * Time: 15:17
 */

import java.util.Arrays;
import java.util.LinkedList;

/** * @author xiaoxie
 * @date 2023年11月30日 15:17
 */
/*
 * 哈希的思想
 * @author xiaoxie
 * @date 2023/11/30 22:23
 * @param https://leetcode.cn/problems/determine-if-two-strings-are-close/ 力扣 1657 确定两个字符串是否接近
 * @return null
 */
class Solution {
    public boolean closeStrings(String s1, String s2) {
        if(s1.length() != s2.length())return false;
        int[] Hs1 = new int[26];
       for (int i = 0; i < s1.length();i++) {
           Hs1[s1.charAt(i)-'a']++;
       }
        int[] Hs2 = new int[26];
        for (int i = 0; i < s1.length();i++) {
            Hs2[s2.charAt(i)-'a']++;
        }
        for(int i = 0;i < 26; i++) {
            if((Hs1[i] == 0) != (Hs2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(Hs1);
        Arrays.sort(Hs2);
        return Arrays.equals(Hs1,Hs2);
    }
}
/*
 * 遍历
 * @author xiaoxie
 * @date 2023/12/1 21:42
 * @param 牛客 CM11 链表分割
 * @return null
 */
class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode de = null;
        ListNode dx = null;
        ListNode pe = null;
        ListNode px = null;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x) {
                if(de == null) {
                    de = cur;
                    dx = cur;
                }else {
                    dx.next = cur;
                    dx = dx.next;
                }
            }else {
                if(pe == null){
                    pe = cur;
                    px = cur;}else {
                    px.next = cur;
                    px = px.next;
                }
            }
            cur = cur.next;
        }
        if(de == null) {
            return pe;
        }
        dx.next = pe;
        if(pe != null) {
            px.next = null;
        }
        return de;
    }
}
/*
 * 快慢指针找中间节点
 * @author xiaoxie
 * @date 2023/12/2 18:45
 * @param 牛客 OR36 链表的回文结构
 * @return null
 */
public class PalindromeList {
    public boolean chkPalindrome(ListNode head) {
        if(head == null ) {
            return true;
        }
        //找中间结点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //翻转链表
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curnext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curnext;
        }
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }if(head.next != slow) {//奇数情况下
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
/*
 * 指针
 * @author xiaoxie
 * @date 2023/12/2 19:09
 * @param https://leetcode.cn/problems/intersection-of-two-linked-lists/ 力扣 160 相交链表
 * @return null
 */
public class Solution6 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = size(headA);
        int lenB = size(headB);
        int len = lenA - lenB;
        if(len <= 0) {
            len = lenB - lenA;
            while(len != 0) {
                len--;
                headB = headB.next;
            }
        }
        while(len != 0) {
            len--;
            headA = headA.next;
        }
        while(headA!= null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private int size(ListNode i) {
        int len = 0;
        while(i != null) {
            len++;
            i = i.next;
        }
        return len;
    }
}
/*
 * 快慢指针
 * @author xiaoxie
 * @date 2023/12/2 19:16
 * @param https://leetcode.cn/problems/linked-list-cycle/description/ 力扣 141 环形链表
 * @return null
 */
public class Solution8 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
/*
 * 快慢指针
 * @author xiaoxie
 * @date 2023/12/2 19:34
 * @param https://leetcode.cn/problems/linked-list-cycle-ii/ 力扣 142 回环链表
 * @return null
 */
public class Solution7 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
public class Text {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "abcbaba";
        String s2 = "bacbbcc";
        System.out.println(s.closeStrings(s1, s2));
    }
}
