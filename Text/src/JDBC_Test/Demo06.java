package JDBC_Test;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo06 {

    public static void test(){
        Connection conn = JDBCUtil.getMysqlConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<Emp>();

        try {
            ps = conn.prepareStatement("select empName,salary,age from emp where id>=?");
            ps.setObject(1, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                Emp emp = new Emp(rs.getString("empName"),rs.getObject("salary"), rs.getObject("age"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Emp text:list){
            System.out.println(text.getempName()+""+text.getSalary() + "" + text.getAge());
        }

    }

    public static void main(String[] args) {
        test();
    }
}
