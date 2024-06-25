/**
 * program: java _work4
 * <p>
 * description: 职工数据库操作
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-06-15 22:42
 **/
import java.sql.*;

public class EmployeeDBExample {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/text";
    static final String USER = "root";
    static final String PASS = "010920";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {

            // 注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("数据库连接.");
            stmt = conn.createStatement();
            // 查询所有职工信息
            String selectSQL = "SELECT * FROM 职工";
            ResultSet rs = stmt.executeQuery(selectSQL);
            System.out.println("插入数据后的,所有职工信息:");
            while (rs.next()) {
                // 通过字段检索数据并打印
                System.out.println(rs.getInt("编号") + " " + rs.getString("姓名") + " "
                        + rs.getString("性别") + " " + rs.getInt("年龄") + " "
                        + rs.getBigDecimal("工资") + " " + rs.getString("职称"));
            }

            // 更新工资
            String updateSQL = "UPDATE 职工 SET 工资 = CASE"
                    + " WHEN 年龄 > 45 THEN 工资 * 1.15"
                    + " ELSE 工资 * 1.10"
                    + " END";
            stmt.executeUpdate(updateSQL);

            // 再次查询所有职工信息
            System.out.println("更新数据后的,所有职工信息:");
            rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(rs.getString("编号") + " " + rs.getString("姓名") + " "
                        + rs.getString("性别") + " " + rs.getInt("年龄") + " "
                        + rs.getBigDecimal("工资") + " " + rs.getString("职称"));
            }

            // 删除工资超过1500的员工记录
            String deleteSQL = "DELETE FROM 职工 WHERE 工资 > 1500";
            stmt.executeUpdate(deleteSQL);
            System.out.println("删除数据后的,所有职工信息:");
            // 按工资由大到小的顺序显示剩余员工记录
            String selectOrderBySQL = "SELECT * FROM 职工 ORDER BY 工资 DESC";
            rs = stmt.executeQuery(selectOrderBySQL);
            while (rs.next()) {
                System.out.println(rs.getString("编号") + " " + rs.getString("姓名") + " "
                        + rs.getString("性别") + " " + rs.getInt("年龄") + " "
                        + rs.getBigDecimal("工资") + " " + rs.getString("职称"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}