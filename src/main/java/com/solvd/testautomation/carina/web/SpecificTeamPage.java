package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SpecificTeamPageBase.class)
public class SpecificTeamPage extends SpecificTeamPageBase{

    @FindBy(xpath = "//img[@alt=\"NBA Logo\"]")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//span[@class='sr-only']")
    private ExtendedWebElement teamName;

    public SpecificTeamPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public String readTeamName() {
        assertElementPresent(teamName);
        return teamName.getText();
    }
}
