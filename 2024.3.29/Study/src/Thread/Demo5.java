package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-02
 * Time: 12:47
 */

/** 单例模式的饿汉模式
 * * @author xiaoxie
 * @date 2024年04月02日 12:47
 */
class Singleton {
    //在主线程之前就已经创建了一个对象了
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
    private Singleton() {

    }
}
public class Demo5 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
