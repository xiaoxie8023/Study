package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-22
 * Time: 15:30
 */

import java.util.Arrays;

/** * @author xiaoxie
 * @date 2024年01月22日 15:30
 */
public class PriorityQueue {
    public int[] elem;
    public int usedSize;

    public PriorityQueue() {
        this.elem = new int[10];
    }

    public void setElem(int[] array) {
        for(int i = 0; i <array.length;i++) {
            elem[i] = array[i];
        }
    }

    /**
     * 建堆的时间复杂度：O(n)
     * 创建大根堆
     * @param array
     */
    public void createHeap(int[] array) {
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            siftDown(parent, usedSize-1);
        }
    }

    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void siftDown(int root,int len) {
        int child = root*2+1;
        while (child < len) {
            if(child+1 < len && elem[child] < elem[child+1]) {
                child++;
            }
            if(elem[child] > elem[root]) {
                swap(child,root);
                child = root;
                child = root*2+1;
            }else {
                break;
            }
        }
    }
    /**
     * 交换
     * @param i ,j 需要交换的两个节点
     */
    private void swap(int i,int j){
        int temp = elem[i];
        elem[i] = elem[j];
        elem[j] = temp;
    }
    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(elem,usedSize+usedSize>>1);
        }
        elem[usedSize] = val;
        usedSize++;
        siftUp(usedSize-1);
    }

    private void siftUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                swap(child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        swap(0,usedSize-1);
        usedSize--;
        siftDown(0,usedSize);
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        return elem[0];
    }
}