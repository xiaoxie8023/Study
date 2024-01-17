package BinaryTree;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-17
 * Time: 14:32
 */

/** * @author xiaoxie
 * @date 2024年01月17日 14:32
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        BinaryTree.TreeNode root = b.createTree();
        System.out.println("前序遍历的结果为： ");
        b.preOrder(root);
        System.out.println();
        System.out.println("中序遍历的结果为： ");
        b.inOrder(root);
        System.out.println();
        System.out.println("后序遍历的结果为： ");
        b.postOrder(root);
        System.out.println();
        System.out.println("节点个数为 ： "+b.size(root));
        System.out.println("叶子节点的个数为： " + b.getLeafNodeCount(root));
        System.out.println("k层节点的个数为： " + b.getKLevelNodeCount(root,3));
        System.out.println("二叉树的高度为： " + b.getHeight(root));
        System.out.println("二叉树是否存在A: "+b.find(root,'l'));
        System.out.println("层次遍历： ");
        b.levelOrder(root);
        System.out.println();

    }
}
