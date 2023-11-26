package demo3_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 19:55
 */

/** * @author xiaoxie
 * @date 2023年11月26日 19:55
 */
public class Text {
    public static void main(String[] args) {
        MyLink m = new MyLink();
        m.addFirst(1);
        m.addFirst(2);
        m.addFirst(3);
        m.addFirst(4);
        m.addFirst(5);
        System.out.println("头插法验证");
        m.display();
        System.out.println("尾插法验证");
        m.addLast(100);
        m.addLast(10);
        m.addLast(1);
        m.addLast(101);
        m.addLast(102);
        m.display();
        System.out.println("任意位置插入验证");
        m.addIndex(2,99);
        m.display();
        System.out.println("查找是否包含关键字key是否在单链表当中验证");
        System.out.println(m.contains(100));
        System.out.println(m.contains(50));
        System.out.println("删除第一次出现关键字为key的节点");
        m.remove(2);
        m.display();
        System.out.println("删除所有值为key的节点前");
        m.display();
        System.out.println("删除所有值为key的节点后");
        m.removeAllKey(1);
        m.display();
        System.out.println("得到单链表的长度");
        System.out.println(m.size());
        m.clear();
        m.display();
    }
}
