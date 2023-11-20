package demo1多态;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-08
 * Time: 21:53
 */
class Animal {
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
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
        System.out.println(this.name+"正在吃鸟粮....");
    }
}
public class text {
    //向上转型 穿参的用法
    public static void func(Animal animal) {
       animal.eat();
    }
    public static void main(String[] args) {
        //向上传递的直接赋值
       /* Animal animal1 = new Dog("旺财",3);
        Animal animal2 = new Bird("波哥",2);
        animal1.eat();
        animal2.eat();*/
        /*Dog dog = new Dog("旺财",3);
        Bird bird = new Bird("波哥",2);
        func(dog);
        func(bird);*/
    }
    //通过返回值来进行向上传递
    public static Animal func2() {
        return new Dog("旺财",3);
    }
}
