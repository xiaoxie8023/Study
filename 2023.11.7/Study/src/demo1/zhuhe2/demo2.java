package demo1.zhuhe2;
import demo1.组合.Animal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-07
 * Time: 16:38
 */
class Dog extends Animal {
    public  String name = "xiaohai";
    public void show() {
        System.out.println(super.name);//被不同包的子类继承后要想调用父类的成员变量要加关键字super
        System.out.println(super.age);//被不同包的子类继承后要想调用父类的成员变量要加关键字super
        super.eat("小虎");
    }
}
public class demo2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.show();

    }
}
