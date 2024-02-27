package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-02-23
 * Time: 17:50
 */

/** * @author xiaoxie
 * @date 2024年02月23日 17:50
 */
public class RbTree {
    static class  RBTreeNode {
        public RBTreeNode left;
        public RBTreeNode right;
        public RBTreeNode parent;
        public COLOR color;
        public int val;
        public RBTreeNode(int val) {
          this.val = val;
          this.color = COLOR.RED;
        }
    }
    public RBTreeNode root;
    /**
     * 红黑树的插入
     * 1.根据平衡二叉树的规则插入节点
     * 2.根据红黑树的性质来调整节点的颜色
     * @author xiaoxie
     * @date 2024/2/27 9:31
     * @param val
     * @return boolean
     */
    public boolean insertNode(int val) {
        RBTreeNode node = new RBTreeNode(val);
        if(root == null) {
            root = node;
            root.color = COLOR.BLACK;
            return true;
        }
        RBTreeNode parent = null;
        RBTreeNode cur = root;
        while (cur != null) {
            if(val < cur.val) {
                parent = cur;
                cur = cur.left;
            } else if (val > cur.val) {
                parent = cur;
                cur = cur.right;
            }else {
                return false;
            }
        }
        //cur == null;
        if(parent.val > val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        node.parent = parent;
        cur = node;
        while (parent != null && parent.color == COLOR.RED) {
            RBTreeNode grandFather = parent.parent;
            //情况一: cur为红，p为红，g为黑，u存在且为红
            if(grandFather.left == parent) {
                RBTreeNode uncle = grandFather.right;
                if(uncle != null && uncle.color == COLOR.RED) {
                    grandFather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    cur = grandFather;
                    parent = grandFather.parent;
                }else {
                    //uncle不存在或者为黑色
                    //情况三: cur为红，p为红，g为黑，u不存在/u为黑 cur == parent.right
                    if(cur == parent.right) {
                        rotateLeft(parent);
                        RBTreeNode tmp = cur;
                        cur = parent;
                        parent = tmp;
                    }
                   //情况二: cur为红，p为红，g为黑，u不存在/u为黑
                    rotateRight(grandFather);
                    parent.color = COLOR.BLACK;
                    grandFather.color = COLOR.RED;
                }
            }else {
                RBTreeNode uncle = grandFather.left;
                if(uncle != null && uncle.color == COLOR.RED) {
                    grandFather.color = COLOR.RED;
                    parent.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    cur = grandFather;
                    parent = grandFather.parent;
                }else {
                    if(cur == parent.left) {
                        rotateRight(parent);
                        RBTreeNode tmp = cur;
                        cur = parent;
                        parent = tmp;
                    }
                    //uncle不存在或者为黑色
                    rotateLeft(grandFather);
                    parent.color = COLOR.BLACK;
                    grandFather.color = COLOR.RED;
                }
            }
        }
        // 在上述循环更新期间，可能会将根节点给成红色而违反性质1，因此此处必须将根节点改为黑色
        root.color = COLOR.BLACK;
        return true;
    }
    /** 左边最长路径比右边的最长路径的两倍还多
     *  需要调整左边的高度
     * 右单旋
     * @author xiaoxie
     * @date 2024/2/27 10:32
     * @param parent
     */
    private void rotateRight(RBTreeNode parent) {
        RBTreeNode subL = parent.left;
        RBTreeNode subLR = subL.right;
        subL.right = parent;
        parent.left = subLR;
        if (subLR != null) {
            subLR.parent = parent;
        }
        RBTreeNode Pparent = parent.parent;
        parent.parent = subL;
        if (parent == root) {
             root = subL;
            root.parent = null;
        } else {
            if (Pparent.left == parent) {
                Pparent.left = subL;
            } else {
                Pparent.right = subL;
            }
            subL.parent = Pparent;
        }
    }
    /**
     * 左单旋
     * @author xiaoxie
     * @date 2024/2/20 21:54
     * @param parent
     */
    private void rotateLeft(RBTreeNode parent) {
        RBTreeNode subR = parent.right;
        RBTreeNode subRL = subR.left;
        parent.right = subRL;
        subR.left = parent;
        if(subRL != null) {
            subRL.parent = parent;
        }
        //判断parent有没有父亲节点以及是左孩子还是右孩子
        RBTreeNode Pparent = parent.parent;
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
    }
    /** 判断一下这颗树是否为红黑树
     * 根据性质来判断
     * 1.根节点是否为黑色
     * 2.是否有两个连续的红色节点
     * 3.每条路径上的黑色节点数目是否相同
     * @author xiaoxie
     * @date 2024/2/27 16:55
     * @param root
     * @return boolean
     */
    public boolean isRbTree(RBTreeNode root) {
        //1.根节点是否为黑色
        if(root == null) {
            return true;
        }
        if(root.color != COLOR.BLACK) {
            System.out.println("违反了根节点为黑色的性质");
            return false;
        }
        //2.是否有两个连续的红色节点
        //3.每条路径上的黑色节点数目是否相同
        RBTreeNode cur = root;
        int pathBlackNum = 0;
        //计算红黑树最左边的黑色节点的个数
        while (cur != null) {
            if(cur.color == COLOR.BLACK) {
                pathBlackNum++;
            }
            cur = cur.left;
        }
        return checkRedNode(root) && checkBlackNum(root,0,pathBlackNum);
    }
    /**
     * 判断是否有两个连续的红色节点
     * 假如当前节点为红色的,那么他的父亲节点就不能为红色
     * @author xiaoxie
     * @date 2024/2/27 17:01
     * @param root
     * @return boolean
     */
    private boolean checkRedNode(RBTreeNode root) {
        if(root == null) {
            return true;
        }
        RBTreeNode parent = root.parent;
        if(root.color == COLOR.RED) {
            if(parent.color == COLOR.RED) {
                System.out.println("违反了不能有两个连续的红色节点性质");
                return false;
            }
        }
        return checkRedNode(root.left) && checkRedNode(root.right);
    }
    /** 每条路径上的黑色节点数目是否相同
     *  每计算一条路径上的黑色节点的个数都与最左边的黑色节点的个数相比
     * @author xiaoxie
     * @date 2024/2/27 17:10
     * @param root 根节点
     * @param blackNum 一条路径上的黑色节点的个数
     * @param pathBlackNum 最左边的黑色节点的个数
     * @return boolean
     */
    private boolean checkBlackNum(RBTreeNode root,int blackNum,int pathBlackNum) {
        if(root == null) {
            return true;
        }
        if(root.color == COLOR.BLACK) {
            blackNum++;
        }
        if(root.left == null && root.right == null) {
            if(blackNum != pathBlackNum) {
                System.out.println("违反了每条路径上的黑色节点数目相同的性质");
                return false;
            }
        }
        return checkBlackNum(root.left,blackNum,pathBlackNum) && checkBlackNum(root.right,blackNum,pathBlackNum);
    }
}
