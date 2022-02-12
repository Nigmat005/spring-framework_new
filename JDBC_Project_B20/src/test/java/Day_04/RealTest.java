package Day_04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utility.DB_Utility;

public class RealTest {
  @BeforeAll
    public static void init(){
      DB_Utility.CreateConnection();
  }
  @Test
    public static void testEmployeesCount(){
      DB_Utility.runQuery("Select * from employees");
      Assert.assertEquals("The Exact Number Is Not Matching With Really Number",107,DB_Utility.getRowCount());
  }

    // Open another test
    // run query : SELECT * FROM REGIONS
    // assert -- 3rd row second column is Asia
    @Test
    public void test3rdRowSecondColumn(){

        DB_Utility.runQuery("SELECT * FROM REGIONS") ;
        Assertions.assertEquals("Asia" , DB_Utility.getColumnDataAtRow(3,2) );

    }
  @AfterAll
    public static void tearDown(){
      DB_Utility.destroy();
  }

}
