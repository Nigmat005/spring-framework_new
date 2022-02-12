package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features",
        glue = {"com\\vytrack\\step_definitions"},

        dryRun =false,
//        monochrome = true,
//        tags = "@Parameterized_test or @negative_login",
//        tags = "@Parameterized_test"
//        tags = "@Login"
//         tags="@negative_login",
//         tags = "@add_car",
        //tags = "@calendar_events",
        tags ="@Parameterized_test",
        plugin={
               "rerun:target\\rerun.txt", // Allows us to run failed tests again
                "json:target\\cucumber.json",
        }

//        publish = true
//        plugin = {"pretty","html:target\\reports.html"},

//        plugin = {"pretty","junit:target\\report.xml"}

)


public class CucumberRunner {

}
