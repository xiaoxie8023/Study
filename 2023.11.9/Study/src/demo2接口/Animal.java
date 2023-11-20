package demo2接口;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:12
 */
public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
}
