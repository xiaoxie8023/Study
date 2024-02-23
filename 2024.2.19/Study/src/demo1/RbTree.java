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
        public COLOUR colour;
        public int val;
        public RBTreeNode(int val) {
          this.val = val;
          this.colour = COLOUR.RED;
        }
    }
}
