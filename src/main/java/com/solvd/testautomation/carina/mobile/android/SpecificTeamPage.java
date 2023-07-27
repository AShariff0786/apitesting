package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.HomePageBase;
import com.solvd.testautomation.carina.mobile.common.SpecificTeamPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SpecificTeamPageBase.class)
public class SpecificTeamPage extends SpecificTeamPageBase {
    @FindBy(id = "team_cover_photo_holder")
    private ExtendedWebElement teamLogo;

    @FindBy(id="home")
    private ExtendedWebElement homeButton;
    public SpecificTeamPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase openHomePage() {
        homeButton.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return teamLogo.isElementPresent();
    }
}
