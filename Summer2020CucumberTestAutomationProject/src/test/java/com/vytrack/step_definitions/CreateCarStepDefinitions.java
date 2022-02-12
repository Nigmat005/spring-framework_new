package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitions {
    CreateCarPage createCarPage=new CreateCarPage();


    @And("use clicks on Create Car button")
    public void use_clicks_on_create_car_button() {
      createCarPage.Click_CreatCar_Carbutton();
    }


    //    |License Plate | SDET|
    //    | Model Year   | 2021|
    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String,String> dataTable) {
       dataTable.forEach((k,v)-> System.out.println("Key: "+k+" , "+" Value: "+v));

        System.out.println("========================================");
        System.out.println("License Plate: "+dataTable.get("License Plate"));
        System.out.println("License Plate: "+dataTable.get("Model Year"));
        System.out.println("========================================");

    createCarPage.enterLicensePlate(dataTable.get("License Plate"));
    createCarPage.enterModelYear(dataTable.get("Model Year"));


    }
}
