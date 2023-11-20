package demo1.zhuhe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-07
 * Time: 16:53
 */
class Teacher {
    public String name;
    public int age;
    public char sex;
}
class Student {
    public String name;
    public int age;
    public char sex;
}
class School {
   /* private Teacher teacher;//组合就是说明一所学院由多名学生和老师组成的
    private Student student;//所以要先实例化对象*/
    //或者还可以用数组的形式来表达
    private Teacher[] teachers;//可以复用Teacher 的属性和方法
    private Student[] students;
}
public class text {
}
