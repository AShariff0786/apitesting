package com.solvd.testautomation.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MyInterestsPageBase openMyTeamPage();

    public abstract SearchPageBase openSearchPage();

    public abstract BoxScorePageBase openBoxScore();
}
