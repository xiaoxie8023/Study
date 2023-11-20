package demo3多态;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2023-11-08
 * Time: 22:28
 */
class Sharp {
    public void Draw() {
        System.out.println("打印图像!");
    }
}
class Round extends Sharp {
    @Override
    public void Draw() {
        System.out.println("⚪");
    }
}
class Rectangle extends Sharp {
    @Override
    public void Draw() {
        System.out.println("矩形");
    }
}
class Triangle extends Sharp {
    @Override
    public void Draw() {
        System.out.println("🔺");
    }
}
class Flower extends Sharp {
    @Override
    public void Draw() {
        System.out.println("❀");
    }
}
public class Text {
    public static void Drawshow(Sharp sharp) {
        sharp.Draw();
    }

    public static void main(String[] args) {
        /*Sharp sharp1= new Round();
        Sharp sharp2 = new Rectangle();
        Sharp sharp3 = new Triangle();
        Sharp sharp4 = new Flower();
        Drawshow(sharp1);
        Drawshow(sharp2);
        Drawshow(sharp3);
        Drawshow(sharp4);*/
        Round round = new Round();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Flower flower = new Flower();
        Sharp[]sharps = {round, flower,round,round,triangle,triangle, rectangle,flower ,flower ,flower };
        for (Sharp sharp:sharps) {
            sharp.Draw();
        }
    }
}
