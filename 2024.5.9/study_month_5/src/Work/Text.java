package Work;

import javax.swing.*;

/**
 * @program: 2024.5.9
 * @description:
 * @author: xiaoxie
 * @create: 2024-05-29 20:01
 **/
public class Text {
    public static void main(String[] args) {
        //学生类和借书卡类的测试
        Student student = new Student("张三", "zhangsan@example.com");
        BorrowCard card = new BorrowCard(student);
        card.setBorrowedBooksCount(3);
        card.displayCardInfo();
        //usb接口的测试
        Computer computer = new Computer();

        Mouse mouse = new Mouse();
        KeyBoard keyboard = new KeyBoard();
        Mic mic = new Mic();

        computer.addUSB(mouse);
        computer.addUSB(keyboard);
        computer.addUSB(mic);

        computer.powerOn();
        // ... 使用计算机
        computer.powerOff();


    }
}
