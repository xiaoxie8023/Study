package demo4抽象类;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-08
 * Time: 22:44
 */
//包含抽象方法的类 也要被 abstract修饰
//子类必须要重写抽象类的抽象方法
abstract class  Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void fly();
}
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    @Override
    public void fly() {
        System.out.println("fly");
    }
}
public class Text {
    public static void main(String[] args) {
        //抽象类不能实例化对象
      /*  Animal animal = new Animal() */
    }
}
