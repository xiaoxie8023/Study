package demo2接口;

/**
 * Created with IntelliJ IDEA.
 * Description:接口和继承的区别
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:31
 */
//1.接口的成员变量是由 public static final 修饰的 成员方法是由 public abstract 修饰的
//2.Java中只能继承一个类 却可以实现多个接口
public class Text {
    public static void func(Animal animal) {
        animal.eat();
    }
    public static void func2(IRun iRun) {
        iRun.Run();
    }
    public static void func3(IFly iFly) {
        iFly.fly();
    }
    public static void func4(ISwim iSwim) {
        iSwim.Swim();
    }


    public static void main(String[] args) {
     func(new Dog("旺财"));
     func(new Bird("波哥"));
     func(new Duck("特洛伊"));
     func(new Frog("王子"));
     System.out.println("------------------");
     func2(new Dog("旺财"));
     func2(new Bird("波哥"));
     func2(new Duck("特洛伊"));
     func2(new Frog("王子"));
     System.out.println("------------------");
     func3(new Bird("波哥"));
     func3(new Duck("特洛伊"));
     System.out.println("------------------");
     func4(new Dog("旺财"));
     func4(new Duck("特洛伊"));
     func4(new Frog("王子"));
    }
}
