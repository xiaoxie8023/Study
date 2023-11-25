package demo2_泛型;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-25
 * Time: 18:34
 */

/** * @author xiaoxie
 * @date 2023年11月25日 18:34
 */
class MyArray<E extends Number> {
    public Object[] arr = new Object[10];
    public void setArray(int pos,E val) {
        arr[pos] = val;
    }
    public E getVal(int pos) {
        return (E)arr[pos];
    }
}
//使用泛型类
class Alg<E extends Comparable<E>> {
    public E findMaxVal(E[] array) {
        E max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
//使用泛型方法
class Alg2 {
    //必须要加<E extends Comparable<E>> 来定义E
    //静态的泛型方法 需要在static后用<>声明泛型类型参数
    public static <E extends Comparable<E>> E findmax(E[] arry) {
        E max = arry[0];
        for (int i = 1; i < arry.length ; i++) {
            if(arry[i].compareTo(max) > 0) {
                max = arry[i];
            }
        }
        return max;
    }
}

public class Text {
    public static void main(String[] args) {
        Integer[] arr = {1,3,4,5,6,9,10};
        System.out.println(Alg2.findmax(arr));
    }
    public static void main2(String[] args) {
        Integer[] arr = {1,3,4,5,6};
        Alg<Integer> alg = new Alg<>();
        System.out.println(alg.findMaxVal(arr));

    }
    public static void main1(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        //MyArray<String> myArray1 = new MyArray<>();//泛型上界

    }
}
