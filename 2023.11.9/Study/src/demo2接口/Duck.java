package demo2接口;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:27
 */
public class Duck extends Animal implements ITriphibianAnimals {
    public Duck(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(this.name + "正在吃鸭粮....");
    }

    @Override
    public void fly() {
        System.out.println(this.name + "用翅膀在飞.....");
    }

    @Override
    public void Run() {
        System.out.println(this.name + "用两条腿在跑.....");
    }

    @Override
    public void Swim() {
        System.out.println(this.name + "用两条腿在游泳.....");
    }
}
