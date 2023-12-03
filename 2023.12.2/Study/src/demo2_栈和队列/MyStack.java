package demo2_栈和队列;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-02
 * Time: 22:15
 */

/** * @author xiaoxie
 * @date 2023年12月02日 22:15
 */

import java.util.Arrays;
public class MyStack {
    public int[] elem;
    public int size;
    private static final int Max = 10;

    public MyStack() {
        this.elem = new int[Max];
    }
    //压栈 入栈
    public void push(int val) {
        if(isFull()) {
            elem = Arrays.copyOf(elem,elem.length+(elem.length >> 1));
        }
        elem[size++] = val;
    }
    public boolean isFull() {
        return size == Max;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return -1;
        }
        int temp = elem[size-1];
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return -1;
        }
        return elem[size-1];
    }
}

