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

    @When("I login as store manager51")
    public void i_login_as_store_manager51() {
        System.out.println("Logging in as store manager");
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");
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