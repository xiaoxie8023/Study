package demo1;/**
 * Created with IntelliJ IDEA.
 * Description: 做链表题，需要很关键的一点是知道自己是谁，知道上一个是谁，知道下一个是谁
 * User: 谢忠涵7
 * Date: 2024-01-30
 * Time: 19:09
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年01月30日 19:09
 */
public class Text {
     static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public class Solution {
        /**
         * 使用虚拟头结点来解这题
         * 力扣刷题 https://leetcode.cn/problems/remove-linked-list-elements/
         * 203.移除链表元素
         *
         * @return null
         * @author xiaoxie
         * @date 2024/1/30 19:09
         */
        public ListNode removeElements(ListNode head, int val) {
            ListNode cur = new ListNode(-1);
            cur.next = head;
            ListNode pre = cur;
            while (pre.next != null) {
                if (pre.next.val == val) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
            return cur.next;
        }

        /**
         * 使用递归来解这题
         * 力扣刷题 https://leetcode.cn/problems/remove-linked-list-elements/
         * 203.移除链表元素
         *
         * @return null
         * @author xiaoxie
         * @date 2024/1/30 19:09
         */
        public ListNode removeElements2(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements2(head.next, val);
            if (head.val == val) {
                return head.next;
            } else {
                return head;
            }
        }

        /**
         * 迭代
         * 在遍历链表时，将当前节点的 next指针改为指向前一个节点。
         * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
         * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
         * 力扣刷题 https://leetcode.cn/problems/reverse-linked-list/
         * 206.反转链表
         *
         * @return null
         * @author xiaoxie
         * @date 2024/1/30 21:27
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        /**
         * 使用递归的思想好好研究
         * 以链表1->2->3->4->5举例
         * 力扣刷题 https://leetcode.cn/problems/reverse-linked-list/
         * 206.反转链表
         *
         * @param head
         * @return
         */
        public static ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                /**
                 直到当前节点的下一个节点为空时返回当前节点
                 由于5没有下一个节点了，所以此处返回节点5
                 */
                return head;
            }
            //递归传入下一个节点，目的是为了到达最后一个节点
            ListNode newHead = reverseList1(head.next);
            /**
             第一轮出栈，head为5，head.next为空，返回5
             第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
             把当前节点的子节点的子节点指向当前节点
             此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
             此时链表为1->2->3->4<-5
             返回节点5
             第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
             此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
             此时链表为1->2->3<-4<-5
             返回节点5
             第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
             此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
             此时链表为1->2<-3<-4<-5
             返回节点5
             第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
             此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
             此时链表为1<-2<-3<-4<-5
             返回节点5
             出栈完成，最终头节点5->4->3->2->1
             */
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        /**
         * 使用快慢指针获取中间节点
         * 力扣 https://leetcode.cn/problems/middle-of-the-linked-list/
         * 876.链表的中间结点
         *
         * @return null
         * @author xiaoxie
         * @date 2024/1/31 9:49
         */
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public boolean isSubsequence(String S, String T) {
           Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < T.length(); i++) {
                map.put(T.charAt(i),1);
            }
            int i = 0,j = 0;
            while (i < S.length() && j < T.length()) {
                if(map.containsKey(S.charAt(i))) {
                    if(map.get(S.charAt(i)) > j) {
                        j = map.get(S.charAt(i));
                    }else {
                        i++;
                    }
                }else {
                    j++;
                }
            }
            return i == S.length();
    }

    public static void text(String s){
        StringBuilder sb = new StringBuilder(s);
        boolean tmp = true;
        while (tmp) {
            tmp = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    tmp = true;
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
     }

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         while (in.hasNext()) {
             String s = in.nextLine();
             StringBuilder sb = new StringBuilder(s);
             boolean tmp = true;
             while (tmp) {
                 tmp = false;
                 for (int i = 0; i < sb.length() - 1; i++) {
                     if (sb.charAt(i) == sb.charAt(i + 1)) {
                         sb.delete(i, i + 2);
                         tmp = true;
                         break;
                     }
                 }
             }
             if(sb.length() == 0) {
                 System.out.println(0);
                 continue;
             }
             System.out.println(sb.toString());
         }
    }

    }
