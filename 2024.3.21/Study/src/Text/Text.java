package Text;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-24
 * Time: 22:44
 */

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/** * @author xiaoxie
 * @date 2024年03月24日 22:44
 */
public class Text {
   /* public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/text?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");
        Connection connection = dataSource.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号: ");
        int id = scanner.nextInt();
        System.out.println("请输入姓名: ");
        String name = scanner.next();
        System.out.println("请输入年龄: ");
        int age = scanner.nextInt();
        String sql = "insert into students values(?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);
        preparedStatement.close();
        connection.close();
    }*/
   public static void main(String[] args) throws SQLException {
       DataSource dataSource = new MysqlDataSource();
       ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/text?characterEncoding=utf8&useSSL=false");
       ((MysqlDataSource) dataSource).setUser("root");
       ((MysqlDataSource) dataSource).setPassword("010920");
       Connection connection = dataSource.getConnection();
       Scanner scanner = new Scanner(System.in);
       System.out.println("请输入要查询的学生姓名: ");
       String name = scanner.next();

       String sql = "select * from students where name = ?";
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setString(1, name);

       ResultSet resultSet = preparedStatement.executeQuery();

       while(resultSet.next()) {
           int id = resultSet.getInt("id");
           String studentName = resultSet.getString("name");
           int age = resultSet.getInt("age");
           System.out.println("学号: " + id + ", 姓名: " + studentName + ", 年龄: " + age);
       }

       preparedStatement.close();
       connection.close();
   }

}