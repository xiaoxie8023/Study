package demo1内部类;

/**
 * Created with IntelliJ IDEA.
 * Description:匿名内部类
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 16:55
 */
interface  Interface {
    void func();
}
class textA implements Interface {
    @Override
    public void func() {
        System.out.println("textA的重写方法");
    }
}
public class text4 {
    public static void main(String[] args) {
       /* textA textA = new textA();
        textA.func();*/
        //这一部分可以看做一个类 实现了一个接口，重写了它当中的方法
        new Interface() {
            @Override
            public void func() {
                System.out.println("hhahaahha");
            }
        }.func();

    }
}
