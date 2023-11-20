package demo1.组合;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-07
 * Time: 16:26
 */
//protected 封装的成员变量可以被同一个包的不同类所访问
 /*final*/ public class Animal {//必需要加public 要不然不同包的类不可以继承
     //加了 关键字final 就表示这个类是密封类 不可以被继承
    protected String name = "chuhua";
    protected int age;
    private char sex;//同一个包的同一类可以访问
    protected  void eat(String name) {
        System.out.println(this.name+"1111");

    }
}
