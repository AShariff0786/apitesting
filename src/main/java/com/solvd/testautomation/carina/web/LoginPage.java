package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{
    @FindBy(xpath = "//img[@alt=\"NBA ID Logo\"]")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@id=\"email\"]")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private ExtendedWebElement passwordTextBox;
    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/account/sign-in");
        setUiLoadedMarker(logo);
    }

    @Override
    public HomePageBase login(){
        emailTextBox.type(R.TESTDATA.get("user.email"));
        passwordTextBox.type(R.TESTDATA.get("user.password"));
        loginButton.click();
        return initPage(driver, HomePageBase.class);
    }
}
