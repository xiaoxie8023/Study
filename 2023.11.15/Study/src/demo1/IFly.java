package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-15
 * Time: 16:02
 */
public interface IFly {
    //接口也可以创建成员变量
    //不过成员变量 默认的形式为 public static final
    //并且需要初始化 因为接口不能实例化对像
     String name = " ";
     //接口可以创建成员方法
    //成员方法被 public 修饰 也可以不写，并且没有方法实现
    //实现这个接口的类需要重写接口的这个方法
    public void work();
    //要写具体的方法实现 需要被 public static 所修饰
    public static void work1() {

    }
}
