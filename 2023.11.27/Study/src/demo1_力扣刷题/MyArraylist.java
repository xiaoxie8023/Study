package demo1_力扣刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-27
 * Time: 20:53
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/** * @author xiaoxie
 * @date 2023年11月27日 20:53
 */
public class MyArraylist {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }
    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if(isFull()) {
            this.elem = Arrays.copyOf(elem,elem.length+(elem.length >> 1));
        }
        elem[usedSize] = data;
        usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     * @return true:满   false代表空
     */
    public boolean isFull() {
        if(usedSize == elem.length) {
           return true;
        }else {
            return false;
        }
    }

    private boolean checkPosInAdd(int pos) {
        if(pos < 0 || pos >= elem.length) {
            return false;
        }return true;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        checkPosInAdd(pos);
        if (isFull()) {
            this.elem = Arrays.copyOf(elem,elem.length+(elem.length >> 1));
        }
        for (int i = usedSize-1; i > pos-1; i--) {
            elem[i+1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if(elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if(elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        checkPosInAdd(pos);
        if(isEmpty()) {
            return -1;
        }
        return elem[pos];
    }

    private boolean isEmpty() {
        if(usedSize == 0) {
            return true;
        }
        return false;
    }
    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        checkPosInAdd(pos);
        if(isEmpty()) {
            System.out.println("顺序表为空");
        }
        elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     * @param key
     */
    public void remove(int key) {
        if(isEmpty()) {
            System.out.println("顺序表为空");
        }
        int index = indexOf(key);
        for (int i = index; i < usedSize-1; i++) {
            elem[i] = elem[i+1];
        }
        usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        usedSize = 0;
    }
}