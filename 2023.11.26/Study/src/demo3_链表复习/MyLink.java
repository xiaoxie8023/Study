package demo3_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 20:28
 */

import sun.plugin.javascript.navig.Link;

/**
 * 链表的实现
 * @author xiaoxie
 * @date 2023/11/26 20:34
 * @param //手写链表的实现
 * @return null
 */
public class MyLink implements Ilink{
    static class LinkNode {
        public int date;
        public LinkNode next;
        public LinkNode(int date) {
            this.date = date;
        }
    }
    public LinkNode head;
    @Override
    public void addFirst(int data) {
        LinkNode node = new LinkNode(data);
        node.next = this.head;
        this.head = node;
    }
    @Override
    public void addLast(int data) {
        LinkNode node = new LinkNode(data);
        if(head == null) {
            this.head = node;
        } else {
            LinkNode cur = head;
            while (cur.next!= null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    @Override
    public void addIndex(int index, int data) {
        IsIndex(index);
        LinkNode node = new LinkNode(data);
        LinkNode cur = head;
        if(index == 0) {
            node = cur.next;
            head = node;
        } else {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
             node.next = cur.next;
             cur.next = node;
        }
    }
    private boolean IsIndex (int dex) {
        int count = 0;
        LinkNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        if(dex < 0 || dex >=count) {
            throw new EmptyListException("下标非法:"+dex);
        } else {
            return true;
        }
    }
    @Override
    public boolean contains(int key) {
      LinkNode cur = head;
      while (cur != null) {
          if(cur.date == key) {
              return true;
          }
          cur = cur.next;
      }
      return false;
    }
    @Override
    public void remove(int key) {
        if (head == null) {
            System.out.println("该链表为空！");
        }
        if(head.date == key) {
            head = head.next;
            return;
        }
        LinkNode prv = head;//记录目标值的前一个节点
        LinkNode cur = head.next;
        while (cur != null) {
            if(cur.date == key ) {
                prv.next = cur.next;
                cur.next = null;
                return;
            }
            prv = cur;
            cur = cur.next;
        }
    }
    @Override
    public void removeAllKey(int key) {
        if (head == null) {
            System.out.println("该链表为空");
        }
        LinkNode prv = head;//记录目标值的前一个节点
        LinkNode cur = head.next;
        while (cur != null) {
            if(cur.date == key ) {
                prv.next = cur.next;
                cur.next = null;
                cur = prv.next;
            } else {
                prv = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int size() {
       int count = 0;
       LinkNode cur = head;
       while (cur != null) {
           count++;
           cur = cur.next;
       }
       return count;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void display() {
        if(head == null) {
            System.out.println("当前链表为空！");
        } else{
        LinkNode cur = head;
        while (cur != null) {
            System.out.print(cur.date + " ");
            cur = cur.next;
        }
        System.out.println();
    }
     }

    }

