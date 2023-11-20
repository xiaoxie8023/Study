package Textdemo1.继承;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-06
 * Time: 21:56
 */
//动物类为父类，基类
class Animal {
    public String name;
    public int age;
    public void eat() {
        System.out.println(this.name+"正在吃");
    }
}
//狗类继承了动物类的成员变量和方法
//狗类为子类，派生类
class Dog extends Animal {
    public String color;
    public void sleep() {
        System.out.println(this.name+"正在睡觉");
    }
    //同理，dog调用的方法也是优先调用自身类的方法
    public void eat() {
        System.out.println(this.name+"正在吃狗粮");
    }
}
class Cat extends Animal {
    public String color;

    public void sleep() {
        System.out.println(this.name + "正在睡觉");
    }
}
    public  class demo1 {
        public static void main(String[] args) {
           Dog dog = new Dog();
            dog.name = "旺财";
           dog.eat();
           //super.eat();因为main方法是被关键字static 修饰的静态方法 super和this一样不能出现在静态方法中，因为main方法不依赖对象

          /* dog.name = "旺财";
           dog.eat();//子类调用了父类的方法
           Cat cat = new Cat();
            cat.name = "miaomiao";
            cat.eat();//子类调用了父类的方法*/

        }

        }
