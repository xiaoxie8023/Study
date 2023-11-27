package demo1_力扣刷题;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-27
 * Time: 21:22
 */

/** * @author xiaoxie
 * @date 2023年11月27日 21:22
 */
public class Text1 {
    public static void main(String[] args) {
        MyArraylist m = new MyArraylist();
        m.add(1);
        m.add(2);
        m.add(5);
        m.add(6);
        System.out.println("顺序表新增元素测试");
        m.display();
        System.out.println("顺序表在pos位置新增元素测试");
        m.add(3,20);
        m.display();
        System.out.println("判断判定是否包含某个元素测试: "+m.contains(20));
        System.out.println("判断判定是否包含某个元素测试: "+m.contains(200));
        System.out.println("顺序表查找某个元素对应的位置测试");
        System.out.println(20+"在下标为"+ m.indexOf(20)+"位置");
        System.out.println("获取 pos 位置的元素测试");
        System.out.println(m.get(2));
        System.out.println("给 pos 位置的元素设为【更新为】 value测试");
        m.set(2,100);
        m.display();
        System.out.println("删除第一次出现的关键字key测试");
        m.remove(2);
        m.display();
        System.out.println("获取顺序表长度测试");
        System.out.println(m.size());
        System.out.println("清空顺序表测试");
        m.clear();
        m.display();




    }

}
