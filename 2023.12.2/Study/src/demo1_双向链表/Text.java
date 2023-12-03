package demo1_双向链表;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-02
 * Time: 19:43
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/** * @author xiaoxie
 * @date 2023年12月02日 19:43
 */
public class Text {
    public static void main(String[] args) {
       /* MyLinkedList m = new MyLinkedList();
        m.addFirst(1);
        m.addFirst(2);
        m.addFirst(3);
        m.addFirst(4);
        m.display();
        m.addLast(2);
        m.addIndex(5,4);
        m.display();
        m.removeAllKey(4);
        m.display();*/
        /*构造方法*/
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println(list.toString());
        System.out.println("----------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("----------------------");
        for (Integer x :list) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("----------------------");
        Iterator<Integer> it =  list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println("----------------------");
        ListIterator<Integer> it1 = list.listIterator(list.size());
        while (it1.hasPrevious()) {
            System.out.print(it1.previous()+" ");
        }
    }

}
