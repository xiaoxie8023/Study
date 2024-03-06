package CSDN;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-05
 * Time: 20:51
 */

/** * @author xiaoxie
 * @date 2024年03月05日 20:51
 */
public class Text {
    public static void main(String[] args) {
        //int[] array = {4, 2, 6, 1, 3, 5, 15, 7, 16,14};
        int[] array = {30,20,90,60,180,40};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < args.length; i++) {
            avlTree.insertNode(array[i]);
        }
        System.out.println(avlTree.isBalanced(avlTree.root));
    }
    public static void main1(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.insertTreeNode(12);
        bt.insertTreeNode(10);
        bt.insertTreeNode(20);
        bt.insertTreeNode(25);
        bt.insertTreeNode(15);
        //bt.insertTreeNode(15);
        bt.search(12);
        bt.search(20);
        //bt.search(35);
        bt.remove(20);
        bt.search(20);
    }
}
