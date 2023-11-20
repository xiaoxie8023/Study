package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-10
 * Time: 21:57
 */
import java.util.Arrays;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;
/*
//public class Main {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Base base = new Sub(x, y);
            base.calculate();
        }
    }

}
*/

/*class Base {

    private int x;
    private int y;

    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void calculate() {
        System.out.println(getX() * getY());
    }

}*/

/*class Sub extends Base {
    public Sub(int x, int y) {
        super(x, y);
    }
    public void calculate() {
        if (getY() != 0) {
            System.out.println(getX()/getY());
        } else {
            System.out.println("Error");
        }

    }


}*/
/*
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.next();
            Base obj = (Base) Class.forName(className).newInstance();
            System.out.println(getClassName(obj));
        }
    }

    public static String getClassName(Base obj) {

        return obj.getClass().getName();//write your code here......
    }

}

class Base {

}

class Sub1 extends Base {

}

class Sub2 extends Base {

}*/
import java.util.Scanner;

/*
public class Main {

    public static void main(String[] args) {
        // Sub是需要你定义的子类
        Base base = new Sub();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            base.setX(x);
            base.setY(y);
            System.out.println(base.calculate());
        }
    }

}

abstract class Base {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int calculate() {
        if (avg() == 0) {
            return 0;
        } else {
            return sum() / avg();
        }
    }

    */
/**
     * 返回x和y的和
     *//*

    public abstract int sum();

    */
/**
     * 返回x和y的平均值
     *//*

    public abstract int avg();

}

class Sub extends Base {

    public int sum() {
        return getX()+getY();
    }//write your code here......
    public int avg() {
        return (getX()+getY())/2;
    }
   */
/* public int calculate() {
        if (avg() == 0) {
            return 0;
        } else {
            return sum() / avg();
        }
    }
*//*

}*/
/*import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Comparator comparator = new ComparatorImpl();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(comparator.max(x, y));
        }
    }

}

interface Comparator {
    *//**
     * 返回两个整数中的最大值
     *//*
    int max(int x, int y);
}
class ComparatorImpl implements Comparator {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int max(int x, int y) {
        return x>y?x:y;
    }
}*/
//write your code here......
//父类Base中定义了若干get方法，以及一个sum方法，sum方法是对一组数字的求和。
// 请在子类 Sub 中重写 getX() 方法，使得 sum 方法返回结果为 x*10+y
/*
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Sub sub = new Sub(x, y);
            System.out.println(sub.sum());
        }
    }

}

class Base {

    private int x;
    private int y;

    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int sum() {
        return getX() + getY();
    }

}

class Sub extends Base {

    public Sub(int x, int y) {
        super(x, y);
    }

    public int getX() {
        return super.getX()*10;
    } //write your code here......


}*/
//Singleton类是单例的，每次调用该类的getInstance()方法都将得到相同的实例，
// 目前该类中这个方法尚未完成，请将其补充完整，使得main()函数中的判断返回真（不考虑线程安全）
/*
public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }

}

class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }//write your code here......


}
*/
//春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，
// 他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，
// 比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
//输入描述：
//输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
//输出描述：
//对于每个测试实例，要求输出所有在给定范围内的水仙花数，
// 就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有多个
// 则要求从小到大排列在一行内输出，之间用一个空格隔开;
// 如果给定的范围内不存在水仙花数，则输出no; 每个测试实例的输出占一行。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arry = new int[7];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arry.length; i++) {
            arry[i] =scan.nextInt();
        }
        double sum = 0.0;
        Arrays.sort(arry);
        int[] arry2 =  Arrays.copyOfRange(arry,1,6);
        for (int i = 0; i < arry2.length; i++) {
            sum += arry2[i];
        }
        double ret =( sum*1.0)/arry2.length;
        System.out.printf("%.2f",ret);
    }
    public static void main2(String[] args) {
        for (int i = 10000; i <=99999 ; i++) {
            int sum = 0;
            for (int j = 10; j <=10000 ; j*=10) {
                sum+=(i%j)*(i/j);
            }if(sum == i) {
                System.out.print(i+" ");
            }
        }
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            if (m > n || n > 999 ||m < 100) {
                return;
            }
             isNumber(m, n);
        }

    }
    public static void isNumber(int m, int n) {
        int sum = 0;
        int count = 0;
        for (int i = m; i <=n ; i++) {
            int temp = i;
            int a = i%10;
            i /= 10;
            int b = i%10;
            i /= 10;
            int c = i%10;
            i = temp;
            if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3) == temp ) {
                count++;
                System.out.print(temp+" ");
            }
        }
        if(count == 0) {
            System.out.println("no");
        }
    }
}