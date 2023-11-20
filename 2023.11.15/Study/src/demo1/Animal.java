package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-15
 * Time: 13:24
 */
public abstract class Animal {
    //和普通的类一样可以创建成员变量，静态成员变量
    public String name;
    private int age;
    protected String sex;
    public static int a;
    //和普通的类一样可以创建成员方法，静态成员方法
    public void func1() {

    }
    public static void func2() {

    }
    //和普通类不一样的是抽象类还可以创建抽象方法
    //抽象方法要在方法的前面加上关键字abstract 并且没有具体的实现
    public abstract void func3();

}
