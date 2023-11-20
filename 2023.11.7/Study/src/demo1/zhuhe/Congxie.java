package demo1.zhuhe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-07
 * Time: 17:03
 */
//关于重写的内容
    class Animal {
        public String name = "父亲";
        public int age = 38;
        public String sex ="女生";

    public Animal(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void show() {
            System.out.println(this.name+"在"+this.age+"是一个"+this.sex);
        }
}
class Dog extends Animal {
    public Dog(String name,int age,String sex) {
        super(name,age,sex);
    }

    public void show() {
            System.out.println(this.name+"在"+this.age+"是一个"+this.sex);
        }
}
public class Congxie {
        //向上转型-》是发生多态的条件之一
    public static void main(String[] args) {
       Animal animal= new Dog("儿子",10,"男生");//父类引用 引用了子类的对象
        animal.show();//调用的是父类的因为发生了动态绑定所以输出的是子类的
    }
}
