package CSDN;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-06
 * Time: 12:58
 */

/** * @author xiaoxie
 * @date 2024年03月06日 12:58
 */
public class AVLTree {
 public static class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public int bf;
     public TreeNode parent;
     public TreeNode(int val) {
         this.val = val;
     }
 }
 public TreeNode root;
 /**
  * 插入节点,并调整平衡因子
  * 使用旋转的方法调整平衡因子
  * @author xiaoxie
  * @date 2024/3/6 13:13
  * @param val
  * @return boolean
  */
  public boolean insertNode(int val) {
      TreeNode node = new TreeNode(val);
     if(root == null) {
         root = node;
         root.parent = null;
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
             return false;
         }
     }
     //cur == null
      //找到node是parent的左孩子还是右孩子
      if(node.val < parent.val) {
          parent.left = node;
      }else {
          parent.right = node;
      }
      node.parent = parent;
      cur = node;
      while (parent != null) {
          //计算节点的平衡因子
          //如果是左孩子就--
          //右孩子就++;
          if(cur == parent.left) {
              parent.bf--;
          }else {
              parent.bf++;
          }
          //根据不同的平衡因子有不同的情况
          //1.如果平衡因子为0
          if(parent.bf == 0) {
              break;
          } else if (parent.bf == 1 || parent.bf == -1) {
              cur = parent;
              parent = cur.parent;
          }else {
              if(parent.bf == 2) { //就代表右树高,需要调整右树的高度,就是左单旋,或者右左双旋
                  if(cur.bf == 1) {
                      rotateLeft(parent);
                  }else {
                      rotateRL(parent);//cur.bf = -1
                  }
              }else {//parent.bf == -2
                  if(cur.bf == 1) {
                      rotateLR(parent);
                  }else {//cur.bf == -1
                      rotateRight(parent);
                  }
              }
          }
      }
      return true;
  }
  /** 左单旋
   * 左旋,右树高的情况,需要调整右树的高度
   * @author xiaoxie
   * @date 2024/3/6 14:14
   * @param parent
   */
  private void rotateLeft(TreeNode parent) {
      TreeNode subR = parent.right;
      TreeNode subRL = subR.left;
      subR.left = parent;
      parent.right = subRL;
      if(subRL != null) {
          subRL.parent = parent;
      }
      //先记录parent节点的父亲节点
      TreeNode Pparent = parent.parent;
      parent.parent = subR;
      if(parent == root) {
          root = subR;
          subR.parent = null;
      }else {
          if(Pparent.left == parent) {
              Pparent.left = subR;
          }else {
              Pparent.right = subR;
          }
          subR.parent = Pparent;
      }
      parent.bf = 0;
      subR.bf = 0;
  }
  /**
   * 右单旋如果左树高的话需要调整左树的高度
   * @author xiaoxie
   * @date 2024/3/6 15:01
   * @param parent
   */
  private void rotateRight(TreeNode parent) {
      TreeNode subL = parent.left;
      TreeNode subLR = subL.right;
      subL.right = parent;
      parent.left = subLR;
      if(subLR != null) {
          subLR.parent = parent;
      }
      TreeNode Pparent = parent.parent;
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
          subL.parent = Pparent;
      }
      parent.bf = 0;
      subL.bf = 0;
  }
  /**
   * 左右双旋
   * @author xiaoxie
   * @date 2024/3/6 16:04
   * @param parent
   */
  private void rotateLR(TreeNode parent) {
      TreeNode subL = parent.left;
      TreeNode subLR = subL.right;
      int bf = subLR.bf;
      rotateLeft(parent.left);
      rotateRight(parent);
      if(bf == 1) {
          subLR.bf = 0;
          subL.bf = -1;
          parent.bf = 0;
      }else if(bf == -1) {
          subL.bf = 0;
          parent.bf = 1;
          subLR.bf = 0;
      }
  }
  /**
   * 右左双旋
   * @author xiaoxie
   * @date 2024/3/6 16:19
   * @param parent
   */
  private void rotateRL(TreeNode parent) {
      TreeNode subR = parent.right;
      TreeNode subRL = subR.left;
      int bf = subRL.bf;
      rotateRight(parent.right);
      rotateLeft(parent);
      if(bf == -1) {
          parent.bf = 0;
          subR.bf = 1;
          subRL.bf = 0;
      }else if(bf == 1) {
          parent.bf = -1;
          subRL.bf = 0;
          subR.bf = 0;
      }
  }
    private int height(TreeNode root) {
        if(root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);

        return leftH > rightH ? leftH+1 : rightH+1;
    }
    /**
     * 验证是否正确AVLTree
     * @author xiaoxie
     * @date 2024/3/6 16:49
     * @param root
     * @return boolean
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftH = height(root.left);
        int rightH = height(root.right);

        if(rightH-leftH != root.bf) {
            System.out.println("这个节点："+root.val+" 平衡因子异常");
            return false;
        }

        return Math.abs(leftH-rightH) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
}
