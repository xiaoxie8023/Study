package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-02-19
 * Time: 16:45
 */

/** * @author xiaoxie
 * @date 2024年02月19日 16:45
 */

public class Text {
    public static void main(String[] args) {
        int[] array = {16, 3, 7, 11, 9, 26, 18, 14, 15};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            avlTree.insertTreeNode(array[i]);
        }
        System.out.println(avlTree.isAVLTree(avlTree.root));
    }
}
