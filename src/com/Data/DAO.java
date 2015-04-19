package com.Data;

import java.sql.*;

/**
 * Created by Dodd on 2015/4/19.
 */

public class DAO {
    public Connection con;
    public PreparedStatement pstmt;
    String DBDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String ConnStr = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=OMG;user=sa;password=123456";
    ResultSet res;

    public DAO() throws SQLException, ClassNotFoundException {
        Class.forName(DBDriver);
        con = DriverManager.getConnection(ConnStr);
    }

    public void userReg(String username, String userphone, String usermail, int userage, String userps) throws SQLException {
        pstmt = con.prepareCall("{call User_Registration(?,?,?,?,?)}");
        pstmt.setString(1, username);
        pstmt.setString(2, userphone);
        pstmt.setString(3, usermail);
        pstmt.setInt(4, userage);
        pstmt.setString(5, userps);
        pstmt.executeQuery();
    }
}
