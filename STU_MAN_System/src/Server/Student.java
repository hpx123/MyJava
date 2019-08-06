package Server;

import Dao.JDBCUtil;
import Dao.ScanPWD;
import Dao.StuDao;
import Screen.Stu_Screen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
    //注册
    public static void register(){
        ScanPWD scanPWD = new ScanPWD();
        String name = scanPWD.scanID();
        String pwd = scanPWD.scanPWD();
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into Stu (stuname,stupwd) values (?,?)");
            ps.setObject(1,name);
            ps.setObject(2,pwd);
            ps.executeUpdate();
            System.out.println("注册成功");
        } catch (SQLException e) {
            System.out.println("注册失败");
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,ps,conn);
        }
    }
    //登陆
    public static void login(){
        Stu_Screen stu_screen = new Stu_Screen();
        ScanPWD scanPWD = new ScanPWD();
        String name = scanPWD.scanID();
        String pwd = scanPWD.scanPWD();
        if(StuDao.stujudge(name,pwd))
        {
            System.out.println("登陆成功");
            stu_screen.success();

        }else {
            System.out.println("登录失败");
        }
    }
}
