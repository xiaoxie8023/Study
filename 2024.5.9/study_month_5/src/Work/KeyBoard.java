package Work;

/**
 * program: 2024.5.9
 * description: 键盘类
 * author: xiaoxie
 * create: 2024-05-30 10:41
 **/
public class KeyBoard implements USB {
    @Override
    public void turnOn() {
        System.out.println("键盘已启动");
    }

    @Override
    public void turnOff() {
        System.out.println("键盘已关闭");
    }
}
