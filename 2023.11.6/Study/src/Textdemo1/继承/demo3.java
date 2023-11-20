package Textdemo1.继承;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-06
 * Time: 22:54
 */
class Person {
    public int a;
    static {
        System.out.println("父类的静态块在执行");
    }
    {
        System.out.println("父类的方法块在执行");
    }
    public Person(int a) {
        this.a = a;
        System.out.println("父类的构造方法在执行");
    }
}
class Student extends Person {
    public int b;
    static {
        System.out.println("子类的静态块在执行");
    }
    {
        System.out.println("子类的方法块在执行");
    }
    public Student(int a,int b) {
        super(a);
        this.b = b;
        System.out.println("子类的构造方法在执行");
    }
}
public class demo3 {
    public static void main(String[] args) {
        Student student = new Student(10,20);
        //输出顺序应该是静态块最先，先父类后子类。

    }
}
