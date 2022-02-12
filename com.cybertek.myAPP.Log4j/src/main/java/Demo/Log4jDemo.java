package Demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
  private static Logger logger= LogManager.getLogger(Log4jDemo.class);
    public static void main(String[] args) {
        System.out.println("\n Hello World...\n");
        int num1=1; int num2=5;
        System.out.println(num1>num2);
         logger.trace("This is trace message");
         logger.info("This is information message");
         logger.error("This is an error message");
         logger.warn("This is an warning  message");
         logger.fatal("This is an fatal message");
        System.out.println("\n completed");
    }
}
