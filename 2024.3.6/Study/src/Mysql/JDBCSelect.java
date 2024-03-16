package Mysql;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-16
 * Time: 16:52
 */

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/** * @author xiaoxie
 * @date 2024年03月16日 16:52
 */
public class JDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/sqlstudy?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("010920");
        Connection connection = dataSource.getConnection();
        String sql = "select * from text where id = 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
       ResultSet resultSet =  preparedStatement.executeQuery();
       while (resultSet.next()) {
           System.out.print("id="+resultSet.getInt(1));
           System.out.println(",name="+resultSet.getString(2));
       }
       resultSet.close();
       preparedStatement.close();
       connection.close();
    }
}
