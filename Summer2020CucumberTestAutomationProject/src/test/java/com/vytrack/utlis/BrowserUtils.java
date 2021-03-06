package com.vytrack.utlis;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    private static WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);

    public static void wait(int sec){
        try{
           Thread.sleep(sec*1000);
        } catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("argument[0].click()", element);
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
//        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: " + text);

    }


}
