import utility.DB_Utility;

public class MySql_Test {
    public static void main(String[] args) {
        String connectionStr ="jdbc:mysql://18.233.97.71:3306/library1";
        String username ="library1_client";
        String password ="WVF4NdGXCKHeE6VQ";
        DB_Utility.CreateConnection(connectionStr,username,password);

    }
}
