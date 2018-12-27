package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.MySQLDBCon;
import test.Zcinformation;

public class Login {
    private static Login instance = null;

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    // 保存用户注册信息
    public boolean saveUser(Zcinformation user) {
        Connection conn = null;
        try {
            conn = MySQLDBCon.getCon(); // 建立数据库连接
            String sql = "insert into area(username,password,email,sex) values(?,?,?,?)"; // insert
                                                                                                            // SQL语句=
            PreparedStatement pstmt = conn.prepareStatement(sql); // 创建用户操作执行SQL语句的PreparedStatement对象
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserSex());

            pstmt.executeUpdate(); // 编译执行insert语句
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
