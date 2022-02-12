package Day_01;

import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@18.210.18.44:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt = conn.createStatement();

        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        rs.next();


        while(rs.next()){
            System.out.println("Region_ID "+rs.getString("Region_ID"));
            System.out.println("Region_ID "+rs.getString("Region_Name"));
        }

        // Iterate all countries

        rs= stmnt.executeQuery("Select * from countries");
        rs.next();
        System.out.println(rs.getString(1));

      while(rs.next()){
          System.out.print( rs.getString(1)+"\t");
          System.out.print( rs.getString(2)+"\t");
          System.out.println(rs.getString(3));
      }


    }
}
