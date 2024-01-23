package demo;/**
 * Created with IntelliJ IDEA.
 * Description: 复习
 * User: 谢忠涵7
 * Date: 2024-01-23
 * Time: 16:17
 */

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] array = {12,87,69,25,3,1,58,76,32};
        //Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
        //Sort.insertSort(array);
        //Sort.ShellSort(array);
        //Sort.selectSort(array);
        //Sort.selectSort2(array);
        //Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }
}
