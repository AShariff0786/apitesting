package com.solvd.testautomation.carina.web.common;

import com.solvd.testautomation.carina.web.common.HomePageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract HomePageBase login();

}
