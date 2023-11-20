package demo1抽象类;

/**
 * Created with IntelliJ IDEA.
 * Description:1 usage 就是子类帮助父类初始化成员变量，因为父类为抽象类，不能实例化
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 21:55
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(this.name + "正在吃狗粮。。。");
    }
}
