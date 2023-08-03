package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PlayerPageBase extends AbstractPage {

    @FindBy(xpath = "//p[@class='PlayerSummary_playerNameText___MhqC']")
    private ExtendedWebElement playerName;
    public PlayerPageBase(WebDriver driver) {
        super(driver);
    }



    public ExtendedWebElement getPlayerName() {
        return playerName;
    }

    public String readName() {
        assertElementPresent(playerName);
        return playerName.getText();
    }
}
