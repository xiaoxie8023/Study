/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-27
 * Time: 21:24
 */

/** * @author xiaoxie
 * @date 2024年01月27日 21:24
 */
public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[]  array = new Node[10];
    private int size;   // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 8;//默认桶的大小
    public void  put(int key, int value) {
        Node node = new Node(key,value);
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        node.next = array[index];
        array[index] = node;
        if(loadFactor() >= LOAD_FACTOR) {
            resize();
        }
    }
    private void resize() {
        Node[] newNode = new Node[2*array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newNode.length;
                Node next = cur.next;
                cur.next = newNode[index];
                newNode[index] = cur;
                cur = next;
            }
        }
        array = newNode;
    }


    private double loadFactor() {
        return size * 1.0 / array.length;
    }
    public HashBucket() {

    }
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
}