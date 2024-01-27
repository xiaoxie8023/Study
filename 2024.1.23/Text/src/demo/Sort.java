package demo;/**
 * Created with IntelliJ IDEA.
 * Description: 复习
 * User: 谢忠涵7
 * Date: 2024-01-23
 * Time: 16:17
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/** * @author xiaoxie
 * @date 2024年01月23日 16:17
 */
public class Sort {
    /**
     * 时间复杂度为
     * 最好时间复杂度为O（n）,最坏时间复杂度为O（n^2）
     * 空间复杂度为O（1）
     * 稳定性为：稳定
     * 直接插入排序
     *
     * @param array
     * @return null
     * @author xiaoxie
     * @date 2024/1/23 16:34
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /**
     * 时间复杂度为 O(n^1.25--n^1.6)
     * 空间复杂度为: O（1）
     * 稳定性为：不稳定
     * 希尔排序
     *
     * @param array
     * @return null
     * @author xiaoxie
     * @date 2024/1/23 16:38
     */
    public static void ShellSort(int[] array) {
        int Gap = array.length;
        while (Gap >= 1) {
            Gap /= 2;
            Shell(array, Gap);
        }
    }

    private static void Shell(int[] array, int Gap) {
        for (int i = Gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - Gap;
            for (; j >= 0; j -= Gap) {
                if (array[j] > tmp) {
                    array[j + Gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + Gap] = tmp;
        }
    }

    /**
     * 交换数组中的两个数据
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/23 16:36
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 时间复杂度为 ：最好和最坏都是O（n^2）
     * 空间复杂度为: O（1）
     * 稳定性为：不稳定
     * 选择排序
     *
     * @param array
     * @return null
     * @author xiaoxie
     * @date 2024/1/23 16:54
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /**
     * 时间复杂度为 ：最好和最坏都是O（n^2）
     * 空间复杂度为: O（1）
     * 稳定性为：不稳定
     * 选择排序的优化
     *
     * @param array
     * @return null
     * @author xiaoxie
     * @date 2024/1/23 17:05
     */
    public static void selectSort2(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i <= right; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(array, left, minIndex);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array, right, maxIndex);
            left++;
            right--;
        }
    }

    /**
     * 堆排序
     * 时间复杂度为：O(n*log2n);
     * 空间复杂度为：O（1）;
     * 稳定性为：不稳定；
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/26 9:40
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            siftDown(array, 0, end);
            end--;
        }
    }

    private static void siftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private static void createHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            siftDown(array, parent, array.length);
        }
    }

    /**
     * 时间复杂度为 ：最好为O（n）最坏为O（n^2）
     * 空间复杂度为: O（1）
     * 稳定性为：稳定
     * 冒泡排序
     *
     * @param array
     * @return null
     * @author xiaoxie
     * @date 2024/1/23 18:17
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j + 1, j);
                    flag = true;
                }
            }
            if (flag == false) {
                return;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：
     * 最好时间复杂度：O（n*log2n）
     * 最坏时间复杂度：O（n^2）
     * 空间复杂度：
     * 最好空间复杂度：O（log2n)
     * 最坏空间复杂度：O（n）
     * 稳定性：   不稳定
     * 一帮来说要对快排进行优化才能够更加节省效率
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/25 18:51
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - start + 1 >= 5) {
            insertSort2(array, start, end);
        }
        //三数取中法
        int index = middleNum(array, start, end);
        swap(array, index, start);
        //int pivot = partitionHoare(array,start,end);//Hoare法
        int pivot = partition(array, start, end);//挖坑法
        quick(array, start, pivot - 1);
        quick(array, pivot + 1, end);
    }

    private static void insertSort2(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= start; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    //三数取中法
    private static int middleNum(int[] array, int i, int j) {
        int mid = i + ((j - i) >> 1);
        if (array[i] > array[j]) {
            if (array[mid] < array[j]) {
                return j;
            } else if (array[mid] > array[i]) {
                return i;
            } else {
                return mid;
            }
        } else {
            if (array[mid] < array[i]) {
                return i;
            } else if (array[j] < array[mid]) {
                return j;
            } else {
                return mid;
            }
        }
    }

    /**
     * Hoare法
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/25 19:08
     */
    private static int partitionHoare(int[] array, int left, int right) {
        int tmp = array[left];
        int i = left;
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            while (left < right && array[left] <= tmp) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, i, left);
        return left;
    }

    /**
     * 挖坑法
     *
     * @param null
     * @return null
     * @author xiaoxie
     * @date 2024/1/25 19:45
     */
    private static int partition(int[] array, int left, int right) {
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

    /**
     * 快速排序的非递归方法
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/25 19:57
     */
    public static void quickSortNor(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int pivot = partition(array, left, right);
        Stack<Integer> stack = new Stack<>();
        if (pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot + 1 < right) {
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(array, left, right);
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    /**
     * 归并排序
     * 时间复杂度：
     * 最好时间复杂度：O（n*log2n）
     * 最坏时间复杂度：O（n*log2n）
     * 空间复杂度为： O（n）
     * 稳定性：稳定
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/25 20:23
     */
    public static void margeSort(int[] array) {
        margeFunc(array, 0, array.length - 1);
    }

    private static void margeFunc(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        margeFunc(array, left, mid);//左边分解
        margeFunc(array, mid + 1, right);//右边分解
        marge(array, left, mid, right);
    }

    private static void marge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        int k = 0;
        int[] tmp = new int[right - left + 1];
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            } else {
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
            array[i + left] = tmp[i];
        }
    }

    /**
     * 归并排序的非递归
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/26 18:47
     */
    public static void mergeSortNor(int[] array) {
        int gap = 1;
        //最外层循环 控制组数
        while (gap < array.length) {
            //每一组进行排序
            for (int i = 0; i < array.length; i = i + 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                int right = mid + gap;
                if (right >= array.length) {
                    right = array.length - 1;
                }
                marge(array, left, mid, right);
            }
            gap *= 2;
        }
    }

    /**
     * 计数排序
     * 时间复杂度为：O（n+范围）
     * 空间复杂度为：O（范围）；
     * 稳定性：不稳定
     * 适用于范围小的，数字密集的情况
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/26 18:08
     */
    public static void CountingSort(int[] array) {
        //1.求最值 -> O(n)
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        //2、定义计数数组 进行初始化   -> O(n)
        int[] count = new int[max - min + 1];

        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            count[index]++;
        }

        //3、遍历计数数组   -> O(max-min) ：max-min-》范围
        int k = 0;//表示array数组的下标
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[k] = i + min;
                k++;
                count[i]--;
            }
        }
    }

    /**
     * 基数排序
     * 时间复杂度：
     * 基数排序的时间复杂度取决于数字的位数和桶的数量。
     * 假设待排序的数字有n个，最大位数为d，桶的数量为k，
     * 则基数排序的时间复杂度为O(d*(n+k))。
     * 空间复杂度：
     * 空间复杂度取决于桶的数量和每个桶中存放的元素数量。
     * 在实际情况下，桶的数量通常是固定的（通常为10），
     * 所以基数排序的空间复杂度可以表示为O(n+k)。
     * 稳定性：
     * 稳定
     *
     * @return null
     * @author xiaoxie
     * @date 2024/1/26 18:51
     */
    public static void RadixSort(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1, 2, 3, 4, 5, 9, 7, 4, 5, 3, 2, 1, 2, 1, 3, 1};
        //Sort.insertSort(array);
        //System.out.println(Arrays.toString(array));
        //Sort.insertSort(array);
        //Sort.ShellSort(array);
        //Sort.selectSort(array);
        //Sort.selectSort2(array);
        //Sort.bubbleSort(array);
        //Sort.quickSort(array);
        //Sort.quickSortNor(array);
        //Sort.margeSort(array);
        //Sort.heapSort(array);
        //Sort.CountingSort(array);
    }
}

