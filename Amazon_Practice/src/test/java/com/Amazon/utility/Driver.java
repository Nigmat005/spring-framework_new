package com.Amazon.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
//    We use singleton to prevent instance of driver class to be created outside of the Driver class
    private Driver(){

    }
   private static  WebDriver driver;
    public static WebDriver getDriver(){
      if (driver==null){
          String Web_browser=Configuration.Configuration_reader("browser");
          switch (Web_browser){
              case "chrome":
                  WebDriverManager.chromedriver().setup();
                   driver=new ChromeDriver();
                   break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver=new FirefoxDriver();
                  break;
              default:
                  System.out.println("Webdriver is not initialized ");


          }

      }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeDriver(){
      if (driver!=null){
          driver.quit();
          driver=null;
      }
    }
}
