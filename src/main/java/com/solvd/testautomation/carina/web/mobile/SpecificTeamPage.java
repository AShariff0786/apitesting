package com.solvd.testautomation.carina.web.mobile;


import com.solvd.testautomation.carina.web.common.SpecificTeamPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SpecificTeamPageBase.class)
public class SpecificTeamPage extends SpecificTeamPageBase {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;


    public SpecificTeamPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }


}
