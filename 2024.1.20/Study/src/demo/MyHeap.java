package demo;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-20
 * Time: 14:23
 */

/** * @author xiaoxie
 * 创建堆
 * @date 2024年01月20日 14:23
 */
 class Heap {
    public int[] elem;
    public int size;

    public Heap() {
        this.elem = new int[10];
    }

    public void setElem(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            elem[i] = arr[i];
            size++;
        }
    }

    //创建大根堆
    public void createBigHeap() {
        for (int parent = (size - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(parent, size);
        }
    }
    public void siftDown(int parent, int size) {
        int child = 2 * parent + 1;
        while (child < size) {
            //child一定是左右孩子中最大的一个
            if (child + 1 < size && elem[child] < elem[child + 1]) {
                child++;
            }
            if (elem[child] > elem[parent]) {
                swap(parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = elem[i];
        elem[i] = elem[j];
        elem[j] = temp;
    }

    //创建小根堆
    public void createSmallHeap() {
        for (int parent = (size - 1 - 1) / 2; parent >= 0; parent--) {
            siftDownSmall(parent, size);
        }
    }
    public void siftDownSmall(int parent, int size) {
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && elem[child+1] < elem[child]) {
                child++;
            }
            if (elem[child] < elem[parent]) {
                swap(parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
    public int poll() {
        int temp = elem[0];
        swap(0,size-1);
        size--;
        siftDown(0,size);
        return temp;
    }
}
public class MyHeap {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        heap.setElem(arr);
        heap.createBigHeap();
        //heap.createSmallHeap();System.out.println();
        int tmp = heap.poll();
        System.out.println(tmp);
        System.out.println("=================");

            }
 }