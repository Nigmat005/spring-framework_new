package com.vytrack.pages;

import com.vytrack.utlis.Configuration_Reader;
import com.vytrack.utlis.Wait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

// public LoginPage(){
//    super();
//    PageFactory.initElements(Driver.getDriver(),this);
//}
    //To not use web elements directly in step definition classes
    //helps to prevent code duplication and keep step definitions clean
    @FindBy(id = "prependedInput")
    private WebElement username;
//    @FindBy(xpath = "//input[@id='prependedInput']")
//    private WebElement UserName;


    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(css = "div[class='alert alert-error']")

    protected WebElement ErrorMessage;


    public String Error_Message(){
        try{
            Thread.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return ErrorMessage.getText().trim();
    }


    public void login(String usernameValue, String passwordValue) {
        Wait.Wait_Time_Method(1);
        username.sendKeys(usernameValue);
        Wait.Wait_Time_Method(1);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login() {
        String usernameValue = Configuration_Reader.Get_Properties("storemanager.username");
        String passwordValue = Configuration_Reader.Get_Properties("password");

        Wait.Wait_Time_Method(1);
        username.sendKeys(usernameValue);
        Wait.Wait_Time_Method(1);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String role) {
        String usernameValue = "";
        String passwordValue = Configuration_Reader.Get_Properties("password");

        if (role.equalsIgnoreCase("sales manager")) {
            usernameValue = Configuration_Reader.Get_Properties("salesmanager.username");

        } else if (role.equalsIgnoreCase("driver")) {
            usernameValue =Configuration_Reader.Get_Properties("driver.username");
        } else {
            usernameValue = Configuration_Reader.Get_Properties("storemanager.username");
            System.out.println(Configuration_Reader.Get_Properties("storemanager.username"));
        }
        Wait.Wait_Time_Method(1);
        username.sendKeys(usernameValue);
        Wait.Wait_Time_Method(1);
        password.sendKeys(passwordValue, Keys.ENTER);
    }


}