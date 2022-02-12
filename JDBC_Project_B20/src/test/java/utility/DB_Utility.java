package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DB_Utility {
    public static Connection conn;

    public static ResultSet rs;

   public static Statement stmnt;

    public static void CreateConnection(){
        String ConnectionStr=ConfigurationReader.getProperty("database.url");
        String username = ConfigurationReader.getProperty("database.username");
        String password =ConfigurationReader.getProperty("database.password");

        try{

            conn= DriverManager.getConnection(ConnectionStr,username,password);
            System.out.println("Connection Is Successful");


        }catch (SQLException e){
            System.out.println("Connection is failed "+e.getMessage());
        }

        }

    // Create a method called runQuery that accepts a SQL query
    // and return ResultSet Object

    /**
     *
     * @param query Please Enter as SQL syntax, started as "Select ... from ..."
     * @return
     */

    public static ResultSet runQuery(String query){

        try{
            Statement stmnt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=stmnt.executeQuery(query);
//            rs.next();

        }catch(SQLException e){
            System.out.println("Error while getting result "+e.getMessage());
        }
        return rs;

    }

    /**
     * Count how many row we have
     *
     * @return the row count of the resultset we got
     */
    public static int getRowCount() {

        int rowCount = 0;

        try {
            rs.last();
            rowCount = rs.getRow();

            // move the cursor back to beforeFirst location to avoid accident
            rs.beforeFirst();

        } catch (SQLException e) {

            System.out.println("ERROR WHILE GETTING ROW COUNT " + e.getMessage());
        }

        return rowCount;

    }

    /**
     * Get the column count
     *
     * @return count of column the result set have
     */
    public static int getColumnCount() {

        int columnCount = 0;

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS " + e.getMessage());
        }

        return columnCount;
    }



    /**
 * A method that return all column name as List<String>
 *
 */
public static List<String> getColumnNames(){
    List<String> columnList = new ArrayList<>();
    try{
        ResultSetMetaData rsmd=rs.getMetaData();
        for (int colNum = 1; colNum <rsmd.getColumnCount()+1; colNum++) {
             columnList.add(rsmd.getColumnLabel(colNum));
        }
    }catch(SQLException e){
        System.out.println("Error While Getting All Column Names "+ e.getMessage());
    }
    return columnList;
    }

    /**
     * Create a method that returns all row data as a List<String>
     * @param rowNum Row number you want to get the data
     * @return the row data as List object
     */
    public static List<String> getRowDataAsList(int rowNum){
        List<String> rowDataList = new ArrayList<>();
        // First we need to move the pointer to the location the rowNum specified
        try{
            ResultSetMetaData rsmd=rs.getMetaData();
            rs.absolute(rowNum);
            for (int colNum = 1; colNum < rsmd.getColumnCount()+1; colNum++) {
                rowDataList.add(rs.getString(colNum));
            }

        }catch(SQLException e){
            System.out.println("Error While Gettung Row Data List "+ e.getMessage());
        }
        return rowDataList;
    }

    /**
     * Create a method that returns the cell value of specific row and column
     * @param rowNum Row number you want to get the data
     * @param colNum Column number you want to get the data
     * @return the cell value of rowNum and colNum as a String
     */
    public static String getColumnDataAtRow(int rowNum,int colNum){
        String result="";

        try{
            rs.absolute(rowNum);
            result=rs.getString(colNum);
            rs.beforeFirst();
        }catch(SQLException e){
            System.out.println("Error While Getting Call Value At RowNum And ColNum");
        }
        return result;
    }
    /**
     * Get the entire  data as a list in a specific column
     * @param colNum the column number you want to get the list out of
     * @return value of all cells in that column as a List<String>
     */
    public static List<String> getColumnDataAsList (int colNum){
        List<String> cellValueList = new ArrayList<>();
        try{
            while (rs.next()){
                cellValueList.add(rs.getString(colNum));
            }
            rs.beforeFirst();
        }catch(SQLException e){
            System.out.println("Error While Getting A Cell Data "+e.getMessage());
        }
        return cellValueList;
    }
    /**
     * A method that display all the result set data on console
     */
    public static void displayAllData(){
        try{
            rs.beforeFirst();
            ResultSetMetaData rsmd =rs.getMetaData();
            for (int colNum = 1; colNum < rsmd.getColumnCount()+1; colNum++) {
                System.out.println(rsmd.getColumnLabel(colNum));
            }
            while(rs.next()){
                for (int colNum = 1; colNum <rsmd.getColumnCount()+1 ; colNum++) {
                    System.out.printf("%-3s"+rs.getString(colNum)+"\t");
                }
                System.out.println();
            }

        }catch( SQLException e){
            System.out.println("Error While Getting Whole Data "+ e.getMessage());
        }
    }

    /**
     * A method that return the row data along with column name as Map object
     * @param rowNum row number you want to get the data
     * @return Mapobject -- column name as key and cell value as value
     */
    public static Map<String,String> getRowMap (int rowNum){
        Map<String,String> map_Result= new LinkedHashMap<>(); // wanna use order as it is
        try{
          ResultSetMetaData rsmd = rs.getMetaData();
            rs.absolute(rowNum);
            for (int colNUm = 1; colNUm < rsmd.getColumnCount()+1; colNUm++) {
                map_Result.put(rsmd.getColumnLabel(colNUm),rs.getString(colNUm));
            }rs.beforeFirst();
        }catch(SQLException e){
            System.out.println("Error While Getting Map "+e.getMessage());
        }
        return map_Result;
    }

    public static void destroy(){

        try {

            rs.close();
            stmnt.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    }


 class test1{
    static int a;
    static String st;
    public  static void method1() {
        int a = 5;
        String st1 = "";
        st = "something";
    }
        public  static void method2() {
          method1();
            int a=5;
            String st1="";
            st="something";

    }

     public static void main(String[] args) throws SQLException {
         DB_Utility.CreateConnection();

         ResultSet rs= DB_Utility.runQuery("Select * from employees");
         rs.next();

         test1 ts=new test1();
         System.out.println(rs.getString(1));
         System.out.println(DB_Utility.getRowMap(2));
        

     }

     public static List<Map<String,String> > getAllDataAsListOfMap(){

         List<Map<String,String> > rowMapList = new ArrayList<>();

         for (int rowNum = 1; rowNum <= DB_Utility.getRowCount() ; rowNum++) {

             rowMapList.add(   DB_Utility.getRowMap(rowNum)    ) ;

         }
         return  rowMapList ;
     }


 }