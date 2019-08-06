package JDBC_Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Demo05 {

    public static void main(String[] args) {
        Connection con = JDBCUtil.getMysqlConn();
        PreparedStatement sp = null;
        ResultSet sr = null;
        List<Object[]> list = new ArrayList<Object[]>();
        int count = 0;

        try {
            sp = con.prepareStatement("select empName,salary,age from emp where id>=?");
            sp.setObject(1,1);
            sr = sp.executeQuery();
            while( sr.next() ){

                Object[] obj = new Object[3];//一个object数组封装了一条记录信息
                obj[0] = sr.getString(1);
                obj[1] = sr.getObject(2);
                obj[2] = sr.getObject(3);
                System.out.println(obj[0] + "---" + obj[1] + "---" + obj[2]);

                list.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close( sr, sp, con);
        }

//        for(Object[] objects: list){
//            System.out.println(objects[0] + "---" + objects[1] + "---" + objects[2]);
//        }

    }
}
