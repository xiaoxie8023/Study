package MyGUI;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-22
 * Time: 22:24
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

/** * @author xiaoxie
 * @date 2024年05月22日 22:24
 */
public class GamePanel extends JPanel {
    private Timer timer;//定时器
    private int playerX = 100;
    private int obstacleX = 200;

    public void move() {
        playerX += 5; // 角色向右移动
        obstacleX -= 5; // 障碍物向左移动

        // 检查碰撞
        if (playerX >= obstacleX) {
            // 碰撞发生，游戏结束
            //System.exit(0); // 简化示例：退出程序
        }

        repaint(); // 重绘画面
    }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 绘制背景
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            // 绘制角色
            g.setColor(Color.BLUE);
            g.fillRect(100, getHeight() - 50, 50, 10); // 角色是一个矩形
            // 绘制障碍物
            g.setColor(Color.RED);
            g.fillRect(200, 0, 50, 50); // 障碍物是一个矩形
        }
    public GamePanel() {
        timer = new Timer(20, e -> move()); // 每20毫秒移动一次
        timer.start();


    }
}
