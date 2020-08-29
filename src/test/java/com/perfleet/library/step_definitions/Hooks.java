package com.perfleet.library.step_definitions;

import com.perfleet.library.utilities.dataBase.DBUtils;
import com.perfleet.library.utilities.ui.ConfigurationReader;
import com.perfleet.library.utilities.ui.Driver;
import io.restassured.RestAssured;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.util.concurrent.TimeUnit;

public class Hooks {
    public Hooks() {
    }
    @Before
    public void setUp() {
        System.out.println("set up browser");
        //Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().fullscreen();
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);


}

    @Before(value = "@api",order=0)
    public void setUpScenario() {
        System.out.println("set up browser");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Driver.getDriver().manage().window().fullscreen();
        RestAssured.baseURI = ConfigurationReader.getProperty("qa2_base_url");

    }

    @Before(value = "@db", order = 1)
    public void connect() {
        System.out.println("connecting to db");
        String url = "jdbc:mysql://" + ConfigurationReader.getProperty("qa2_db_host") +
                ConfigurationReader.getProperty("qa2_db_name");
        String username = ConfigurationReader.getProperty("qa2_db_username");
        String password = ConfigurationReader.getProperty("qa2_db_password");

        System.out.println(url);
        DBUtils.createConnection(url, username, password);
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        System.out.println("scenario.getName() = " + scenario.getName());
        scenario.write("Complete scenario: " + scenario.getName());

        if (scenario.isFailed()) {
            // take screenshot using selenium
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.embed(screenshot, "image/png", scenario.getName());
        }


        System.out.println("close driver");
        Driver.closeDriver();
    }

    @After("@db")
    public void closeConnection() {
        System.out.println("closing connection to db");
        DBUtils.destroy();
    }

//
//     //  @BeforeStep
//  //  public void setUpStep() {
//        System.out.println("prints before every step");
//    }
//
//    //  @AfterStep
//    public void tearDownStep() {
//        System.out.println("prints after every step");
//    }
//

}
