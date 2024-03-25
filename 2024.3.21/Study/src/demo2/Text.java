package demo2;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-22
 * Time: 8:52
 */

/** * @author xiaoxie
 * @date 2024年03月22日 8:52
 */
 class Person {
    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public void printMessage() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Sex: " + sex);
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 130) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age should be between 0 and 130.");
        }
    }

    public int getAge() {
        return age;
    }
}
public class Text {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25, "Female");
        Person person2 = new Person("Bob", 30, "Male");
        person1.printMessage();
        person2.printMessage();
    }
}
