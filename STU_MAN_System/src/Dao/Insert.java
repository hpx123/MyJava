package Dao;

import Dao.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
    public static void insert(int StuID,String StuName,int StuGrade,int StuAge){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("insert into StuInfo (StuID,StuName,StuGrade,StuAge) values (?,?,?,?)");
            ps.setObject(1,StuID);
            ps.setObject(2,StuName);
            ps.setObject(3,StuGrade);
            ps.setObject(4,StuAge);
            ps.executeUpdate();
            System.out.println("增加成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
}
