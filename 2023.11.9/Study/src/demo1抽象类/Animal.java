package demo1抽象类;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 21:52
 */
//1.被 abstract修饰的方法 类也必须要加abstract
//2.抽象类方法没有具体实现
//3.抽象类和普通类一样可以由成员变量和成员方法
//4.抽象类不可以实例化
//5.假设父类中有构造方法的话那要通过子类来调用构造方法来初始化父类
public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void eat();//抽象类方法
}
