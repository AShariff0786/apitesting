package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.HomePageBase;
import com.solvd.testautomation.carina.mobile.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {
    @FindBy(id = "welcomeSplashImage")
    private ExtendedWebElement logo;

    @FindBy(id="welcomePickTeams")
    private ExtendedWebElement pickTeamButton;

    @FindBy(className = "android.widget.CheckBox")
    private ExtendedWebElement checkBox;

    @FindBy(id = "menu_done")
    private ExtendedWebElement doneButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase openHomePage() {
        pickTeamButton.click();
        checkBox.click();
        doneButton.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return logo.isElementPresent();
    }
}
