package MyGUI;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-05-22
 * Time: 22:15
 */

/** * @author xiaoxie
 * @date 2024年05月22日 22:15
 */
import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("跑酷游戏");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel()); // 添加游戏面板
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}