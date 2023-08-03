package com.solvd.testautomation.carina.web.mobile;

import com.solvd.testautomation.carina.web.common.HomePageBase;
import com.solvd.testautomation.carina.web.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//input[@name='email']")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }
    @Override
    public void typeEmail(String email) {
        emailTextBox.type(email);
    }

    @Override
    public void typePassword(String password) {
        passwordTextBox.type(password);
    }

}
