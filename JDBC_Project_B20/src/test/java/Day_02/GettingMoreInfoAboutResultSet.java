package Day_02;

import java.sql.*;

public class GettingMoreInfoAboutResultSet {
    public static void main(String[] args) throws SQLException {
        String ConnectionStr="jdbc:oracle:thin:@18.210.18.44:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn= DriverManager.getConnection(ConnectionStr,username,password);

        Statement stmnt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs=stmnt.executeQuery("SELECT * from JOBS");

        // ResultSetMetaDate -- data about the ResultSet object that contain our resulting rows and columns
        // For example column names, column count .. and more
        // This is how we get the ResultSetMetaData object

        ResultSetMetaData resultSetMetaData= rs.getMetaData();

        resultSetMetaData.getColumnCount();

        // Get first column name
        System.out.println("First Column Name is "+resultSetMetaData.getColumnLabel(1));
        System.out.println("Second Column Name is "+resultSetMetaData.getColumnLabel(2));

        // Print all the columns name

        for (int i = 1; i <resultSetMetaData.getColumnCount()+1 ; i++) {

            System.out.println("Column name is "+resultSetMetaData.getColumnLabel(i));

        }
        rs.close();
        stmnt.close();
        conn.close();
    }
}
