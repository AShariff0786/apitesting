package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TeamsPageBase extends AbstractPage {
    public TeamsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SpecificTeamPageBase openSpecificTeam(String teamName);
}
