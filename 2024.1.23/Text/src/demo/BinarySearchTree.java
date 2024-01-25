package demo;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-25
 * Time: 10:57
 */

/** * @author xiaoxie
 * @date 2024年01月25日 10:57
 */
public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root ;

    public boolean search(int val) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val == val) {
                return true;
            } else if(cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return false;
    }

    public void insert(int val) {
        TreeNode cur = root,prev = null;
        if(cur == null) {
            new TreeNode(val);
            return;
        }
        while (cur != null) {
            if(cur.val < val) {
                prev = cur;
                cur = cur.right;
            }else if(cur.val > val) {
                prev = cur;
                cur = cur.left;
            }else {
                return;
            }
        }
        if(val > prev.val) {
            prev.right = new TreeNode(val);
        }else {
            prev.left = new TreeNode(val);
        }
    }
}
