package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SpecificTeamPageBase extends AbstractPage {
    public SpecificTeamPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract String readTeamName();
}
