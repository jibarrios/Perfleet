package com.perfleet.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement signInBttn;


    public void login(String username, String password){
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        signInBttn.click();
    }







}
