package demo;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-02-07
 * Time: 16:36
 */

/** * @author xiaoxie
 * @date 2024年02月07日 16:36
 */
public class AVLTree {
    static class TreeNode{
        public int val;
        public int bf;//平衡因子
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;//父亲节点的引用

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;
    /**
     * 插入AVL树
     * @author xiaoxie
     * @date 2024/2/7 16:39
     * @param null
     * @return null
     */
    public boolean insertNode(int val) {
        TreeNode node  = new TreeNode(val);
        if(root == null) {
            root = node;
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(cur.val < node.val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > node.val) {
                parent = cur;
                cur = cur.left;
            }else {
                return false;
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
        // 平衡因子 的修改
      while (parent != null) {
          //先看cur是parent的左还是右  决定平衡因子是++还是--
          if(parent.left == cur) {
              parent.bf--;
          }else {
              parent.bf++;
          }
          if(parent.bf == 0) {
              break;
          }else if(parent.bf == 1 || parent.bf == -1) {
              parent = parent.parent;
              cur = parent;
          }else {
              if(parent.bf == 2){//右树高，需要调整左树的高度
                  if(cur.bf == 1){
                      rotateLeft(parent);
                  }else {
                      //cur.bf == -1
                      rotateRL(parent);
                  }
              }else {
                  //parent == -2 左树高，需要调整右树的高度
                  if(cur.bf == 1) {
                      rotateLR(parent);
                  }else {
                      //cur.bf == -1
                      rotateRight(parent);
                  }
              }
          }
      }
      return true;
    }
    /** 新节点插入较高左子树的左侧
     * 右单旋
     * @author xiaoxie
     * @date 2024/2/19 13:50
     */
    private void  rotateRight(TreeNode parent) {
        TreeNode subL = parent.left;
        TreeNode subLR = subL.right;
        TreeNode Pparent =  parent.parent;
        subL.left = parent;
        parent.right = subLR;
        if(subLR != null) {
            subLR.parent = parent;
        }
        parent.parent = subL;
        if(parent == root) {
            root = subL;
            root.parent = null;
        }else {
            if(Pparent.left == parent) {
                Pparent.left = subL;
            }else {
                Pparent.right = subL;
            }
            subL.parent =  Pparent;
        }
        subL.bf = 0;
        parent.bf = 0;
    }
    /** 新节点插入较高右子树的右侧
     * 左单旋
     * @author xiaoxie
     * @date 2024/2/19 14:39
     * @param null
     * @return null
     */
    private void rotateLeft(TreeNode parent) {
        TreeNode subR = parent.right;
        TreeNode subRL = subR.left;
        TreeNode Pparent = parent.parent;
        parent.right = subRL;
        subR.left = parent;
        if(subRL != null) {
            subRL.parent = parent;
        }
        parent.parent = subR;
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
        subR.bf = 0;
        parent.bf = 0;
    }
    /** 新节点插入较高左子树的右侧：先左单旋再右单旋
     *  【左右双旋】
     * @author xiaoxie
     * @date 2024/2/19 14:55
     */
    private void  rotateLR(TreeNode parent){
        TreeNode subL = parent.left;
        TreeNode subLR = subL.right;
        int bf = subLR.bf;

        rotateLeft(parent.left);
        rotateRight(parent);

        if(bf == -1) {
            parent.bf = 1;
            subL.bf = 0;
            subLR.bf = 0;
        }else if{
            parent.bf = 0;
            subL.bf = -1;
            subLR.bf = 0;
        }
    }
    /** 新节点插入较高右子树的左侧---右左：先右单旋再左单旋
     *  【右左双旋】
     * @author xiaoxie
     * @date 2024/2/19 15:36
     */
    private void  rotateRL(TreeNode parent) {
        TreeNode subR = parent.right;
        TreeNode subRL = subR.left;
        int bf = subRL.bf;
        rotateRight(parent.right);
        rotateLeft(parent);
        if(bf == -1) {
            parent.bf = 0;
            subRL.bf = 0;
            subR.bf = 1;
        }else if {
            parent.bf = -1;
            subRL.bf = 0;
            subR.bf = 0;
        }
    }
}
