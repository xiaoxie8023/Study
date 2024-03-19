package CSDN;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-07
 * Time: 15:18
 */


/** * @author xiaoxie
 * @date 2024年03月07日 15:18
 */
public class RBTree {
    public static class RbTreeNode {
        public RbTreeNode left;
        public RbTreeNode right;
        public RbTreeNode parent;
        public int val;
        public COLOR color;
        public RbTreeNode(int val) {
            this.val = val;
            this.color = COLOR.RED;
        }
    }
    public RbTreeNode root;
    public boolean insert(int val) {
        RbTreeNode node = new RbTreeNode(val);
        if(root == null) {
            root = node;
            return true;
        }
        RbTreeNode cur = root;
        RbTreeNode parent = null;
        while (cur != null) {
            if(node.val < cur.val) {
                parent = cur;
                cur = cur.left;
            }else if(node.val > cur.val) {
                parent = cur;
                cur = cur.right;
            }else {
                System.out.println("这个节点" + val +"以及存在了");
                return false;
            }
        }
        //cur == null
        if(parent.val < node.val) {
            parent.right = node;
        }else {
            parent.left = node;
        }
        node.parent = parent;
        cur = node;
        while (parent != null && parent.color == COLOR.RED) {
            RbTreeNode grandfather = parent.parent;
            if(parent == grandfather.left) {//p节点为g节点的左孩子
                RbTreeNode uncle = grandfather.right;
                //uncle不为空,且uncle的颜色为红色
                if(uncle != null && uncle.color == COLOR.RED) {
                    grandfather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    cur = grandfather;
                    parent = cur.parent;
                }else {
                    //情况三
                    //需要先左旋后,交换 parent 和 cur 就是情况二
                    if(cur == parent.right) {
                        rotateLeft(parent);
                        RbTreeNode tmp = parent;
                        parent = cur;
                        cur = tmp;
                    }
                    //情况二
                    // 叔叔节点不存在 || 叔叔节点存在，但是颜色是黑色
                    rotateRight(grandfather);
                    grandfather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                }
            }else {///p节点为g节点的右孩子
                 RbTreeNode uncle = grandfather.left;
                if(uncle != null && uncle.color == COLOR.RED) {
                    grandfather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    cur = grandfather;
                    parent = cur.parent;
                }else {
                    //情况三
                    if(cur == parent.left) {
                        rotateRight(parent);
                        RbTreeNode tmp = parent;
                        parent = cur;
                        cur = tmp;
                    }
                    //情况二
                    //叔叔节点不存在 || 叔叔节点存在，但是颜色是黑色
                    rotateLeft(grandfather);
                    grandfather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                }
            }
        }
        return true;
    }
    /**
     * 右旋
     * @author xiaoxie
     * @date 2024/3/12 15:23
     * @param parent
     */
    private void rotateRight(RbTreeNode parent) {
        RbTreeNode subL = parent.left;
        RbTreeNode subLR = subL.right;
        subL.right = parent;
        parent.left = subLR;
        if(subLR != null) {
            subLR.parent = parent;
        }
        RbTreeNode Pparent = parent.parent;
        parent.parent = subL;
        if(parent == root) {
            root = subL;
            root.parent = null;
            root.color = COLOR.BLACK;
        }else {
            if(Pparent.left == parent) {
                Pparent.left = subL;
            }else {
                Pparent.right = subL;
            }
            subL.parent = Pparent;
        }
    }
    /**
     * 左旋
     * @author xiaoxie
     * @date 2024/3/12 15:24
     * @param parent
     */
    private void rotateLeft(RbTreeNode parent) {
        RbTreeNode subR = parent.right;
        RbTreeNode subRL = subR.left;
        subR.left = parent;
        parent.right = subRL;
        if(subRL != null) {
            subRL.parent = parent;
        }
        //先记录parent节点的父亲节点
        RbTreeNode Pparent = parent.parent;
        parent.parent = subR;
        if(parent == root) {
            root = subR;
            subR.parent = null;
            root.color = COLOR.BLACK;
        }else {
            if(Pparent.left == parent) {
                Pparent.left = subR;
            }else {
                Pparent.right = subR;
            }
            subR.parent = Pparent;
        }
    }
}
