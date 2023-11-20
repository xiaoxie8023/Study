package demo1抽象类;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 21:56
 */
public class text {
    public static void func(Animal animal) {
        animal.eat();
    }

    public static void main(String[] args) {
        //Animal animal = new Animal();//不能实例化
         func(new Dog("旺财"));
    }
}
