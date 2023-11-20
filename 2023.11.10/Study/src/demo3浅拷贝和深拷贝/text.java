package demo3浅拷贝和深拷贝;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 21:56
 */
class Money implements Cloneable {
    public double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    public Money m;

    public Person(String name) {
        this.name = name;
        m = new Money();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person) super.clone();
        tmp.m = (Money) this.m.clone();
        return tmp;
    }
}
public class text {
    public static void main(String[] args)throws CloneNotSupportedException {
        Person person1 = new Person("张三");
        Person person2 = (Person) person1.clone();
        System.out.println(person2.name);
        System.out.println("修改之前："+person1.m.money);//12.5
        System.out.println("修改之前："+person2.m.money);//12.5
        person2.m.money = 99.99;
        System.out.println("修改之后："+person1.m.money);// 99.99
        System.out.println("修改之后："+person2.m.money);// 99.99

    }
}
