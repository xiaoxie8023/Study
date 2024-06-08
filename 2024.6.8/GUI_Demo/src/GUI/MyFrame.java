package GUI;

import javax.swing.*;

/**
 * program: GUI_Demo
 * <p>
 * description:
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-06-08 13:29
 **/
public class MyFrame extends JFrame {
    JFrame jFrame = new JFrame();
       MyFrame() {
           this.jFrame.setTitle("Text Demo");//标题
           this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭形式
           this.jFrame.setSize(420, 420);//宽和高
           this.jFrame.setResizable(false);
           this.jFrame.setVisible(true);//显示
           ImageIcon image = new ImageIcon("logo.png");
           this.jFrame.setIconImage(image.getImage());
       }

}
