package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.CreateCalendarEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendar_Step_Definitions {
   CreateCalendarEventPage createCalendarEventPage=new CreateCalendarEventPage();
   BasePage basePage=new CreateCalendarEventPage();

    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {

        createCalendarEventPage.clickOnCreateCalendarEvent();
    }

    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(  Map<String,String>  dataTable) {
         dataTable.forEach((k,v)-> System.out.println("Key: "+k+", "+" Value "+v));
         System.out.println("======================================================");
         createCalendarEventPage.enterTitle(dataTable.get("Title"));
         createCalendarEventPage.enterDescription(dataTable.get("Description"));


    }

    @Then("user verifies that new calendar event is displayed:")
    public void user_verifies_that_new_calendar_event_is_displayed( Map<String,String> dataTable) {
        String title = dataTable.get("Title");
        String description = dataTable.get("Description");
        Assert.assertEquals(title, createCalendarEventPage.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description, createCalendarEventPage.getDataFromGeneralInfo("Description"));

    }

//    @Then("hahaah")
//    public void hahaah() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("uihfosffuirgbaf")
//    public void uihfosffuirgbaf() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
