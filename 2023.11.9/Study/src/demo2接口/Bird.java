package demo2接口;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:20
 */
public class Bird  extends Animal implements IFly,IRun {

    public Bird(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(this.name + "正在吃鸟粮....");
    }

    @Override
    public void fly() {
        System.out.println(this.name + "用翅膀在飞.....");
    }

    @Override
    public void Run() {
        System.out.println(this.name + "用两条腿在跑.....");
    }
}
