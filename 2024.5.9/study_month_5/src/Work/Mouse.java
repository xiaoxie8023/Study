package Work;

/**
 * program: 2024.5.9
 * description: 鼠标类
 * author: xiaoxie
 * create: 2024-05-30 10:40
 **/
public class Mouse implements USB {
    @Override
    public void turnOn() {
        System.out.println("鼠标已启动");
    }

    @Override
    public void turnOff() {
        System.out.println("鼠标已关闭");
    }
}