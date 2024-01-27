/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-27
 * Time: 15:02
 */

import demo.BinarySearchTree;

/** * @author xiaoxie
 * @date 2024年01月27日 15:02
 */
public class Text2 {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(10);
        b.insert(8);
        b.insert(15);
        b.insert(5);
        b.insert(9);
        b.insert(4);
        b.insert(20);
        b.insert(12);
        System.out.println(b.search(10));
        b.remove(10);
        System.out.println(b.search(12));

    }
}
