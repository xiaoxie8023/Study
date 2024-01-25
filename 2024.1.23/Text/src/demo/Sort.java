package demo;/**
 * Created with IntelliJ IDEA.
 * Description: 复习
 * User: 谢忠涵7
 * Date: 2024-01-23
 * Time: 16:17
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/** * @author xiaoxie
 * @date 2024年01月23日 16:17
 */
public class Sort {
    /** 时间复杂度为
     * 最好时间复杂度为O（n）,最坏时间复杂度为O（n^2）
     * 空间复杂度为O（1）
     * 稳定性为：稳定
     * 直接插入排序
     * @author xiaoxie
     * @date 2024/1/23 16:34
     * @param array
     * @return null
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i -1;
            for (;j >=0;j--){
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    /**时间复杂度为 O(n^1.25--n^1.6)
     * 空间复杂度为: O（1）
     * 稳定性为：不稳定
     * 希尔排序
     * @author xiaoxie
     * @date 2024/1/23 16:38
     * @param array
     * @return null
     */
    public static void ShellSort(int[] array) {
        int Gap = array.length;
        while (Gap >= 1) {
            Gap /= 2;
            Shell(array,Gap);
        }
    }
    private static void Shell(int[] array,int Gap){
        for (int i = Gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-Gap;
            for (;j >= 0; j-= Gap) {
                if(array[j] > tmp) {
                    array[j+Gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+Gap] = tmp;
        }
    }
    /**
     * 交换数组中的两个数据
     * @author xiaoxie
     * @date 2024/1/23 16:36
     * @return null
     */
    private static void swap(int[] array,int i ,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    /**时间复杂度为 ：最好和最坏都是O（n^2）
     * 空间复杂度为: O（1）
     * 稳定性为：不稳定
     * 选择排序
     * @author xiaoxie
     * @date 2024/1/23 16:54
     * @param array
     * @return null
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length ; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }
    /**时间复杂度为 ：最好和最坏都是O（n^2）
     * 空间复杂度为: O（1）
     * 稳定性为：不稳定
     * 选择排序的优化
     * @author xiaoxie
     * @date 2024/1/23 17:05
     * @param array
     * @return null
     */
    public static void selectSort2(int[] array) {
        int left = 0,right = array.length-1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int i = left+1; i <= right; i++) {
                if(array[i] < array[minIndex]) {
                    minIndex = i;
                }
                if(array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(array,left,minIndex);
           if(maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array,right,maxIndex);
            left++;
            right--;
        }
    }
    /**时间复杂度为 ：最好为O（n）最坏为O（n^2）
     * 空间复杂度为: O（1）
     * 稳定性为：稳定
     * 冒泡排序
     * @author xiaoxie
     * @date 2024/1/23 18:17
     * @param array
     * @return null
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j+1] < array[j]) {
                    swap(array,j+1,j);
                    flag = true;
                }
            }
            if(flag == false) {
                return;
            }
        }
    }
    /** 快速排序
     * 时间复杂度：
     *          最好时间复杂度：O（n*log2n）
     *          最坏时间复杂度：O（n^2）
     * 空间复杂度：
     *          最好空间复杂度：O（log2n)
     *          最坏空间复杂度：O（n）
     * 稳定性：   不稳定
     *  一帮来说要对快排进行优化才能够更加节省效率
     * @author xiaoxie
     * @date 2024/1/25 18:51
     * @return null
     */
    public static void quickSort(int[] array) {
        quick(array,0, array.length-1);
    }
    private static void quick(int[] array,int start,int end) {
        if(start >= end){
            return;
        }
        if(end-start+1 >= 5) {
            insertSort2(array,start,end);
        }
        //三数取中法
        int index = middleNum(array, start, end);
        swap(array,index,start);
        //int pivot = partitionHoare(array,start,end);//Hoare法
        int pivot = partition(array,start,end);//挖坑法
        quick(array, start,pivot-1);
        quick(array,pivot+1,end);
    }
    private static void  insertSort2(int[] array,int start,int end) {
        for (int i = start+1; i <= end ; i++) {
            int tmp = array[i];
            int j = i-1;
            for (;j >= start ;j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    //三数取中法
    private static int middleNum(int[]array,int i,int j) {
        int mid = i + ((j-i) >>1);
        if(array[i] > array[j]) {
            if(array[mid] < array[j]) {
                return j;
            } else if (array[mid] > array[i]) {
                return i;
            }else {
                return mid;
            }
        } else {
            if(array[mid] < array[i]) {
                return i;
            } else if (array[j] < array[mid]) {
                return j;
            }else {
                return mid;
            }
        }
    }
    /**
     * Hoare法
     * @author xiaoxie
     * @date 2024/1/25 19:08
     * @return null
     */
    private static int partitionHoare(int[] array,int left,int right) {
        int tmp = array[left];
        int i = left;
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            while (left < right && array[left] <= tmp) {
                left++;
            }
            swap(array,left,right);
        }
        swap(array,i,left);
        return left;
    }
    /**
     * 挖坑法
     * @author xiaoxie
     * @date 2024/1/25 19:45
     * @param null
     * @return null
     */
    private static int partition(int[] array,int left,int right) {
        int tmp = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmp) {
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
    /**快速排序的非递归方法
     *
     * @author xiaoxie
     * @date 2024/1/25 19:57
     * @return null
     */
    public static void quickSortNor(int[] array) {
        int left = 0;
        int right = array.length-1;
        int pivot = partition(array,left,right);
        Stack<Integer> stack = new Stack<>();
        if(pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot-1);
        }
        if(pivot + 1 < right) {
            stack.push(pivot+1);
            stack.push(right);
        }
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(array,left,right);
            if(pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot-1);
            }
            if(pivot + 1 < right) {
                stack.push(pivot+1);
                stack.push(right);
            }
        }
    }
    /** 归并排序
     * 时间复杂度：
     * 最好时间复杂度：O（n*log2n）
     * 最坏时间复杂度：O（n*log2n）
     * 空间复杂度为： O（n）
     * 稳定性：稳定
     * @author xiaoxie
     * @date 2024/1/25 20:23
     * @return null
     */
    public static void margeSort(int[] array) {
        margeFunc(array,0,array.length-1);
    }
    private static void margeFunc(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        int mid = left + ((right - left) >>1);
        margeFunc(array,left,mid);//左边分解
        margeFunc(array,mid+1,right);//右边分解
        marge(array,left,mid,right);
    }
    private static void marge(int[] array,int left,int mid,int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        int k = 0;
        int[] tmp = new int[right-left+1];
        while (s1 <= e1 && s2 <= e2) {
            if(array[s1] <= array[s2]){
                tmp[k++] = array[s1++];
            }else {
                tmp[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmp[k++] = array[s2++];
        }
        for (int i = 0; i < k; i++) {
            array[i+left] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12,87,69,25,3,1,58,76,32};
        //Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
        //Sort.insertSort(array);
        //Sort.ShellSort(array);
        //Sort.selectSort(array);
        //Sort.selectSort2(array);
        //Sort.bubbleSort(array);
        //Sort.quickSort(array);
        //Sort.quickSortNor(array);
        Sort.margeSort(array);
        System.out.println(Arrays.toString(array));

    }
}
