package view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import databases.Landing;

/** 管理员和普通用户界面
 * Description:
 * Param: * @param null
 * return: 选项卡     主界面       图书查询          图书借还       账号管理
 * Author: xiaoxie
 * Date: 14:59 2024/6/11
*/
public class MainInterface extends JFrame{
    //选项卡
    public  JTabbedPane jTabbedPane = new JTabbedPane();
    //主界面面板
    private JPanel jPanel = new JPanel();
    //标签
    private JLabel jLabel = new JLabel("欢迎登陆图书管理系统");
    // 字体
    private Font font = new Font("宋体", Font.BOLD, 70);
    private Font font2 = new Font("宋体", Font.BOLD, 20);

    private Container con = getContentPane();
    public MainInterface(String user) {

        // 改变窗口图标
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage("img\\top.jpg");
        setIconImage(image);

        // 改变背景图片
        Icon i = new ImageIcon("img\\Main.jpg");
        JLabel Label = new JLabel(i);
        Label.setBounds(0, 0, 1200, 800);
        jPanel.setLayout(null);
        jLabel.setFont(font);

        jLabel.setBounds(230, 50, 1000,200);
        jLabel.setForeground(Color.yellow);
        jPanel.add(jLabel);
        jPanel.add(Label);


         //管理员和普通用户的通用界面
        jTabbedPane.setFont(font2);
        jTabbedPane.add("主 界 面", jPanel);
        BookSearch search = new BookSearch();
        jTabbedPane.add("图书查询",search.jLayeredPane);

        BorrowingReturning returning = new BorrowingReturning();
        returning.setUser(user);
        returning.setModel(search.model);
        jTabbedPane.add("图书借还", returning.jLayeredPane);
        //根据角色的不同展示不同的界面
        if(Landing.sureadmin(user)) {
            //管理员
            Admin admin = new Admin();
            admin.setUser(user);
            admin.setFrame(this);
            jTabbedPane.add("账户管理", admin.jPanel2);

            BookAdmin bookAdmin = new BookAdmin();
            bookAdmin.setModel(search.model);
            jTabbedPane.add("图书管理",bookAdmin.jPanel2);

        }else {
            //普通用户
            AccountManagement management = new AccountManagement();
            management.setUser(user);
            management.setFrame(this);
            jTabbedPane.add("账户管理", management.jPanel2);
        }



        con.add(jTabbedPane);
        // 不可以改变窗体的大小
        setResizable(false);
        setTitle("图书管理系统");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}