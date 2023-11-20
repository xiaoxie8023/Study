package demo1内部类;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 16:47
 */

public class text3 {
    public void func() {
        System.out.println("text3::func");
    }
    public static void main(String[] args) {
        text3 text3 = new text3();
        text3.func();
        text3.func();//前两个只实例化了一个对象
        new text3().func();//匿名对象
        new text3().func();//匿名对象， 实例化了两个对象

    }
}
