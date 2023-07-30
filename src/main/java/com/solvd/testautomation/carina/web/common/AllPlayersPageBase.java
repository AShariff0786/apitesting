package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AllPlayersPageBase extends AbstractPage {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//table//a")
    private ExtendedWebElement searchedPlayer;

    public AllPlayersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PlayerPageBase openSpecificPlayer(String playerName);

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getSearchedPlayer() {
        return searchedPlayer;
    }

}
