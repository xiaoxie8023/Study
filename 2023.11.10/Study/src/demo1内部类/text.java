package demo1内部类;

/**
 * Created with IntelliJ IDEA.
 * Description:实例内部类
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 16:05
 */
//实例内部类
 class Outclass {
    private int date1 = 1;
    public int date2 = 2;
    public static int date3 = 3;
    public void func() {
       /* innerclass innerclass = new innerclass();
        innerclass.func2();*/
    }
    public class innerclass{
        public int date1 = 999;//优先访问自己的
        private int date4 = 4;
        public int date5 = 5;
        public static final int date6 = 6;//在实例化内部类不可以有静态成员除非加final
        public void func2() {
            System.out.println(Outclass.this.date1);//如何访问外部的date1呢 + Outclass.this.
            System.out.println(date1);
            System.out.println(date2);
            System.out.println(date3);
            System.out.println(date4);
            System.out.println(date5);
            System.out.println(date6);
        }
    }


}
public class text {
    public static void main(String[] args) {

    }
    public static void main1(String[] args) {
        /*Outclass outclass = new Outclass();
        outclass.func();//实例化内部方法*/
        Outclass.innerclass innerclass = new Outclass().new innerclass();
        innerclass.func2();
        //才可以在类外创建实例化对象
    }
}