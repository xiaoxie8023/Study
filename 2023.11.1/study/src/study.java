/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-01
 * Time: 10:23
 */
import java.util.Arrays;
import java.util.Scanner;

public class study {
    public static void main(String[] args) {
        int[] nums = {2,9,6,8,12,14,18};
        int target = 23;
        int[] ret = NumsSum(nums,target);
        System.out.println(Arrays.toString(ret));
    }

    public static void main6(String[] args) {
        int[] arry = {1,9,5,6,8,7};
        int[] ret = OddFront(arry);
        System.out.println(Arrays.toString(arry));
    }
       public static int[] OddFront(int[] arry) {
           int left = 0;
           int right = arry.length-1;
           while(left<right) {
               if(arry[left] % 2 == 0 && arry[right] % 2 == 1 ) {
                   int temp = arry[right];
                   arry[right] = arry[left];
                   arry[left] = temp;
                   left++;
                   right--;
               }if(arry[left] % 2 == 1) {
                   left++;
               }if(arry[right] % 2 == 0) {
                   right--;
               }
           }
           return arry;
       }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数组的元素个数：");
        int n = scan.nextInt();
        int[] arry2 = new int[n];
        System.out.println("请依次输入数组的元素：");

        for (int i = 0; i < arry2.length; i++) {
            arry2[i] = scan.nextInt();

        }
        int ret = sum(arry2);
        System.out.println("数组所有元素的和为：" + ret);
        }

    public static int sum(int[] arry2) {
        int sum = 0;
        for (int i = 0; i < arry2.length; i++) {
            sum+=arry2[i];
        }
        return sum;
    }
    public static void main4(String[] args) {
        int[] arry1= {1,2,3};
        int[] ret =transform(arry1);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] transform(int[] arry1) {
        for (int i = 0; i < arry1.length; i++) {
            arry1[i] = arry1[i]*2;
        }
        return arry1;
    }
    public static void main3(String[] args) {
        int[] arry = new int[100];
        for (int i = 0; i < 100; i++) {
            arry[i] = i+1;
        }
        System.out.println(Arrays.toString(arry));
    }
    public static void main2(String[] args) {

    }
    public static void main1(String[] args) {
            int[] arr = {5, 13, 9, 27, 16, 4, 8,14,21};
            quickSort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
        public static void quickSort(int[] arr, int left, int right) {
            if (left < right) {
                // 选取一个基准数
                int pivot = partition(arr, left, right);
                // 对基准数左边的子数组进行快速排序
                quickSort(arr, left, pivot - 1);
                // 对基准数右边的子数组进行快速排序
                quickSort(arr, pivot + 1, right);
            }
        }

        public static int partition(int[] arr, int left, int right) {
            // 选取最右边的数作为基准数
            int pivot = arr[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) {
                    // 如果当前数比基准数小，将它和i+1位置的数交换
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 将基准数放到i+1位置
            int temp = arr[i + 1];
            arr[i + 1] = arr[right];
            arr[right] = temp;
            // 返回基准数的位置
            return i + 1;
        }
    }


