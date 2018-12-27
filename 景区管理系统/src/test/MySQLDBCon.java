package test;

import java.sql.Connection;
import java.sql.DriverManager;
//连接数据库代码块
public class MySQLDBCon {
    private static Connection conn = null;

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pwd = "root";
            String url = "jdbc:mysql://localhost:3306/test";
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
