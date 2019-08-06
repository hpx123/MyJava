package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//判断管理员密码是否匹配
public class ManDao {
    public static boolean manJudge(String user, String pwd){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select username,pwd from Stu");
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
    //添加
    public static void Ainsert(){
        System.out.println("请输入学号：");
        Scanner f = new Scanner(System.in);
        int id = f.nextInt();
        System.out.println("请输入姓名：");
        Scanner g = new Scanner(System.in);
        String iname = g.nextLine();
        System.out.println("请输入成绩：");
        Scanner h = new Scanner(System.in);
        int igrade = h.nextInt();
        System.out.println("请输入年龄：");
        Scanner i = new Scanner(System.in);
        int iage = i.nextInt();
        Insert.insert(id,iname,igrade,iage);
    }

    //删除
    public static void Adelete(){
        System.out.println("请输入要删除的学生姓名：");
        Scanner j = new Scanner(System.in);
        String dname = j.nextLine();
        Delete.delete(dname);
    }

    //修改
    public static void Aupdate(){
        System.out.println("请输入要修改的学生姓名：");
        Scanner j = new Scanner(System.in);
        String dname = j.nextLine();
        UpDate.updateID(dname);
    }

    //查询学生信息
    public static void Aselect() {
        System.out.println("请输入学生姓名：");
        Scanner e = new Scanner(System.in);
        String fname = e.nextLine();
        while (true) {
            Select.select(fname);
            fname = e.nextLine();
            if (fname.equals("0")) {
                break;
            }
        }
    }
}
