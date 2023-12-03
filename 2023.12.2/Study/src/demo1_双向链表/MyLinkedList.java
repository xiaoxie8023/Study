package demo1_双向链表;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-02
 * Time: 19:43
 */

/** * @author xiaoxie
 * @date 2023年12月02日 19:43
 */
public class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode last;
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = last = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head == null) {
            head = last = node;
            return;
        }
        node.prev = last;
        last.next = node;
        last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(head == null) {
            System.out.println("双向链表为空!");
            return;
        }
        isIndex(index);
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == this.size()) {
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }
    private boolean isIndex(int index) {
        if(index < 0 || index > this.size()) {
            throw new IndexException("双向链表的下标非法："+index);
        }
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = head;
        if(head == null) {
            System.out.println("双向链表为空!");
        }
        while (cur != null) {
            if(head.val == key) {
                head.next.prev = null;
                head = head.next;
                return;
            }
            if(last.val == key) {
                last.prev.next = null;
                last = last.prev;
                return;
            }
            if(cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }
        System.out.println("双向链表没有这个数");
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = head;
        if (head == null) {
            System.out.println("双向链表为空!");
        }
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }else {
                        last = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){
        ListNode cur = head;
        if(head == null) {
            System.out.print("双向链表为空！");
        }
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear(){
        head = last = null;
    }
}
