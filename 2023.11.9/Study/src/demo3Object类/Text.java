package demo3Object类;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:object 是所有类的父类 所以可以重写object里的方法
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:50
 */
public class Text {
    public static void main(String[] args) {
        Person person = new Person("zhangshan");
        Person person2 = new Person("zhangshan");
        System.out.println(person.equals(person2));
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());

    }

}
