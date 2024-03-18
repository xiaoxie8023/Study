package Mysql;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-14
 * Time: 21:09
 */

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/** 插入操作
 * * @author xiaoxie
 * @date 2024年03月14日 21:09
 */
public class JDBCInsert {
    public static void main(String[] args) throws SQLException {
        //准备工作
        DataSource datasource = new MysqlDataSource();
        //jdbc:mysql://127.0.0.1:3306/java111?characterEncoding=utf8&useSSL=false
        ((MysqlDataSource) datasource).setURL("jdbc:mysql://127.0.0.1:3306/sqlstudy?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) datasource).setUser("root");
        ((MysqlDataSource) datasource).setPassword("010920");
        //建立连接
        Connection connection = datasource.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要插入的id");
        int id = scanner.nextInt();
        System.out.println("请输入你要插入的名字");
        String name = scanner.next();
        String sql = "insert into text values(?,?)";
        //注入语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        //开始运行
        int n = preparedStatement.executeUpdate();
        System.out.println("n="+n);
        preparedStatement.close();
        connection.close();
    }
}
