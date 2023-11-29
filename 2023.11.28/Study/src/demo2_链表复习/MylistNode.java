package demo2_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-29
 * Time: 11:23
 */

/** * @author xiaoxie
 * @date 2023年11月29日 11:23
 */
public class MylistNode implements IListNode {
    static class listNode {
        public int val;
        public listNode next;
        public listNode(int val) {
            this.val = val;
        }
    }
    public  listNode head;
    @Override
    public void addFirst(int data) {
        listNode node = new listNode(data);
        node.next = head;
        head = node;
    }

    @Override
    public void addLast(int data) {
        listNode node = new listNode(data);
        if (head == null) {
            head = node;
        }
        listNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    @Override
    public void addIndex(int index, int data) {
        indexOfAdd(index);
        listNode node = new listNode(data);
        if(head == null) {
            head = node;
        }if (index == 0) {
            addFirst(data);
        }if (index == size()) {
            addLast(data);
        }
        listNode cur = head;
        for (int i = 0;i < index-1;i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }
    private boolean indexOfAdd(int index) {
        if(index < 0 || index > size()) {
            throw new IndexException("位置非法："+index);
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
      listNode cur = head;
      while (cur != null) {
          if(cur.val == key) {
              return true;
          }else {
              cur = cur.next;
          }
      }
      return false;
    }

    @Override
    public void remove(int key) {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        if(head.val == key) {
            head = head.next;
            return;
        }
        listNode prv = head;
        listNode cur = head.next;
        while (cur != null) {
            if(cur.val == key) {
                prv.next = cur.next;
               return;
            }
            prv = cur;
            cur = cur.next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        listNode prv = head;
        listNode cur = head.next;
        while (cur != null) {
            if(cur.val == key) {
                prv.next = cur.next;
                cur = cur.next;
            }else {
                prv = cur;
                cur = cur.next;
            }
        }
        if(head.val == key) {
            head = head.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        listNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
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
            System.out.println("链表为空！");
            return;
        }
        listNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
