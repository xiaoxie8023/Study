package demo2_二叉树的构建;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-10
 * Time: 19:17
 */

/**
 * 构建一颗二叉树
 * @author xiaoxie
 * @date 2023/12/10 19:18
 * @param
 * @return null
 */
 class BinaryTree {

    static class TreeNode {
        public char val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用

        public TreeNode(char val) {
            this.val = val;
        }
    }


    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode node1 = new TreeNode('A');
        TreeNode node2 = new TreeNode('B');
        TreeNode node3 = new TreeNode('C');
        TreeNode node4 = new TreeNode('D');
        TreeNode node5 = new TreeNode('E');
        TreeNode node6 = new TreeNode('F');
        TreeNode node7 = new TreeNode('G');

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return  node1;

    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    public void size(TreeNode root) {
        if(root == null) {
            return;
        }
        nodeSize++;
       size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    public int size2(TreeNode root) {
        if(root == null) return 0;
        return size2(root.left)+size2(root.right)+1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    public void getLeafNodeCount1(TreeNode root) {
        if (root == null) return;
        if(root.left == null && root.right == null) leafSize++;
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    /*
     获取叶子节点的个数：子问题
     */
    public int getLeafNodeCount2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return getLeafNodeCount2(root.left)+getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    public int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null) return 0;
        if(k-1 == 0) return 1;
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right)+1;
    }


    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode left = find(root.left,val);
        if(left != null) return left;
        TreeNode right = find(root.right,val);
        if(right != null) return right;
        return null;
    }

}
public class Text {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        BinaryTree.TreeNode tmp = b.createTree();
        b.preOrder(tmp);
        System.out.println();
        b.inOrder(tmp);
        System.out.println();
        b.postOrder(tmp);
        System.out.println();
        System.out.println(b.size2(tmp));
        b.size(tmp);
        System.out.println(BinaryTree.nodeSize);
        System.out.println(b.getKLevelNodeCount(tmp,3));
        b.getLeafNodeCount1(tmp);
        System.out.println(BinaryTree.leafSize);
        System.out.println(b.getLeafNodeCount2(tmp));
        BinaryTree.TreeNode temp = b.find(tmp,'r');
        System.out.println(temp.val);
    }
}