package BinaryTree;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-17
 * Time: 14:28
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** * @author xiaoxie
 * @date 2024年01月17日 14:28
 */
public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    //以穷举的方式 创建一棵二叉树出来
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    //前序遍历
   public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    public void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    //后序遍历
    public void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    // 获取二叉树中节点的个数
    public int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size(root.left)+size(root.right)+1;
    }
    // 获取叶子节点的个数
    public int getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }
    // 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root,int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1) + getKLevelNodeCount(root.right,k-1);
    }
    // 获取二叉树的高度
    public int getHeight(TreeNode root) {
      if(root == null) {
          return 0;
      }
      int leftH = getHeight(root.left);
      int rightH = getHeight(root.right);
      return Math.max(leftH,rightH)+1;
    }
    // 检测值为value的元素是否存在
    public boolean find(TreeNode root,char val) {
        if(root == null) {
            return false;
        }
        if(root.val == val) {
            return true;
        }
        return find(root.left, val) || find(root.right, val);
    }
    //层序遍历使用队列来辅助
    //当涉及到层序遍历时，通常情况下使用队列来实现会更为简单和高效
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
           TreeNode cur = q.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                q.offer(cur.left);
            }
            if(cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                end = true;
            } else {
                if (end) {
                    return false; // 如果已经遇到空节点，再遇到非空节点，说明不是完全二叉树
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }
    /** * @author xiaoxie
     * @date 2024年01月17日 14:28
     * https://leetcode.cn/problems/same-tree/description/ 力扣刷题：二叉树题型 100.相同的树
     */

    class Solution1 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if(p == null && q != null || p != null && q == null) return false;
            if(p.val != q.val) return false;
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
    /** * @author xiaoxie
     * @date 2024年01月17日 14:28
     * https://leetcode.cn/problems/same-tree/description/ 力扣刷题：二叉树题型 572.另一棵树的子树
     */
    class Solution2 {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) return false;
            if (isSametree(root, subRoot)) return true;
            if (isSubtree(root.left, subRoot)) return true;
            if (isSubtree(root.right, subRoot)) return true;
            return false;
        }

        private boolean isSametree(TreeNode r, TreeNode s) {
            if (r == null && s == null) return true;
            if (r == null && s != null || r != null && s == null) return false;
            if (r.val != s.val) return false;
            return isSametree(r.left, s.left) && isSametree(r.right, s.right);
        }
        /** * @author xiaoxie
         * @date 2024年01月17日 14:28
         * https://leetcode.cn/problems/same-tree/description/ 力扣刷题：二叉树题型 226.翻转二叉树
         */
        class Solution3 {
            public TreeNode invertTree(TreeNode root) {
                if(root == null) return null;
                if(root.left == null && root.right == null) return root;
                TreeNode l = invertTree(root.left);
                TreeNode r = invertTree(root.right);
                root.left = r;
                root.right = l;
                return root;
            }
        }
        /** * @author xiaoxie
         * @date 2024年01月17日 14:28
         * https://leetcode.cn/problems/balanced-binary-tree/力扣刷题：二叉树题型 110. 平衡二叉树
         */
        //这个方法为O(n^2)
        class Solution4 {
            public boolean isBalanced(TreeNode root) {
                if(root == null) return true;
                int leftH = TreeHeight(root.left);
                int rightH = TreeHeight(root.right);
                if(Math.abs(leftH - rightH) < 2 && isBalanced(root.left) && isBalanced(root.right)) {
                    return true;
                }
                return false;
            }
            private int TreeHeight(TreeNode root) {
                if(root == null) return 0;
                int l = TreeHeight(root.left);
                int r = TreeHeight(root.right);
                return Math.max(l,r) + 1;
            }
        }
        //上个方法的进阶做法时间复杂度为O(n)
        //这个方法为O(n)
        class Solution5 {
            public boolean isBalanced(TreeNode root) {
                if(root == null) return true;
                return TreeHeight(root) > 0;
            }
            //规定如果左右子树的高度差的绝对值超过1就返回-1
            private int TreeHeight(TreeNode root) {
                if(root == null) return 0;
                int leftH = TreeHeight(root.left);
                int rightH = TreeHeight(root.right);
                if(leftH >= 0 && rightH >= 0 && Math.abs(leftH-rightH) <= 1) {
                    return Math.max(leftH,rightH)+1;
                }else {
                    return -1;
                }
            }
        }
        /** * @author xiaoxie
         * @date 2024年01月17日 14:28
         * https://leetcode.cn/problems/symmetric-tree/力扣刷题：二叉树题型 101. 对称二叉树
         */
        class Solution6{
            public boolean isSymmetric(TreeNode root) {
                if(root == null) return true;
                return isSameTree(root.left,root.right);
            }
            private boolean isSameTree(TreeNode r,TreeNode l) {
                if(r == null && l == null) return true;
                if(r == null && l!= null || r != null && l == null) return false;
                if(r.val != l.val) return false;
                return isSameTree(r.left,l.right) && isSameTree(r.right,l.left);
            }
        }
        /** * @author xiaoxie
         * @date 2024年01月17日 14:28
         * https://leetcode.cn/problems/binary-tree-level-order-traversal/ 力扣刷题：二叉树题型 102. 二叉树的层序遍历
         */
        class Solution7 {
            public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>>anser = new ArrayList<>();
                if(root == null) {
                    return anser;
                }
                Queue<TreeNode> q = new LinkedList<>();
                q.offer(root);
                while(!q.isEmpty()) {
                    int size = q.size();
                    List<Integer> list = new ArrayList<>();
                    while(size != 0) {
                        TreeNode cur = q.poll();
                        list.add(cur.val);
                        size--;
                        if(cur.left != null) {
                            q.offer(cur.left);
                        }
                        if(cur.right != null) {
                            q.offer(cur.right);
                        }
                    }
                    anser.add(list);
                }
                return anser;
            }
        }
    }
}
/** * @author xiaoxie
 * @date 2024年01月17日 14:28
 * KY11 二叉树遍历 使用前序遍历创建二叉树。然后使用中序遍历输出
 */
class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}
 class Main1 {
    public static int i = 0;
    public static TreeNode createTree(String str) {
        TreeNode root  = null;
        if(str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        } else {
            i++;
        }
        return root;
    }
    public static void inorderTree(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTree(root.left);
        System.out.print(root.val + " ");
        inorderTree(root.right);
    }
     /** * @author xiaoxie
      * @date 2024年01月17日 14:28
      * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/ 力扣刷题：二叉树题型 107.二叉树的层序遍历
      * 这题其实就和102. 二叉树的层序遍历差不多思路在遍历完一层节点之后，将存储该层节点值的列表添加到结果列表的尾部。
      * 这道题要求从下到上输出每一层的节点值，只要对上述操作稍作修改即可：
      * 在遍历完一层节点之后，将存储该层节点值的列表添加到结果列表的头部。
      */
     class Solution7 {
         public List<List<Integer>> levelOrderBottom(TreeNode root) {
             List<List<Integer>> result = new ArrayList<>();
             Queue<TreeNode> queue = new LinkedList<>();

             if(root == null) return result;
             queue.offer(root);
             while (!queue.isEmpty()){
                 List<Integer> list = new ArrayList<>();
                 int len = queue.size();
                 while(len > 0) {
                     TreeNode temp = queue.poll();
                     list.add(temp.val);
                     if (temp.left != null) queue.offer(temp.left);
                     if (temp.right != null) queue.offer(temp.right);
                     len--;
                 }
                 result.add(0,list);
             }
             return result;
         }
     }
}

