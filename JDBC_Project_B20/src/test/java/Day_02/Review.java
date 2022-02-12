package Day_02;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class Review {
    public static void main(String[] args) throws SQLException {
        String ConnectionStr="jdbc:oracle:thin:@18.210.18.44:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn= DriverManager.getConnection(ConnectionStr,username,password);

        Statement stmnt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs=stmnt.executeQuery("SELECT * from JOBS");
        rs.next();
        System.out.println(rs.next());

        System.out.println("First column value in Jobs "+rs.getString(1));

        System.out.println("Second column value in Jobs "+rs.getString(2));

        System.out.println("================================================================");

       rs.absolute(7);
        System.out.println("First column value in Jobs in row 7 "+rs.getString(1));

        System.out.println("Second column value in Jobs in row 7 "+rs.getString(2));

       rs.beforeFirst();
        while(rs.next()){
           System.out.println("\nLoop First Column "+rs.getString("Job_id"));
       }

        rs.afterLast();
        while(rs.previous()){
            System.out.println("Min Salary Column As Number $"+rs.getDouble("Min_Salary"));
            System.out.println("Min Salary Column As Number $"+rs.getString("Min_Salary"));
        }
       // clean up the connection, statement and result  object after usage
       // Basically is close all resource you just used

       rs.close();
        stmnt.close();
        conn.close();
    }
}
