package Work;

/**
 * program: 2024.5.9
 * description: 麦克风类
 * author: xiaoxie
 * create: 2024-05-30 10:42
 **/
public class Mic implements USB {
    @Override
    public void turnOn() {
        System.out.println("麦克风已启动");
    }

    @Override
    public void turnOff() {
        System.out.println("麦克风已关闭");
    }
}
