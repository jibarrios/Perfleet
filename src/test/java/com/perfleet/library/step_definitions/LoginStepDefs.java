package com.perfleet.library.step_definitions;

import com.perfleet.library.pages.LoginPage;
import com.perfleet.library.utilities.ui.ConfigurationReader;
import com.perfleet.library.utilities.ui.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Going to the login Page");
       // String
    }

    @When("I login as driver")
    public void i_login_as_driver() {
        System.out.println("Logging in as driver");
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username,password);

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        System.out.println("Verifying dashboard page");
        String actualTittle = Driver.getDriver().getTitle();
        String expectedTittle = "Dashboard";
        Assert.assertEquals(expectedTittle,actualTittle);

    }
    @When("I login as a driver")
    public void i_login_as_a_driver() {
        System.out.println("Logging in as driver");
    }


}