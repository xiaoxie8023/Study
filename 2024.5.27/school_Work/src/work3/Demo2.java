package work3;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-28
 * Time: 10:36
 */

/** * @author xiaoxie
 * @date 2024年05月28日 10:36
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + " 当前循环次数：" + (i + 1));
        }
    }

    public static void main(String[] args) {
        Demo2 demoTask = new Demo2();
        Thread spiderMan = new Thread(demoTask);
        spiderMan.setName("蜘蛛侠");
        Thread ironMan = new Thread(demoTask);
        ironMan.setName("钢铁侠");
        spiderMan.start();
        ironMan.start();
    }
}
