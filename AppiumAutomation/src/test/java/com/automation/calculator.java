package com.automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class calculator {

      AppiumDriver<AndroidElement> driver;

    @Before
    public void setup(){
// to specify test settings and required basic info about device and app
        DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,20000);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
//        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");

        //for new apps - just use "app"
        //for pre-installed - "appPackage" and "appActivity"
        //address of appium server
        //localhost means that appium server is running on your computer
        //if, appium server launched on some other computer
        //specify IP/DNS address instead of localhost
        //4723 - default port number of appium server. Can be changed
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
             driver = new AndroidDriver<AndroidElement>(url, desiredCapabilities);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
//    @Test
//    public void calculatorTest(){
//        AndroidElement button2 = driver.findElement(MobileBy.id("com.android.calculator2:id/digit_4"));
//        AndroidElement plus =driver.findElement(MobileBy.AccessibilityId("plus"));
//     AndroidElement equalsBtn = driver.findElement(MobileBy.AccessibilityId("equals"));
//        AndroidElement resultElement = driver.findElementById("com.android.calculator2:id/result");
//
//        //to handle synchronization issues, same as in Selenium WebDriver
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//
//        wait.until(ExpectedConditions.elementToBeClickable(button2));
//
//
//        button2.click(); // 2
//        plus.click(); // +
//        button2.click(); // 2
//        equalsBtn.click(); // =
//
//        int expected = 4;
//        int actual = Integer.parseInt(resultElement.getText());
//
//        Assert.assertEquals("Something wrong here!!!",expected, actual);
//    }

    @Test
    public void calculatorTest() throws Exception {

        AndroidElement btn2 = driver.findElement(MobileBy.id("com.android.calculator2:id/digit_2"));
        AndroidElement plusBtn = driver.findElement(MobileBy.AccessibilityId("plus"));
        AndroidElement equalsBtn = driver.findElement(MobileBy.AccessibilityId("equals"));
        AndroidElement resultElement = driver.findElementById("com.android.calculator2:id/result");

        //to handle synchronization issues, same as in Selenium WebDriver
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(btn2));
        btn2.click(); // 2
        plusBtn.click(); // +
        btn2.click(); // 2
        equalsBtn.click(); // =

        int expected = 4;
        int actual = Integer.parseInt(resultElement.getText());

        Assert.assertEquals(expected, actual);
    }
    @Ignore
    @Test
    public void calculatorTestWithTouchActions(){
        AndroidElement btn9 = driver.findElementById("com.android.calculator2:id/digit_9");
        AndroidElement btn0 = driver.findElementById("com.android.calculator2:id/digit_0");
        AndroidElement divide = driver.findElementByAccessibilityId("divide");
        AndroidElement btn5 = driver.findElementById("com.android.calculator2:id/digit_5");
        AndroidElement resultElement = driver.findElementById("com.android.calculator2:id/result");
        AndroidElement equalsBtn = driver.findElement(MobileBy.AccessibilityId("equals"));

        //we can click on elements, or we can use touch actions
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btn9))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btn0))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(divide))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btn5))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(equalsBtn))).perform();

        int expected = 18;
        int actual = Integer.parseInt(resultElement.getText());
        Assert.assertEquals(expected, actual);
    }
    @After
    public void tearDown(){
        driver.closeApp();
    }
    }

//    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//    }


