package Day_01;

import java.sql.*;

public class MovingResultPointer {
    public static void main(String[] args) throws SQLException {
        /*
        we wanna create a statement object that generate
        result-set that can go forward and backward
         */
        String connectionStr = "jdbc:oracle:thin:@18.210.18.44:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
/*
this way of creating statement will give you ability to generate result-set that can move forward and backward at any time
 */
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM regions");

//        while(rs.next()){
//            System.out.print("Region_Name "+ rs.getString(1)+"\t");
//            System.out.println("Region_Name "+ rs.getString(2));
//        }

        while(rs.next()){
            System.out.println("Region_Name "+ rs.getString("region_name"));
            System.out.println("Region_Name "+ rs.getString(1));

        }
        while(rs.previous()){
            System.out.println("BackWard Region_Name "+ rs.getString("REGION_NAME"));
        }

        rs.next();
//        int currentRow=rs.getRow();
        System.out.println(rs.getRow());


    }
}
