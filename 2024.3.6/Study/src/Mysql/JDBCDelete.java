package Mysql;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-16
 * Time: 16:47
 */

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** * @author xiaoxie
 * @date 2024年03月16日 16:47
 */
public class JDBCDelete {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/sqlstudy?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("010920");
        Connection connection = dataSource.getConnection();
        String sql = "delete from text where id = 67 ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int n = preparedStatement.executeUpdate();
        System.out.println("n=" + n);
        preparedStatement.close();
        connection.close();
    }
}
