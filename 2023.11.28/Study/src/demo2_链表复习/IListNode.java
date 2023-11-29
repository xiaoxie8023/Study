package demo2_链表复习;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-29
 * Time: 11:28
 */

/** * @author xiaoxie
 * @date 2023年11月29日 11:28
 */
public interface IListNode {
    // 1、无头单向非循环链表实现
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
