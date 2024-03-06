package CSDN;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-05
 * Time: 20:51
 */

//具体来说，对于一个有两个子结点的结点，如果我们选择在其左子树中寻找中序下的第一个结点来替换它
//那么这个中序下的第一个结点的关键码会大于该结点的父结点，这样会破坏二叉搜索树的有序性质。
//因此，为了保持二叉搜索树的有序性质，我们选择在其右子树中寻找中序下的第一个结点，
// 即右子树中关键码最小的结点，来替换要删除的结点。
// 这样可以保证删除后的二叉搜索树仍然是一个有效的二叉搜索树。
/** * @author xiaoxie
 * @date 2024年03月05日 20:51
 */
public class BinarySearchTree {
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;
    /**
     * 查询节点是否存在
     * @author xiaoxie
     * @date 2024/3/6 10:44
     * @param val
     * @return boolean
     */
    public boolean search(int val) {
        if(root == null) {
            System.out.println();
            return false;
        }
        TreeNode cur = root;
        while (cur != null) {
            if(val < cur.val) {
                cur = cur.left;
            } else if (val > cur.val) {
                cur = cur.right;
            }else {
                System.out.println("找到了");
                return true;
            }
        }
        System.out.println("该节点"+val+"不存在");
        return false;
    }
    /**
     * 插入节点
     * @author xiaoxie
     * @date 2024/3/6 10:47
     * @param val
     */
    public void insertTreeNode(int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) {
            root = node;
            return;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if(node.val < cur.val) {
                parent = cur;
                cur = cur.left;
            } else if (node.val > cur.val) {
                parent = cur;
                cur = cur.right;
            }else {
                System.out.println("节点值 " + val + " 已经存在于树中，不进行插入操作");
                return;
            }
        }
        //cur = null
        if(node.val < parent.val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
    }
    /**
     * 删除节点
     * 可以使用替罪羊的方法来实现
     * @author xiaoxie
     * @date 2024/3/6 12:15
     * @param val
     * @return boolean
     */
    public boolean remove(int val) {
        //首先先找到是哪一个节点
        if(root == null) {
            return false;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                break;
            }
        }
        //cur == null 说明要删除的节点不在二叉搜索树上
        if(cur == null) {
            return false;
        }
        // cur有多种情况
        //1.cur 没有左右孩子
        //2.cur 只有左孩子
        //3.cur 只有右孩子

        //4.cur 有左右孩子 -- 需要使用替罪羊的方法来删除
        if(cur.right != null && cur.left != null) {
            TreeNode t = cur.right;
            TreeNode tp = cur;
            while (t.left != null) {
                tp = t;
                t = t.left;
            }
            cur.val = t.val;//使要删除的节点的值等于替罪羊节点
            //删除替罪羊节点
            if(tp.left == t) {
                tp.left = t.right;
            }else {//出现tp.right = t 的情况,t节点一开始就是叶子节点
                tp.right = t.right;
            }
        }else {
            //cur 只有右孩子
            if(cur.left == null && cur.right != null){
                if(parent == null) {
                    root = cur.right;
                }else {
                    if(parent.val < cur.val) {
                        parent.right = cur.right;
                    }else {
                        parent.left = cur.right;
                    }
                }
            }//cur 只有左孩子
            else if (cur.left != null && cur.right == null) {
                if(parent == null) {
                    root = cur.left;
                }else {
                    if(parent.val < cur.val) {
                        parent.right = cur.left;
                    }else {
                        parent.left = cur.left;
                    }
                }
            }
            //cur 没有左右孩子
            else  {
                if(parent == null) {
                    root = null;
                }else {
                    if(parent.val < cur.val) {
                        parent.right = null;
                    }else {
                        parent.left = null;
                    }
                }
            }
        }
        return true;
    }
}
