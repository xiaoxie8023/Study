package demo;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-20
 * Time: 14:23
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    public void offer(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(elem,elem.length+(elem.length>>1));
        }
        elem[size] = val;
        size++;
        siftUp(size-1);
    }
    private boolean isFull() {
        return size == elem.length;
    }
    private void siftUp(int child) {
        int parent =( child-1)/2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                swap(child,parent);
                child = parent;
                parent =( child-1)/2;
            }else {
                break;
            }
        }
    }
    public void Heapsort() {
        int end = size-1;
        while(end > 0) {
            swap(0,end);
            siftDown(0,end-1);
            end--;
        }
    }

}
class Student {
     public String name;
     public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class comparator implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }

}
public class MyHeap {
    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37};
        Heap heap = new Heap();
        heap.setElem(array);
        heap.createBigHeap();
        System.out.println("===============");
        heap.Heapsort();
        System.out.println("==================");
    }

    public static void main1(String[] args) {
       /* Heap heap = new Heap();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        heap.setElem(arr);
        heap.createBigHeap();
        //heap.createSmallHeap();System.out.println();
        int tmp = heap.poll();
        System.out.println(tmp);
        System.out.println("=================");*/
        comparator comparator = new comparator();
        //大根堆的建造
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.offer(10);
        priorityQueue.offer(98);
        priorityQueue.offer(21);
        System.out.println();
            }
 }