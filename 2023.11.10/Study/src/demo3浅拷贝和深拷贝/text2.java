package demo3浅拷贝和深拷贝;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 22:11
 */
class Money1 implements Cloneable {
    public double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Student implements Cloneable {
    public String name;
    public Money1 m1;
    public Student(String name) {
        this.name = name;
        m1 = new Money1();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student temp = (Student) super.clone();
        temp.m1 = (Money1) temp.m1.clone();
        return temp;
    }
}
public class text2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student("李四");
        Student student2 = (Student) student1.clone();//向下转型
        System.out.println(student2.name);
        System.out.println(student1.m1.money);
        System.out.println(student2.m1.money);
        student2.m1.money = 99.99;
        System.out.println(student1.m1.money);
        System.out.println(student2.m1.money);
    }
        }
