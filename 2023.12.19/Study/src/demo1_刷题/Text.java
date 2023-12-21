package demo1_刷题;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-20
 * Time: 12:09
 */

import java.util.LinkedList;
import java.util.Queue;

/** * @author xiaoxie
 * @date 2023年12月20日 12:09
 */
class MYTree {

    public static class TNode {
        public char val;
        TNode left;
        TNode right;
        public TNode (char val) {
            this.val = val;
        }
    }
    public TNode head;
    //前序遍历
    public  void preOder(TNode head) {
        if(head == null) return;
        System.out.print(head.val+" ");
        preOder(head.left);
        preOder(head.right);
    }
    //中序遍历
    public  void inOrder(TNode head) {
        if(head == null) return;
        inOrder(head.left);
        System.out.print(head.val+" ");
        inOrder(head.right);
    }
    //后序遍历
    public void postOrder(TNode head) {
        if(head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val+" ");
    }
    //层次遍历
    public void levelOrder(TNode head) {
        if (head == null) return;
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    //求得叶子节点个数
    public int leveTNode(TNode head) {
        if(head == null) return 0;
        if(head.left == null && head.right == null) return 1;
        return leveTNode(head.left)+leveTNode(head.right);
    }
    //求得二叉树的深度
    public int heightTree(TNode head) {
        if(head == null) return 0;
        int leftHeight = heightTree(head.left);
        int rightHeight = heightTree(head.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    //求得k层的节点个数
    public int Count(TNode head,int k) {
        if(head == null || k == 0) return 0;
        if(k == 1) return 1;
        return Count(head.left,k-1)+Count(head.right,k-1);
    }
}
public class Text {
    public static void main(String[] args) {
        MYTree t = new MYTree();
        MYTree.TNode n = new MYTree.TNode('A');
        MYTree.TNode n1 = new MYTree.TNode('B');
        MYTree.TNode n2 = new MYTree.TNode('C');
        MYTree.TNode n3 = new MYTree.TNode('D');
        MYTree.TNode n4 = new MYTree.TNode('E');
        MYTree.TNode n5 = new MYTree.TNode('F');
        MYTree.TNode n6 = new MYTree.TNode('G');
        n.left = n1;
        n.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        t.preOder(n);
        System.out.println();
        t.inOrder(n);
        System.out.println();
        t.postOrder(n);
        System.out.println();
        System.out.println(t.leveTNode(n));
        System.out.println(t.heightTree(n));
        System.out.println(t.Count(n, 1));
        System.out.println(t.Count(n, 2));
        System.out.println(t.Count(n, 3));
        t.levelOrder(n);
    }
}
