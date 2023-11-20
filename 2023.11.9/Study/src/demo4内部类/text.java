package demo4内部类;

/**
 * Created with IntelliJ IDEA.
 * Description:要想实现内部静态类的调用要用 A.B  =  new A.B
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:58
 */
class A {
  public int age;
  static class B {
      public int age;
  }
}
public class text {
    public static void main(String[] args) {
        A.B ab =new A.B();
        System.out.println(ab.age);
    }
}
