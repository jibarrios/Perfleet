package com.perfleet.library.pages;

import com.perfleet.library.utilities.ui.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




}
