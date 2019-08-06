package Dao;

import Dao.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

    public static  void select(String name){
        boolean flag = false;
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select StuID,StuName,StuGrade,StuAge from StuInfo");
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getObject(2).equals(name)){
                    System.out.println("学号:"+ rs.getObject("StuID"));
                    System.out.println("姓名："+rs.getObject("StuName"));
                    System.out.println("成绩："+rs.getObject("StuGrade"));
                    System.out.println("年龄："+rs.getObject("StuAge"));
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println("没有该学生信息");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
}
