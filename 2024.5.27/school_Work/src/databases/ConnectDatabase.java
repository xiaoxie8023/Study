package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDatabase {
    public static Connection connectDB() {
        String url = "jdbc:mysql://localhost:3306/mis?serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
        try {
            // 对于MySQL 8，使用新的驱动程序类名
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            // 如果您的MySQL 8服务器配置了不同的用户名或密码，请更改此处
            con = DriverManager.getConnection(url, "root", "010920");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}