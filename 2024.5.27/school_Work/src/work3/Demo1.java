package work3;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-28
 * Time: 10:33
 */

/** * @author xiaoxie
 * @date 2024年05月28日 10:33
 */
public class Demo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名称：" + this.getName() + " 当前循环次数：" + (i + 1));
        }
    }

    public static void main(String[] args) {
        Demo1 spiderMan = new Demo1();
        spiderMan.setName("蜘蛛侠");
        Demo1 ironMan = new Demo1();
        ironMan.setName("钢铁侠");
        spiderMan.start();
        ironMan.start();
    }
}