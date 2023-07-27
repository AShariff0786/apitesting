package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.ResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultsPageBase.class )
public class ResultsPage extends ResultsPageBase {
    @FindBy(id = "team_name")
    private ExtendedWebElement name;
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return name.isElementPresent();
    }
}
