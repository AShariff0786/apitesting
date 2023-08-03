package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AllPlayersPageBase extends AbstractPage {

    @FindBy(xpath = "//table//a")
    protected ExtendedWebElement searchedPlayer;

    public AllPlayersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void searchPlayerName(String playerName);


    public PlayerPageBase clickSearchedPlayer(){
        searchedPlayer.click();
        return initPage(driver, PlayerPageBase.class);
    }

}
