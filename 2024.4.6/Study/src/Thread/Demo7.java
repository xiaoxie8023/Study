package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-13
 * Time: 20:10
 */

/** 懒汉模式
 * * @author xiaoxie
 * @date 2024年04月13日 20:10
 */
class SingletonLazy {
    private static volatile SingletonLazy instance = null;

    public static SingletonLazy getInstance() {
        if(instance == null) {
            synchronized (SingletonLazy.class) {
                if(instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    private SingletonLazy() {

    }
}
public class Demo7 {

}
