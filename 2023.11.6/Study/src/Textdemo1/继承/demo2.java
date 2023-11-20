package Textdemo1.继承;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-06
 * Time: 22:13
 */
//总结
//super访问父类的成员变量
//super访问父类的方法
//super（）访问父类的构造方法
class Base {
    public int a; //= 15;
    public int b; //= 10;
   /* public void text() {
        System.out.println("父类的text方法");
    }*/
    public Base(int a,int c ) {
        this.a = a;
        this.b = b;
    }

}
//为什么会报错呢？ 这是因为写子类的构造函数之前要先写父类的构造函数；先有父的初始化才有子类
class Draver extends Base {
    public int c; //= 20;
    //为什么这里也报错呢 同理要加super()访问父类的构造方法
    //那为什么什么都不写就不会报错呢
    //因为编译器帮我们写了
    //我们写之后，编译器就不写了
    public Draver(int a,int b,int c) {
        super(a,b);
        this.c = c;
    }
    //public int a //= 30;
    /*public void show() {
        System.out.println(a);//等价于this.a 优先调用自身类的成员
        System.out.println(b);
        System.out.println(c);
        System.out.println(a);
        System.out.println(super.a);//要想调用父类的a就要加关键字 super
    }*/
   /* public void text() {
        System.out.println("子类的text方法");//同理就近原则，子类优先访问自身的方法
    }
    public void showtext() {
        text();
        super.text();//要想访问的是父类 加关键字super +点号
    }*/
}
public class demo2 {
    public static void main(String[] args) {
       Draver draver = new Draver(10,25,30);
       //draver.showtext();
    }
}
