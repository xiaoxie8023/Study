package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-13
 * Time: 19:47
 */

/** 饿汉模式
 * * @author xiaoxie
 * @date 2024年04月13日 19:47
 */
class Singleton {
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
    private Singleton() {

    }
}
public class Demo6 {
    public static void main(String[] args) {

    }
}
