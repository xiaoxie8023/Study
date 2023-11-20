package demo2接口;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-11
 * Time: 17:06
 */
//空接口/标记接口
 class Student implements Comparable<Student> {
    public String name;
    public int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
       /* return this.name.compareTo(o.name);*/
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
//比较器
class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age-o2.age;
    }
}class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class text {
    public static void mySort(Comparable[] comparables) {

        for (int i = 0; i < comparables.length-1; i++) {
            for (int j = 0; j < comparables.length-1-i; j++) {
                //if(comparables[j] > comparables[j+1]) {
                if(comparables[j].compareTo(comparables[j+1]) > 0) {
                    //交换
                    Comparable tmp = comparables[j];
                    comparables[j] = comparables[j+1];
                    comparables[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student("zhansan",10);
        Student student2 = new Student("lisi",15);
        if(student1.compareTo(student2) > 0) {
            System.out.println("student1 > student2");
        }else {
            System.out.println("student1 <= student2");
        }
        System.out.println("-----------------------------");

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));
        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(student1, student2));

        System.out.println("-----------------------------");
        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",28);
        students[1] = new Student("lisi",31);
        students[2] = new Student("abc",5);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("-----------------------------");
        AgeComparator ageComparator1 = new AgeComparator();
        Arrays.sort(students,ageComparator1);//穿比较器
        System.out.println(Arrays.toString(students));

        System.out.println("-----------------------------");
        NameComparator nameComparator1 = new NameComparator();
        Arrays.sort(students,nameComparator1);
        System.out.println(Arrays.toString(students));

        System.out.println("-----------------------------");
        mySort(students);
        System.out.println(Arrays.toString(students));


    }
}
