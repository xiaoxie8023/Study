package demo;/**
 * Created with IntelliJ IDEA.
 * Description:1
 * User: 谢忠涵7
 * Date: 2024-01-23
 * Time: 20:45
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** * @author xiaoxie
 * @date 2024年01月23日 20:45
 */
 class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
  /** 二叉树问题
   * 力扣刷题 https://leetcode.cn/problems/balanced-binary-tree/ 110.平衡二叉树
   *  时间复杂度为O(n)
   *  自底向上的递归的递归
   * @author xiaoxie
   * @date 2024/1/23 20:46
   * @return boolean
   */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalancedChild(root) >= 0;
    }
    private int isBalancedChild(TreeNode root) {
        if(root == null) return 0;
        int leftH = isBalancedChild(root.left);
        int rightH = isBalancedChild(root.right);
        if(leftH >= 0 && rightH >= 0 && Math.abs(leftH-rightH) <= 1) {
            return Math.max(leftH,rightH)+1;
        }else {
            return -1;
        }
    }
}
/** BFS 广度优先遍历
 * 力扣刷题 https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * 102. 二叉树的层序遍历
 * @author xiaoxie
 * @date 2024/1/23 21:25
 * @return List<List<Integer>>
 */
class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size >0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                size--;
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
/** DFS 深度优先搜索
 * 力扣刷题 https://leetcode.cn/problems/binary-tree-right-side-view/
 * 199. 二叉树的右视图
 * 时间复杂度为O（n）
 * 空间复杂度为O（n）
 * @author xiaoxie
 * @date 2024/1/23 21:25
 * @return Lis<Integer>
 */
class Solution4 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return list;
    }
    private void dfs(TreeNode root,int depth) {
        if(root == null) return;
        //先访问 当前节点，再递归地访问 右子树 和 左子树。
        if(depth == list.size()) {//如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            list.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}
/** BFS 广度优先搜索
 * 力扣刷题 https://leetcode.cn/problems/binary-tree-right-side-view/
 * 199. 二叉树的右视图
 * 时间复杂度为O（n）
 * 空间复杂度为O（n）
 * @author xiaoxie
 * @date 2024/1/23 21:25
 * @return Lis<Integer>
 */
class Solution5 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode cur = queue.poll();
                if(size == 1) {
                    list.add(cur.val);
                }
                size--;
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return list;
    }
}
/** DFS 深度优先搜索
 *力扣刷题  https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *236. 二叉树的最近公共祖先
 * @author xiaoxie
 * @date 2024/1/23 22:22
 * @return null
 */
class Solution6 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p和q都没找到，那就没有
        if(left == null && right == null) {
            return null;
        }
        //左子树没有p也没有q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        //右子树没有p也没有q就返回左子树的结果
        if (right == null) {
            return left;
        }
        //左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }
}
public class Text {
}
