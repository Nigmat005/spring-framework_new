package com.vytrack.pages;

import com.vytrack.utlis.BrowserUtils;
import com.vytrack.utlis.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
  public BasePage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }

//  @Before
//    public void Setup(){
//       Driver.getDriver();
//       Driver.getDriver().manage().window().maximize();
//       Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//   }
//  @After
//    public void CloseUp(){
//       Driver.getDriver().quit();
//   }
   @FindBy(className= "oro-subtitle")
    protected WebElement pageSubTitle;

    @FindBy(xpath = "(//button[contains(text(),'Save and Close')])[1]")
    protected WebElement saveAndCloseBtn;

    @FindBy(css="[class='loader-mask']")
    protected List<WebElement> loaderMask;

   public String getPageSubTitleText()  {
       try{
           Thread.sleep(2);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
       return pageSubTitle.getText();
    }



    /**
     * Method for navigation in vytrack app
     * @param  tab , for example: Fleet, Dashboard, Sales, Activities..
     * @param module, one of the values that will be visible after clicking on the tab.
     *        For Fleet, these are the modules: Vehicles, Vehicle Odometer, Vehicle Costs, etc..
     */

    public void navigateTo(String tab,String module){
       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);

       ////*[contains(text(), 'Fleet')and@class='title title-level-1']
        //*[contains(text(), 'Create Calendar')and@class='title title-level-2']
        BrowserUtils.wait(4);
        String tabXpath="//*[contains(text(),'"+tab+"')and @class='title title-level-1']";
        String moduleXpath="//*[contains(text(),'"+module+"')and @class='title title-level-2']";

        //wait for presence and ability to click on element
        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

        WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();


        // wait until loader mask disappears
        wait.until(ExpectedConditions.invisibilityOfAllElements(loaderMask));
//        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(loaderMask),1);
        BrowserUtils.wait(4);

    }

    public void clickSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndCloseBtn);
    }

}
