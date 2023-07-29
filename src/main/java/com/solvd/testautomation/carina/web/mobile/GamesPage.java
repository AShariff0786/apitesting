package com.solvd.testautomation.carina.web.mobile;

import com.solvd.testautomation.carina.web.common.GamesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GamesPageBase.class)
public class GamesPage extends GamesPageBase {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;
    public GamesPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }
}
