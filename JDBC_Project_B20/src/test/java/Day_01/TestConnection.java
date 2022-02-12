package Day_01;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@18.210.18.44:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt = conn.createStatement();

        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        rs.next();

        System.out.println("first column value using index: --> " +  rs.getString(1)   );

        System.out.println("first column value using index: --> " +  rs.getString(2)   );

        System.out.println("first column value using index: --> " +  rs.getString(3)   );

    }
}
