package demo3_顺序表;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-25
 * Time: 19:26
 */

/**
 * @author xiaoxie
 * @date 2023年11月25日 19:26
 */
public interface Ilist {
    void add(int data);
    void add(int pos, int data);
    boolean contains(int toFind);
    int indexOf(int toFind);
    int get(int pos);
    void set(int pos, int value);
    void remove(int toRemove);
    int size();
    void clear();
    void display();
    boolean isfull();
    boolean isEympt();

}
