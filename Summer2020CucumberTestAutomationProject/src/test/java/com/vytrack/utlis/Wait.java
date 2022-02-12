package com.vytrack.utlis;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Wait{

        public static void Wait_Time_Method(int Sec){
            try{
                Thread.sleep(Sec*1000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        public void Wait_Time_Method(WebDriver driver, int Sec){
            driver.manage().timeouts().implicitlyWait(Sec, TimeUnit.SECONDS);
        }
}

