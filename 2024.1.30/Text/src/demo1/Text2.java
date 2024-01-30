package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-30
 * Time: 21:34
 */

/** * @author xiaoxie
 * @date 2024年01月30日 21:34
 */
public class Text2 {
    public static void main(String[] args) {
        Text.ListNode l1 = new Text.ListNode(1);
        Text.ListNode l2 = new Text.ListNode(2);
        Text.ListNode l3 = new Text.ListNode(3);
        Text.ListNode l4 = new Text.ListNode(4);
        Text.ListNode l5 = new Text.ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Text.ListNode s  = Text.Solution.reverseList1(l1);

    }
}
