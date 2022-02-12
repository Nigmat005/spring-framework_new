package com.vytrack.pages;

import com.vytrack.utlis.BrowserUtils;
import com.vytrack.utlis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage {

    @FindBy(css = "[title='Create Car']")
    private WebElement Add_Carbutton;

    public void Click_CreatCar_Carbutton(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(Add_Carbutton)).click();
        System.out.println("Clicking on 'Create car' button");
    }

    @FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licencePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInputBox;

    public void enterLicensePlate(String licensePlate) {
        BrowserUtils.enterText(licencePlateInputBox, licensePlate);
    }
    public void enterModelYear(String modelYear) {
        BrowserUtils.enterText(modelYearInputBox, modelYear);
    }

}
