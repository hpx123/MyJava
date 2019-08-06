package JDBC_Test;

import java.sql.*;

/**
 * 测试和数据库建立连接
 */
public class JDBC_Test01 {

    public static void main(String[] args) {

        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutu?serverTimezone=UTC", "root", "111111");

            String str = "insert into MyClass (usename,psw) values (?,?)";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, "胡程");//参数索引从一开始
            ps.setString(2,"123123");
            ps.executeUpdate();
//            Statement st = con.createStatement();
//            String name = "胡程";
//            String str = "insert into MyClass (usename,psw) values('"+name+"',6666)";
//            st.execute(str);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
