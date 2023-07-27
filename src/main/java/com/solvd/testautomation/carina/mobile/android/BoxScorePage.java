package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.BoxScorePageBase;
import com.solvd.testautomation.carina.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BoxScorePageBase.class)
public class BoxScorePage extends BoxScorePageBase {
    @FindBy(id = "toolbar_title")
    private ExtendedWebElement title;
    @FindBy(id="home")
    private ExtendedWebElement homeButton;
    public BoxScorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase openHomePage() {
        homeButton.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }
}
