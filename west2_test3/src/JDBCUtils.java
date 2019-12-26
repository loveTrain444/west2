import java.sql.*;

public class JDBCUtils {
    //获取连接的方法；
    public static Connection getConnection(){
        Connection conn = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///west2","root","zwj6212114");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
       //释放资源的方法；
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if( rs != null ){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( stmt != null ){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( conn != null ){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //方法重载；
    public static void close(Statement stmt, Connection conn){

        if( stmt != null ){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( conn != null ){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
