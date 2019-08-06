package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StuDao {
    //判断学生用户账户密码
    public static boolean stujudge(String user, String pwd){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select stuname,stupwd from Stu");
            rs = ps.executeQuery();
            while(rs.next()) {
                if(rs.getObject(1).equals(user) && rs.getObject(2).equals(pwd)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
}
