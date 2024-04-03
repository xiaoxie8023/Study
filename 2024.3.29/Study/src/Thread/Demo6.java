package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-02
 * Time: 12:53
 */

/** 懒汉模式* @author xiaoxie
 * @date 2024年04月02日 12:53
 */
class SingletonLazy {
    private static volatile SingletonLazy instance = null;

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                   instance = new SingletonLazy();
                    return instance;
                }
            }
        }
        return instance;
    }
    private SingletonLazy(){

    }
}
public class Demo6 {
}
