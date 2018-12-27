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

    // �����û�ע����Ϣ
    public boolean saveUser(Zcinformation user) {
        Connection conn = null;
        try {
            conn = MySQLDBCon.getCon(); // �������ݿ�����
            String sql = "insert into area(username,password,email,sex) values(?,?,?,?)"; // insert
                                                                                                            // SQL���=
            PreparedStatement pstmt = conn.prepareStatement(sql); // �����û�����ִ��SQL����PreparedStatement����
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserSex());

            pstmt.executeUpdate(); // ����ִ��insert���
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
