package JDBC_Test;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static Properties pros = null;//读取处理资源文件中的信息

    static {
        //加载JDBCUtil类的时候，只被调用一次
        pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取connection连接
    public static Connection getMysqlConn(){
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("mysqlURL"), pros.getProperty("mysqlUser"), pros.getProperty("mysqlPWD"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //关闭
    public static void close(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(st != null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
