package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-10
 * Time: 10:47
 */
class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(this.name+"正在吃");
    }
}
class Dog extends Animal {

    public Dog(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }
    public String sex;
    public void Bark() {
        System.out.println(this.name+"汪汪叫");
    }
    public void func() {
        System.out.println(super.name);
    }

}
public class Main {
    public static void main(String[] args) {
    }
}
