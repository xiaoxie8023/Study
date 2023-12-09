package demo2_二叉树复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-08
 * Time: 22:49
 */

/** * @author xiaoxie
 * @date 2023年12月08日 22:49
 */
class BinaryTree {
    static class BNode {
        public char val;
        public BNode left;
        public BNode right;

        public BNode(char val) {
            this.val = val;
        }
    }
    private BNode root;
    public BNode CreateTree() {
        BNode node1 = new BNode('A');
        BNode node2 = new BNode('B');
        BNode node3 = new BNode('C');
        BNode node4 = new BNode('D');
        BNode node5 = new BNode('E');
        BNode node6 = new BNode('F');
        BNode node7 = new BNode('G');

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }
    //先序遍历
    public void preOrder(BNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public void  inOrder(BNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    // 后序遍历
    public void  postOrder(BNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    // 获取树中节点的个数(遍历的方法)
    public static int treeSize;
    public void size(BNode root) {
        if(root == null) {
            return;
        }
        treeSize++;
        size(root.left);
        size(root.right);
    }
    // 获取树中节点的个数(分开的方法)
    public int size2(BNode root) {
        if(root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right)+1;
    }
    //获取树中叶子节点的个数
    public int getLeafNodeCount(BNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left)+getLeafNodeCount(root.right);
    }
    //获取第K层节点的个数
    int getKLevelNodeCount(BNode root,int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) return 1;
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }
    // 获取二叉树的高度
    int getHeight(BNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    // 检测值为value的元素是否存在
    public BNode find(BNode root, char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        BNode left = find(root.left,val);
        if(left != null) {
            return left;
        }
        BNode right = find(root.right,val);
            if(right != null) {
                return right;
            }
        return null;
    }
}

/**
  * 力扣刷题 https://leetcode.cn/problems/same-tree/ 100 相同的树
  * @author xiaoxie
  * @date 2023/12/8 23:51
  * @param
  * @return null
  */
 class TreeNode {
    int val;
     TreeNode left;
    TreeNode right;TreeNode() {}
     TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
        this.right = right;
     }
     static class Solution {
         public boolean isSameTree(TreeNode p, TreeNode q) {
             if(p == null && q != null || p != null && q == null) return false;
             if(p == null && q == null) return true;
             if(p.val != q.val) return false;
             return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
         }
     }
  }
/**
 * 力扣刷题 https://leetcode.cn/problems/subtree-of-another-tree/ 572 另一棵子树
 * @author xiaoxie
 * @date 2023/12/8 23:51
 * @param
 * @return null
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root,subRoot)) return true;
        if(isSubtree(root.left,subRoot))return true;
        if(isSubtree(root.right,subRoot)) return true;
        return false;

    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null) return false;
        if(p == null && q == null) return true;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}


public class Text {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        BinaryTree.BNode tmp = b.CreateTree();
        b.preOrder(tmp);
        System.out.println();
        b.inOrder(tmp);
        System.out.println();
        b.postOrder(tmp);
        b.size(tmp);
        System.out.println();
        System.out.println(BinaryTree.treeSize);
        System.out.println(b.size2(tmp));
        System.out.println(b.getLeafNodeCount(tmp));
        System.out.println(b.getKLevelNodeCount(tmp,1));
        System.out.println(b.getHeight(tmp));
        System.out.println(b.find(tmp,'H'));

    }
}
