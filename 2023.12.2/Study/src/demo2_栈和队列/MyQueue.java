package demo2_栈和队列;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-12-03
 * Time: 19:00
 */

/** 循环队列
 * * @author xiaoxie
 * @date 2023年12月03日 19:00
 */
class MyCircularQueue {
    public int[] elem;
    public int front;
    public int rear;
    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
    }
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        elem[rear] = value;
        rear = (rear+1) % elem.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        front = (front+1) % elem.length;
        return true;
    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = (rear == 0) ? elem.length-1 : rear-1;
        return elem[index];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return(rear+1)% elem.length == front;
    }
}