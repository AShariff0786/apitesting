package com.solvd.testautomation.carina.web.desktop;

import com.solvd.testautomation.carina.web.common.PlayerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PlayerPageBase.class)
public class PlayerPage extends PlayerPageBase {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;
    @FindBy (xpath = "//p[@class='PlayerSummary_playerNameText___MhqC']")
    private ExtendedWebElement name;
    public PlayerPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public String readName(){
        assertElementPresent(name);
        return name.getText();
    }
}
