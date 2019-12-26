import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operate {
    //转班级的方法----------------------------------------------------------------------------------------
    public void transfer(int stu_no,int stu_cl){

        PreparedStatement pstmt = null;
        Connection conn = null;


        try {
            conn = JDBCUtils.getConnection();//获取链接；
            conn.setAutoCommit(false);//开启事务
            String sql = "update student set stu_cl = ? where stu_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,stu_cl);
            pstmt.setInt(2,stu_no);
            int count = pstmt.executeUpdate();
            conn.commit();//提交事务；

            if(count>0)
            {
                System.out.println("操作成功！");
                System.out.println("发生变化的记录数是："+count);
            }
            else
            {
                System.out.println("操作失败！");
            }
        } catch (Exception e) {
            if(conn != null) {
                try {
                    conn.rollback();//如果出现异常，回滚事务；
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);//释放资源；
        }


    }
    //退学的方法；----------------------------------------------------------------------------------
    public void drop(int stu_no){

        PreparedStatement pstmt = null;
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();//获取链接；
            conn.setAutoCommit(false);//开启事务；
            String sql = "delete from student where stu_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,stu_no);
            int count = pstmt.executeUpdate();
            conn.commit();//提交事务；
            if(count>0)
            {
                System.out.println("操作成功！");
                System.out.println("发生变化的记录数是："+count);
            }
            else
            {
                System.out.println("操作失败！");
            }
        } catch (Exception e) {
            if(conn != null) {
                try {
                    conn.rollback();//回滚事务；
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {

            JDBCUtils.close(pstmt,conn);//释放资源；
        }


    }
    //入学的方法；-------------------------------------------------------------------------------------
    public void enrol(int stu_no,String stu_name,int stu_cl){

        PreparedStatement pstmt = null;
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();//获取链接；
            conn.setAutoCommit(false);//开启事务；
            String sql = "insert into student(stu_no,stu_name,stu_cl) values (?,?,?) ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,stu_no);
            pstmt.setString(2,stu_name);
            pstmt.setInt(3,stu_cl);
            int count = pstmt.executeUpdate();
            conn.commit();//提交事务；
            if(count>0)
            {
                System.out.println("发生变化的记录数是："+count);
                System.out.println("操作成功！");
            }
            else
            {
                System.out.println("操作失败！");
            }
        } catch (Exception e) {
            if(conn != null) {
                try {
                    conn.rollback();//回滚事务；
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);//释放资源；
        }


    }
    //查询特定班级所有学生；---------------------------------------------------------------------
    public void find(int stu_cla) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        List<Student> list = null;
        try {
            conn = JDBCUtils.getConnection();//获取链接；
            String sql = "select * from student where stu_cl = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,stu_cla);
            rs = pstmt.executeQuery();
            Student stu = null;
            list = new ArrayList<Student>();
            while (rs.next())
            {
                int stu_no = rs.getInt("stu_no");
                String stu_name = rs.getString("stu_name");
                int stu_cl = rs.getInt("stu_cl");
                stu = new Student();
                stu.setStu_no(stu_no);
                stu.setStu_name(stu_name);
                stu.setStu_cl(stu_cl);
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);//释放资源；
        }
        System.out.println(list);
    }

    //查询所有Student对象；-------------------------------------------------------------------------------
    public void findAll() {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        List<Student> list = null;
        try {
            conn = JDBCUtils.getConnection();//获取链接；
            String sql = "select * from student";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Student stu = null;
            list = new ArrayList<Student>();
            while (rs.next())
            {
                int stu_no = rs.getInt("stu_no");
                String stu_name = rs.getString("stu_name");
                int stu_cl = rs.getInt("stu_cl");
                stu = new Student();
                stu.setStu_no(stu_no);
                stu.setStu_name(stu_name);
                stu.setStu_cl(stu_cl);
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);//释放资源；
        }
        System.out.println(list);
    }
}
