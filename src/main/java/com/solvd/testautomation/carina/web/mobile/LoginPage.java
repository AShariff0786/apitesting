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
    private ExtendedWebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public HomePageBase login() {
        email.type(R.TESTDATA.get("user.email"));
        password.type(R.TESTDATA.get("user.password"));
        signInButton.click();
        return initPage(driver, HomePageBase.class);
    }
}
