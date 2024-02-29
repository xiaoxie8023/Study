package demo2;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-02-27
 * Time: 20:31
 */

/** 刷题
 * * @author xiaoxie
 * @date 2024年02月27日 20:31
 */
public class Text1 {
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
    }

    class Solution {
        /** 力扣 148. 排序链表 还有一个自底向上的实现方式
         *  O(1) 的空间复杂度 需要好好学一下它的思想
         *  https://leetcode.cn/problems/sort-list/
         *  对链表自顶向下归并排序的过程如下
         * 1.找到链表的中点，以中点为分界，将链表拆分成两个子链表。
         * 寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，
         * 当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
         * 2.对两个子链表分别排序。
         * 将两个排序后的子链表合并，得到完整的排序后的链表。
         * 上述过程可以通过递归实现。递归的终止条件是链表的节点个数小于或等于 1，
         * 即当链表为空或者链表只包含 1个节点时，不需要对链表进行拆分和排序。
         *  时间复杂度：O(NlogN，其中N是链表的长度。
         * 空间复杂度：O(logN)，其中 N 是链表的长度。空间复杂度主要取决于递归调用的栈空间。
         *
         * @author xiaoxie
         * @date 2024/2/29 12:44
         * @param head
         * @return demo2.Text1.ListNode
         */
        public ListNode sortList(ListNode head) {
            return sortList(head,null);
        }
        public ListNode sortList(ListNode head,ListNode end) {
            if(head == null) {
                return null;
            }
            if(head.next == end) {
                head.next = null;
                return head;
            }
            ListNode slow = head,fast = head;
            while(fast != end && fast.next != end) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow;
            ListNode l1 = sortList(head,mid);
            ListNode l2 = sortList(mid,end);
            ListNode sort = marge(l1,l2);
            return sort;
        }
        private ListNode marge(ListNode l1,ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if(l1 != null) {
                cur.next = l1;
            }else if(l2 != null) {
                cur.next = l2;
            }
            return dummy.next;
        }
    }
    /** 力扣 148. 排序链表 自底向上的实现方式
     * 这个方法需要好好学习到它的思想
     *  具体做法如下。
     * 1.用 subLength表示每次需要排序的子链表的长度，初始时 subLength=1
     * 2.每次将链表拆分成若干个长度为 subLength的子链表（最后一个子链表的长度可以小于 subLength），
     * 按照每两个子链表一组进行合并，合并后即可得到若干个长度为 subLength×2 的有序子链表（最后一个子链表的长度可以小于subLength×2）。
     * 合并两个子链表
     * 3.将 subLength的值加倍，重复第 2 步，对更长的有序子链表进行合并操作，
     * 直到有序子链表的长度大于或等于 length，整个链表排序完毕。
     * 如何保证每次合并之后得到的子链表都是有序的呢？可以通过数学归纳法证明。
     * 1.初始时 subLength=1,每个长度为 1 的子链表都是有序的。
     * 2.如果每个长度为 subLength 的子链表已经有序，合并两个长度为 subLength的有序子链表
     * 得到长度为 subLength×2的子链表，一定也是有序的。
     * 3.当最后一个子链表的长度小于 subLength 时，该子链表也是有序的，合并两个有序子链表之后得到的子链表一定也是有序的。
     * 因此可以保证最后得到的链表是有序的。
     *  时间复杂度：O(NlogN，其中N是链表的长度。
     *  空间复杂度：O(1)
     * @author xiaoxie
     * @date 2024/2/29 12:51
     * @param head
     * @return demo2.Text1.ListNode
     */
    // 自底向上归并排序
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        // 1. 首先从头向后遍历,统计链表长度
        int length = 0; // 用于统计链表长度
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        // 2. 初始化 引入dummyHead
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
        for(int subLen = 1;subLen < length;subLen <<= 1){ // subLen每次左移一位（即sublen = sublen*2）
            // PS:位运算对CPU来说效率更高
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;     // curr用于记录拆分链表的位置

            while(curr != null){               // 如果链表没有被拆完
                // 3.1 拆分subLen长度的链表1
                ListNode head_1 = curr;        // 第一个链表的头 即 curr初始的位置
                for(int i = 1; i < subLen && curr != null && curr.next != null; i++){     // 拆分出长度为subLen的链表1
                    curr = curr.next;
                }

                // 3.2 拆分subLen长度的链表2
                ListNode head_2 = curr.next;  // 第二个链表的头  即 链表1尾部的下一个位置
                curr.next = null;             // 断开第一个链表和第二个链表的链接
                curr = head_2;                // 第二个链表头 重新赋值给curr
                for(int i = 1;i < subLen && curr != null && curr.next != null;i++){      // 再拆分出长度为subLen的链表2
                    curr = curr.next;
                }

                // 3.3 再次断开 第二个链表最后的next的链接
                ListNode next = null;
                if(curr != null){
                    next = curr.next;   // next用于记录 拆分完两个链表的结束位置
                    curr.next = null;   // 断开连接
                }

                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = mergeTwoLists(head_1,head_2);
                prev.next = merged;        // prev.next 指向排好序链表的头
                while(prev.next != null){  // while循环 将prev移动到 subLen*2 的位置后去
                    prev = prev.next;
                }
                curr = next;              // next用于记录 拆分完两个链表的结束位置
            }
        }
        // 返回新排好序的链表
        return dummyHead.next;
    }
    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr  = dummy;
        while(l1 != null && l2!= null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{

                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null) curr.next = l2;
        if(l2 == null) curr.next = l1;
        return dummy.next;
    }

}
