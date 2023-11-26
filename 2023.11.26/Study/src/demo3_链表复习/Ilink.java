package demo3_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-26
 * Time: 20:32
 */

/**
 * @author xiaoxie
 * @date 2023年11月26日 20:32
 */
public interface Ilink {
    //头插法
    void addFirst(int data);

    //尾插法
    void addLast(int data);

    //任意位置插入,第一个数据节点为0号下标
    void addIndex(int index, int data);

    //查找是否包含关键字key是否在单链表当中
    boolean contains(int key);

    //删除第一次出现关键字为key的节点
    void remove(int key);

    //删除所有值为key的节点
    void removeAllKey(int key);

    //得到单链表的长度
    int size();

    void clear();

    void display();
}
