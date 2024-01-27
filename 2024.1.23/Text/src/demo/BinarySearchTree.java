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
            if(cur.val > val) {
                cur = cur.left;
            } else if(cur.val < val) {
                cur = cur.right;
            }else {
               return true;
            }
        }
        return false;
    }

    public void insert(int val) {
        if(root == null) {
           root = new TreeNode(val);
            return;
        }
        TreeNode cur = root,prev = null;
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
    public void remove(int val){
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if(cur.val < val) {
                prev = cur;
                cur = cur.left;
            } else if (cur.val > val) {
                prev = cur;
                cur = cur.right;
            }else {
                removeNode(prev,cur);
            }
        }
    }
    private void removeNode(TreeNode prev,TreeNode cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            } else if (prev.right == cur) {
                prev.right = cur.right;
            }else {
                prev.left = cur.right;
            }
        } else if (cur.right == null) {
            if(cur == root) {
                root = cur.left;
            } else if (prev.right == cur) {
                prev.right = cur.left;
            }else {
                prev.left = cur.left;
            }
        }else {
            TreeNode t = cur.right;
            TreeNode tp = cur;
            while (t.left!= null) {
                tp = t;
                t = t.left;
            }
            cur.val = t.val;
            if(tp.left == t) {
                tp.left = t.right;
            }else {
                tp.right = t.right;
            }
        }
    }

}
