import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-02
 * Time: 16:06
 */
class Dog {
    public int age;
    String color;
    String name;
    public Dog() {

    }
    public Dog(int age,String color,String name) {
        this.age=age;
        this.color=color;
        this.name=name;
    }

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Dog(String color, String name) {
        this.color = color;
        this.name = name;
    }
    public void jiaps() {
        System.out.println("wawawa");
    }
}
//试计算在区间1 到n 的所有整数中，数字x（0 ≤ x ≤ 9）共出现了多少次？
//例如，在1到11 中，即在1、2、3、4、5、6、7、8、9、10、11 中，数字1 出现了4 次。
public class study {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += countOccurrences(i, x);
            }
            System.out.println(count);
        }
        private static int countOccurrences(int number, int digit) {
            int count = 0;
            while (number > 0) {
                if (number % 10 == digit) {
                    count++;
                }
                number /= 10;
            }
            return count;
        }
    public static void main10(String[] args) {
       char[] arr1 = new char[12];
        Arrays.fill(arr1,5,7,'*');
        char[] arr2 = new char[12];
        Arrays.fill(arr2,5,7,'*');
        char[] arr3 = new char[12];
        Arrays.fill(arr1,'*');
        char[] arr4 = new char[12];
        Arrays.fill(arr1,'*');
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4 ));
    }
    public static void main9(String[] args) {
        int[][]arrys = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(arrys));
    }
    public static void main7(String[] args) {
         Dog dog = new Dog(15,"啊啊");
         dog.jiaps();
        System.out.println("姓名："+dog.name+" 年龄: "+dog.age+" 颜色："+dog.color);
    }
    public static void main6(String[] args) {

    }
    public static void main8(String[] args) {
        int[] arry1 = {2,6,4,1};
        int[] arry2 = {1,2,34,3,4,5,7,23,12};
        int[] ret1 = oddnums(arry1);
        if(ret1[0] == -1)
        {
            System.out.println(false);
            System.out.println("不存在连续三个元素都是奇数的情况!");
        }else {
            System.out.println(true);
            System.out.println("存在连续三个元素都是奇数的情况，即"+Arrays.toString(ret1));
        }
        int[] ret2 = oddnums(arry2);
        if(ret2[0] == -1)
        {
            System.out.println(false);
            System.out.println("不存在连续三个元素都是奇数的情况!");
        }else {
            System.out.println(true);
            System.out.println("存在连续三个元素都是奇数的情况，即"+Arrays.toString(ret2));
        }

    }
    public static int[] oddnums(int[] arry) {
        for (int i = 0; i < arry.length-2; i++) {
            if(arry[i+2] %2 != 0 && arry[i] %2 != 0 &&arry[i+1] %2 != 0) {
                return new int[]{arry[i],arry[i+1],arry[i+2]};
            }
        }
        return new int[]{-1};
    }
    public static void main5(String[] args) {
        System.out.println("请输入数组中的元素个数：");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arry = new int[n];
        System.out.println("请依次输入数组中的元素：");
        for (int i = 0; i < arry.length; i++) {
            arry[i]= scan.nextInt();
        }
         int ret = num1(arry);
        System.out.println(ret);
    }
    public static int num1(int[] arry) {
        int count = 0;
        int majority = 0;
        for (int i = 0; i < arry.length; i++) {
            if (count == 0) {
                majority = arry[i];
                count = 1;
            } else if (arry[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }


    public static void main3(String[] args) {
        System.out.println("请输入数组中的元素个数：");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arry = new int[n];
        System.out.println("请依次输入数组中的元素：");
        for (int i = 0; i < arry.length; i++) {
            arry[i]= scan.nextInt();
        }
        int ret = num(arry);
        System.out.println(ret);
    }
    public static int num(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            for (int j = 0; j < arry.length ; j++) {
                if(arry[i]!=arry[j]) {
                    return i>j?arry[j]:arry[i];
                }
            }
        }
        return -1;
    }
        public static void main1(String[] args) {
            int[] nums = {2, 9, 6, 8, 12, 14, 18};
            int target = 23;
            int[] ret = NumsSum(nums, target);

            System.out.println(Arrays.toString(ret));
        }
        public static int[] NumsSum(int[]nums, int target) {
            int left = 0;
            int right = nums.length-1;
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                     if(nums[i]+nums[j] == target ) {
                         return new int[]{i, j};
                }
            }
            }
            return new int[]{-1,-1};
        }
    }