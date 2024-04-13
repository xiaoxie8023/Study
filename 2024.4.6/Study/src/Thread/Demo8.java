package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-13
 * Time: 22:34
 */

/** * @author xiaoxie
 * @date 2024年04月13日 22:34
 */
class Factory {
    int a;
    int b;
    public static Factory fun1(int a,int b) {
        Factory factory = new Factory();
        factory.set1(a);
        factory.set2(b);
        return factory;
    }
    public static Factory fun2(int x,int y) {
        Factory factory = new Factory();
        factory.set1(x);
        factory.set2(y);
        return factory;
    }

    public void set1(int a) {
        this.a = a;
    }

    public void set2(int b) {
        this.b = b;
    }
}
public class Demo8 {
}
