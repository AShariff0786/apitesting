package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {
    @FindBy(xpath = "//img[@title=\"NBA Logo\"]")
    private ExtendedWebElement logo;

    public ProfilePage(WebDriver driver) {
        super(driver);
        setPageURL("/account/nbaprofile");
        setUiLoadedMarker(logo);
    }
}
