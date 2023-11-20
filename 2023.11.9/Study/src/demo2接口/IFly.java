package demo2接口;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:14
 */
public interface IFly {
    void fly();//默认为 public abstract 也只能为这个;
   /* *//*default*//*  static void text() {
        System.out.println();
    }*///要想具体实现必须加上关键字 default 或者 static
}
