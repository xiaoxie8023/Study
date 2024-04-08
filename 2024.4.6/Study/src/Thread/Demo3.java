package Thread;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-04-07
 * Time: 11:28
 */

/**
 * @author xiaoxie
 * @date 2024年04月07日 11:28
 */
public class Demo3 {
    // 定义两种资源对象
    static class Resource {
        private String name;

        public Resource(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Resource: " + name;
        }
    }

    public static void main (String[]args){
        // 创建资源R1和R2
        Resource r1 = new Resource("R1");
        Resource r2 = new Resource("R2");

        // 创建线程A和线程B
        Thread threadA = new Thread(() -> {
            synchronized (r1) {
                System.out.println(Thread.currentThread().getName() + " 获取 " + r1);
                synchronized (r2) {
                    System.out.println(Thread.currentThread().getName() + " 获取 " + r2);
                }
            }
        }, "线程A");

        Thread threadB = new Thread(() -> {
            synchronized (r2) {
                System.out.println(Thread.currentThread().getName() + " 获取 " + r2);
                synchronized (r1) {
                    System.out.println(Thread.currentThread().getName() + " 获取 " + r1);
                }
            }
        }, "线程B");

        // 启动线程
        threadA.start();
        threadB.start();
    }
}
