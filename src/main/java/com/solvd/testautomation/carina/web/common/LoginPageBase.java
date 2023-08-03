package com.solvd.testautomation.carina.web.common;


import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeEmail(String email);

    public abstract void typePassword(String password);


}
