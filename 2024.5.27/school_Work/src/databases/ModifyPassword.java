
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/** 修改密码
 * Description:
 * Param: * @param null
 * return:
 * Author: xiaoxie
 * Date: 15:21 2024/6/11
*/
public class ModifyPassword {
    public ModifyPassword() {
    }
    public static void modifypass(String user,String password) {
        Connection con = ConnectDatabase.connectDB();

        PreparedStatement preSql;

        String sqlStr = "update usertable set password=? where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, password);
            preSql.setString(2, user);
            int ok = preSql.executeUpdate();

            con.close();
        } catch (SQLException e) {
        }
    }
}
