package demo1内部类;

/**
 * Created with IntelliJ IDEA.
 * Description:静态内部类
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 16:29
 */
class Outclass1 {
    private  int date1 = 1;
    public  int date2 = 2;//静态内部类只能访问外部静态的成员变量
    public static int date3 = 3;
    public void func() {
        //也可以通过在外部类实例化 静态内部类
        innerclass2 innerclass2 = new innerclass2();
        innerclass2.func2();
    }
    public static class innerclass2{
        private  int date3 = 99;
        private int date4 = 4;
        public int date5 = 5;
        public static  int date6 = 6;
        public void func2() {
            Outclass1 outclass = new Outclass1();
            System.out.println(outclass.date1);//静态内部类要想访问外部类的非静态成员变量 要先实例化对象才可以访问
            System.out.println(outclass.date2);
            System.out.println(date3);
            System.out.println(outclass.date3);//
            System.out.println(date4);
            System.out.println(date5);
            System.out.println(date6);
        }
    }
}
public class text2 {
    public static void main(String[] args) {
        Outclass1.innerclass2 innerclass2 = new Outclass1.innerclass2();//实例化静态内部类
        innerclass2.func2();
        Outclass1 outclass1 = new Outclass1();
        outclass1.func();
    }
}
