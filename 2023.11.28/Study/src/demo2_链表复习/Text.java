package demo2_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-29
 * Time: 16:48
 */

/** * @author xiaoxie
 * @date 2023年11月29日 16:48
 */
public class Text {
    public static void main(String[] args) {
        MylistNode m = new MylistNode();
        m.addFirst(1);
        m.addFirst(1);
        m.addFirst(1);
        m.display();
        m.addLast(15);
        m.display();
        m.addIndex(2,99);
        m.display();
        //m.addIndex(888,98);
        m.remove(1);
        m.display();
        System.out.println(m.contains(58));
        System.out.println(m.contains(99));
        m.removeAllKey(1);
        m.display();
        System.out.println(m.size());
        m.clear();
        m.display();
    }
}
