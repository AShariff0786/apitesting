package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AllPlayersPageBase extends AbstractPage {
    public AllPlayersPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openSpecificPlayer(String playerName);
}
