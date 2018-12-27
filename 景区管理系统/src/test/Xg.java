package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import test.MySQLDBCon;
import test.Wjmm;


public class Xg {
	private static Xg instance = null;

    public static Xg getInstance() {
        if (instance == null) {
            instance = new Xg();
        }
        return instance;
    }

    public boolean equals(Wjmm user) {
        Connection conn = null;
        String email=user.getEmail();
        String passwd=user.getPasswd();
        String sql = "update area set password=? where email=?";
        try {
        	conn = MySQLDBCon.getCon();
        	PreparedStatement pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, passwd);
        	pstmt.setString(2, email);
        	pstmt.executeUpdate();
        	pstmt.close();
        	conn.close();
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
