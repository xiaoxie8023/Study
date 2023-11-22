package demo1;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:2023.11.22 JAVA 数据结构内容的复习
 * User: 谢忠涵7
 * Date: 2023-11-22
 * Time: 21:54
 */
class MyArray<T> {
    //T[] aa = new T[10];//不能实例化因为泛型是在编译时
    Object[] arr = new Object[10];
    public void setArr(int pos,T val) {
        arr[pos] = val;
    }
    public T getArr(int pos) {
        return (T) arr[pos];
    }
}

class Solution {
     /*
      * 数组类型的题目
      * https://leetcode.cn/problems/next-permutation/ 力扣 31.下一个排序
      * @author xiaoxie
      * @date 2023/11/22 22:46
      * @param nums
      */
     public void nextPermutation(int[] nums) {
         int i = nums.length-2;
         while(i > 0 && nums[i] > nums[i+1]) {
             i--;
         }
         if(i > 0) {
             Swap(nums,i);
             rever(nums,i);
         }
         rever(nums,i);
     }
    private void Swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = temp;
    }
    private void rever(int[] nums,int i) {
        int j = i+1;
        int k = nums.length-1;
        while(k-j > 0) {
            int temp = nums[k];
            nums[k] = nums[j];
            nums[j] = temp;
            j++;
            k--;
        }
    }
}
/** * @author xiaoxie
 * Date 2023年11月22日 21:54
 */
public class Text {
    /*
     * 力扣刷题
     * @author xiaoxie
     * @date 2023/11/22 22:41
     * @param null
     * @return null
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {3,2,1};
        s.nextPermutation(num);
    }
    /*
     *  什么是泛型
     * @author xiaoxie
     * @date 2023/11/22 22:13
     * @param 进行了擦除机制
     * @return null
     */
    public static void main3(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.setArr(5,12);
        myArray.setArr(4,12);
        myArray.setArr(3,12);
        int a = myArray.getArr(3);
        MyArray<String> myArray1 = new MyArray<>();
        myArray1.setArr(0,"nihao");
        myArray1.setArr(1,"nhao");
        String s = myArray1.getArr(0);
     /* MyArray myArray = new MyArray();
      myArray.setArr(0,52);
      myArray.setArr(1,"你好");
      int a = (int)myArray.getArr(0);
      String s = (String) myArray.getArr(1);*/
    }
/*
 *阿里巴巴的一道面试题:为什么 讲一下原理
 * @author xiaoxie
 * @date 2023/11/22 22:04
 * @param 原理为：从Integer的底层代码来看 首先在-128 -- 127之间赋值( valueOf)的数并不是创建了一个新的对象 而是把数值传到一个缓存器(cache)的数组中去所以 a1 == a2;
 * 而超过了这个范围之类的数赋值(valueOf)时创建了一个新的对象，所以 a3 != a4;
 *  public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
 * @return null
 */
    public static void main2(String[] args) {
        Integer a1 = 100;
        Integer a2 = 100;
        System.out.println(a1 == a2);//true
        Integer a3 = 200;
        Integer a4 = 200;
        System.out.println(a3 == a4);//false
    }
     /*装箱和拆箱
     * @author xiaoxie
     * @date 2023/11/22 21:55
     * @param null
     * @return null
     */
    public static void main1(String[] args) {
        int a = 15;
        Integer aa = a;//自动装箱
        Integer aa2 = 152;
        int a2 = aa2;//自动拆箱
        int a3 = 19;
        Integer aa3 = Integer.valueOf(a3);//手动装箱
        Integer aa4 = new Integer(19);//手动拆箱
        int a4 = aa4.intValue();
        double d = aa4.doubleValue();
    }
}
