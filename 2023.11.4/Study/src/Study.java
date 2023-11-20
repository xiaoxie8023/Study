/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-04
 * Time: 12:31
 */
import java.util.Arrays;//导Arrays包时我们要先导入java.util.Arrays类，以便在代码中使用该类提供的方法和功能

class MyClass {
    public static int staticVar = 10;

    public static void main10(String[] args) {
        // 输出初始值
        System.out.println("初始值：" + staticVar);

        // 修改静态变量的值
        staticVar = 20;

        // 创建一个新的对象
        MyClass obj = new MyClass();

        // 输出修改后的值
        System.out.println("修改后的值：" + obj.staticVar);

        // 修改静态变量的值
        obj.staticVar = 30;

        // 创建另一个新的对象
        MyClass obj2 = new MyClass();

        // 输出第二个对象的静态变量值
        System.out.println("第二个对象的值：" + obj2.staticVar);

        // 输出第一个对象的静态变量值
        System.out.println("第一个对象的值：" + obj.staticVar);
    }
}
class Dog {
    public String name;//非静态
    public int age;//非静态
    public String color;//静态
    public static int num;
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public Dog() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    {
        System.out.println("实例化代码块被执行了");
        age = 200;
    }
    static {
        System.out.println("静态化代码块被执行了");
        num = 100;
    }

}
public class Study {
    public static void main(String[] args) {

         Dog dog = new Dog();
        System.out.println(dog.age);
        System.out.println(Dog.num);
         /*int age = dog.getAge();
        String name = dog.getName();
        String color = dog.getColor();
        System.out.println("修改前：" + " 姓名：" + name + " 年龄：" + age + " 颜色：" + color);
        dog.setAge(4);
        dog.setColor("黑色");
        dog.setName("小黑");
        System.out.println("修改后：" + " 姓名：" + dog.getName() + " 年龄：" + dog.getAge() + " 颜色：" + dog.getColor());*/


    }
    public static void main1(String[] args) {
        int[] arry1 = {1,2,3,4,5,6,7,8,9};
        int[] arry2 = Arrays.copyOf(arry1,13);//参数为指定的数组名和数组长度
        System.out.println("arry1 ="+Arrays.toString(arry1));
        System.out.println("arry2 ="+Arrays.toString(arry2));
    }
}
