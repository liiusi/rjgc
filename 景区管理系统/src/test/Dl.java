
package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.MySQLDBCon;
import test.Dlinformation;

public class Dl {
    private static Dl instance = null;

    public static Dl getInstance() {
        if (instance == null) {
            instance = new Dl();
        }
        return instance;
    }

    // 保存用户注册信息
    public boolean equals(Dlinformation user) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String username;
        String password;
        try {
            conn = MySQLDBCon.getCon(); // 建立数据库连接
            String sql = "select * from area where username=?"+"and password=?"; // SELECT
            ResultSet resultset=null;
            username=user.getUsername();
            password=user.getPassword();
            preparedStatement = conn.prepareStatement(sql); // 创建用户操作执行SQL语句的PreparedStatement对象
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
            resultset = preparedStatement.executeQuery();
            if(resultset.next()) {
            	return true;
            }else {
            	return false;
            }
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
