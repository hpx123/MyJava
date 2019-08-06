package Dao;


import Dao.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpDate {


    public static void updateID(String name){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        int count = 0;
        String str = null;
        try {
            ps = conn.prepareStatement("select StuName from StuInfo");
            rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getObject(1).equals(name)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("没有该学生信息！");
            }else {
                System.out.println("1.修改年龄");
                System.out.println("2.修改成绩");
                Scanner a = new Scanner(System.in);
                int num = a.nextInt();
                if(num == 1){
                    str = "update StuInfo set StuAge=? where StuName=?";
                    System.out.println("年龄改为：");
                }
                else if(num == 2){
                    str = "update StuInfo set StuGrade=? where StuName=?";
                    System.out.println("成绩改为");
                }
                Scanner b = new Scanner(System.in);
                int t = b.nextInt();
                ps = conn.prepareStatement(str);
                ps.setObject(1,t);
                ps.setObject(2,name);
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
