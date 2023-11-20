package demo2多态1;

/**
 * Created with IntelliJ IDEA.
 * Description:什么情况下不能发生重写
 * User: 谢忠涵7
 * Date: 2023-11-08
 * Time: 22:18
 */

class Animal {
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
//1.如果加上了关键字 final 就不可以发生重写
//2.如果是被static 修饰的静态方法 也不可以发生重写
//3.最好不要在构造方法中重写
//4.被private 权限修饰的方法也不可以
//5.注意被其他权限修饰的方法 子类的修饰权限要大于等于父类的权限
  /* 4.private*/ /* 1.final*/ /*2.static*/ public void eat() {
        System.out.println(this.name+"正在吃....");
    }
}
class Dog extends Animal {
    public Dog(String name,int age ) {
        super(name,age);
    }

    @Override//重写，建议加上@Override编译器就会检测是否符合重写的语法
    public void eat() {
        System.out.println(this.name+"正在吃狗粮....");
    }
}
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override//重写
    public void eat() {
        System.out.println(this.name + "正在吃鸟粮....");
    }
}
public class text {
    public static void main(String[] args) {

    }
}
