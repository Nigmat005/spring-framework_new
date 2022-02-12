package Day_02;

import java.sql.*;

public class DisplayAllDataFromAllColumns {
    public static void main(String[] args) throws SQLException {
        String ConnectionStr="jdbc:oracle:thin:@18.210.18.44:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn= DriverManager.getConnection(ConnectionStr,username,password);

        Statement stmnt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs=stmnt.executeQuery("SELECT * from Employees");

        // ResultSetMetaDate -- data about the ResultSet object that contain our resulting rows and columns
        // For example column names, column count .. and more
        // This is how we get the ResultSetMetaData object

        ResultSetMetaData resultSetMetaData= rs.getMetaData();
        for (int Columns = 1; Columns <resultSetMetaData.getColumnCount()+1 ; Columns++) {
            System.out.print(resultSetMetaData.getColumnLabel(Columns)+"\t");

        }
        System.out.println();

        System.out.println("============================================================");

        rs.beforeFirst();
        while (rs.next()){
          for (int Rows = 1; Rows <resultSetMetaData.getColumnCount() ; Rows++) {
              System.out.print(rs.getString(Rows)+"\t");
          }
            System.out.println();
}

    }
}
