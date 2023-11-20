package demo2接口;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-09
 * Time: 22:16
 */
public class Dog extends Animal implements IRun,ISwim {

    public Dog(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(this.name + "正在吃狗粮....");
    }

    @Override
    public void Run() {
        System.out.println(this.name + "用四条腿在跑.....");
    }

    @Override
    public void Swim() {
        System.out.println(this.name+"用四条腿在游泳.....");
    }
}
