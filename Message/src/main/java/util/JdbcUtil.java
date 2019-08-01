package util;

import java.sql.*;

public class JdbcUtil {
    private static String driver ="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/internship?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String usr="root";
    private static String pwd="123456";
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,usr,pwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("加载数据库驱动程序失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
