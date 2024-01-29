package demo1;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-01-29
 * Time: 11:48
 */

import java.util.Arrays;

/** * @author xiaoxie
 * @date 2024年01月29日 11:48
 */
public class Sort {
    public static void insertSort(int[] array) {
        insert(array,0, array.length-1);
    }
    private static void insert(int[] array,int start,int end) {
        for (int i = start+1; i <= end; i++) {
            int tmp = array[i];
            int j = i-1;
            for (;j >= start; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            Shell(array,gap);
        }
    }
    private static void Shell(int[] array,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                if(array[j] > tmp) {
                 array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void selectSort(int[] array) {
        select(array,0, array.length-1);
    }
    private static void select(int[] array,int start,int end) {
        for (int i = 0; i <= end ; i++) {
            int minIndex = i;
            for (int j = i+1; j <= end ; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }
    private static void swap(int[]array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void mergeSort(int[] array) {
        mergeFunc(array,0,array.length-1);
    }
    private static void mergeFunc(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = left + ((right-left) >> 1);
        //开始分解
        mergeFunc(array,left,mid);
        mergeFunc(array, mid+1, right);
        //开始合并
        merge(array,left,right,mid);
    }
    private static void merge(int[] array,int left,int right,int mid) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        int[] tmp = new int[right-left+1];//创建一个临时数组来储存数据
        int k = 0;//临时数组下标
        while (s1 <= e1 && s2 <= e2) {
            if(array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
            }
        }
        //看那个数组还有数据就拷贝过去
        while (s1 <= e1) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmp[k++] = array[s2++];
        }
        //3.拷贝到源数组
        for (int i = 0; i < k; i++) {
            array[i+left] = tmp[i];
        }
    }
    public static void quickSort(int[] array) {
        quick(array,0, array.length-1);
    }

    private static void quick(int[] array,int left,int right) {
        if(right-left <= 1) {
            return;
        }
        //三数取中法
        int index = middleNum(array,left,right);
        swap(array,left,index);
        int pivot = partition(array,left,right);
        quick(array,left,pivot-1);//递归左边
        quick(array,pivot+1,right);//递归右边
    }
    //三数取中
    private static int middleNum(int[] array,int start,int end) {
        int mid = start+((end-start)>>1);
        if(array[start] <  array[end]) {
            if(array[mid] > array[end]) {
                return end;
            } else if (array[mid] < array[start]) {
                return start;
            }else {
                return mid;
            }
        }else {
            if(array[mid] < array[end]) {
                return end;
            } else if (array[mid] > array[start]) {
                return start;
            }else {
                return mid;
            }
        }
    }
    //获取基准值的位置使用Hoare法
    private static int partitionHoare(int[] array,int left ,int right) {
        int tmp = array[left];//基准值
        int i = left;//记录下来基准值开始的下标
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            while (left < right && array[left] <= tmp) {
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,i);
        return left;
    }
    private static int partition(int[] array,int left ,int right) {
        int tmp = array[left];//记录基准值
        while (left < right) {
            while (left < right && array[right] >=  tmp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }

    public static void bubbleSort(int[] array) {
        //10个元素遍历9趟
        for (int i = 0; i < array.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    flag = true;
                }
            }
            //没有交换就证明有序
            if(flag == false) {
                return;
            }
        }
    }
    public static  void heapSort(int[] array) {
        crateHeap(array);//首先创建大根堆
        int end = array.length-1;
        while (end >= 0) {
           swap(array,0,end);
           siftDown(array,0,end);
           end--;
        }
    }
    private static void crateHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0; parent--) {
            siftDown(array,parent,array.length);
        }
    }
    private static void siftDown(int[] array,int parent,int len) {
        int child = 2*parent+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            if(array[child] > array[parent]) {
                swap(array,child,parent);
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1,10,15,23,63,45,82,5,87,98};
        //Sort.insertSort(array);
        //Sort.shellSort(array);
        //Sort.selectSort(array);
        //Sort.heapSort(array);
        //Sort.bubbleSort(array);
        //Sort.quickSort(array);
        Sort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
