package Mysql;/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 谢忠涵7
 * Date: 2024-03-14
 * Time: 21:09
 */

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

/** * @author xiaoxie
 * @date 2024年03月14日 21:09
 */
public class JDBC {
    public static void main(String[] args) {
        DataSource datasource = new MysqlDataSource();
        //jdbc:mysql://127.0.0.1:3306/java111?characterEncoding=utf8&useSSL=false
        ((MysqlDataSource) datasource).setURL("jdbc:mysql://127.0.0.1:3306/sqlstudy?characterEncoding=utf8&useSSL=false");

    }
}
