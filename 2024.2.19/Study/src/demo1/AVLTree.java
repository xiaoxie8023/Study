package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-02-20
 * Time: 18:05
 */

/** * @author xiaoxie
 * @date 2024年02月20日 18:05
 */
public class AVLTree {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int val;
        public int bf;//平衡因子
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;
    public boolean insertTreeNode(int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) {
            root = node;
            return true;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if(val < cur.val) {
               parent = cur;
               cur = cur.left;
            } else if (val == cur.val) {
                return false;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        //cur == null
        if(parent.val < val) {
             parent.right = node;
        }else {
            parent.left = node;
        }
        node.parent = parent;
        cur = node;
        //平衡因子的计算
        while (parent != null) {
            //根据node是parent的左孩子还是右孩子来判断parent的平衡因子是加还是减 左减右加
            if(cur == parent.left ) {
                parent.bf--;
            }else {
                parent.bf++;
            }
            if(parent.bf == 0) {
                break;
            }else if(parent.bf == 1 || parent.bf == -1) {
                cur = parent;
                parent = cur.parent;
            }else {
                if(parent.bf == 2) {
                    if(cur.bf == 1){
                        rotateLeft(parent);
                    }else {
                        rotateRL(parent);//cur.bf == -1
                    }
                }else {
                    //parent.bf == -2
                    if(cur.bf == 1){
                        rotateLR(parent);
                    }else {
                        //cur.bf == -1
                        rotateRight(parent);
                    }
                }
                break;
            }
        }
        return true;
    }
    /** 插入较高左树的左侧
     * 右单旋
     * @author xiaoxie
     * @date 2024/2/20 21:42
     */
    private void rotateRight(TreeNode parent){
        TreeNode subL = parent.left;
        TreeNode subLR = subL.right;
        parent.left = subLR;
        subL.right = parent;
        if(subLR != null) {
            subLR.parent = parent;
        }
        //判断parent有没有父亲节点以及是左孩子还是右孩子
        TreeNode Pparent = parent.parent;
        if(parent == root) {
            root = subL;
            root.parent = null;
        }else {
            if(Pparent.left == parent) {
                Pparent.left = subL;
            }else {
                Pparent.right = subL;
            }
            subL.parent = Pparent;
        }
        parent.parent = subL;
        subL.bf = parent.bf = 0;
    }
    /** 插入较高右边树的右侧
     * 左单旋
     * @author xiaoxie
     * @date 2024/2/20 21:54
     * @param parent
     */
    private void rotateLeft(TreeNode parent) {
        TreeNode subR = parent.right;
        TreeNode subRL = subR.left;
        parent.right = subRL;
        subR.left = parent;
        if(subRL != null) {
            subRL.parent = parent;
        }
        //判断parent有没有父亲节点以及是左孩子还是右孩子
        TreeNode Pparent = parent.parent;
        if(parent == root) {
            root = subR;
            root.parent = null;
        }else {
            if(Pparent.left == parent) {
                Pparent.left = subR;
            }else {
                Pparent.right = subR;
            }
            subR.parent = Pparent;
        }
        parent.parent = subR;
        subR.bf = parent.bf = 0;
    }
    /** 插入较高左树的右侧
     * 左右双旋
     * @author xiaoxie
     * @date 2024/2/20 21:59
     * @param parent
     */
    private void rotateLR(TreeNode parent) {
        TreeNode subL = parent.left;
        TreeNode subLR = subL.right;
        int bf = subLR.bf;
        rotateLeft(parent.left);
        rotateRight(parent);
        //不同的插入情况的平衡因子的计算不同所以要先记录一下
        if(bf == -1) {
            subLR.bf = 0;
            subL.bf = 0;
            parent.bf = 1;
        }else if(bf == 1) {
            subLR.bf = 0;
            subL.bf = -1;
            parent.bf = 0;
        }
    }
    /** 插入较高右树的左侧
     * 右左双旋
     * @author xiaoxie
     * @date 2024/2/20 22:08
     * @param parent
     */
    private void rotateRL(TreeNode parent) {
        TreeNode subR = parent.right;
        TreeNode subRL = subR.left;
        int bf = subRL.bf;
        rotateRight(parent.right);
        rotateLeft(parent);
        if(bf == -1) {
            subRL.bf = 0;
            subR.bf = 1;
            parent.bf = 0;
        }else if(bf == 1) {
            subRL.bf = 0;
            parent.bf = -1;
            subR.bf = 0;
        }
    }
    /**
     * 求树的高度
     * @author xiaoxie
     * @date 2024/2/20 22:18
     * @param root
     * @return int
     */
    private int height(TreeNode root) {
        if(root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);

        return leftH > rightH ? leftH+1 : rightH+1;
    }
    /**
     * 验证是否是AVL树
     * @author xiaoxie
     * @date 2024/2/20 22:17
     * @param root
     * @return boolean
     */
   public boolean isAVLTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        if((rightH - leftH) != root.bf) {
            System.out.println("这个节点："+root.val+" 平衡因子异常");
            return false;
        }
        return  Math.abs(leftH-rightH) <= 1 && isAVLTree(root.left) && isAVLTree(root.right);
    }
}
