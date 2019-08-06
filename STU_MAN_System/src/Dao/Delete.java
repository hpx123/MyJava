package Dao;

import Dao.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {
    public static void delete(String name){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            boolean flag = false;
            ps = conn.prepareStatement("select StuName from StuInfo");
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getObject(1).equals(name)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("删除失败！");
            }else {
                ps = conn.prepareStatement("delete from StuInfo where StuName=?");
                ps.setString(1,name);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }

}
