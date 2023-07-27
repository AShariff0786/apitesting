package com.solvd.testautomation.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MyInterestsPageBase extends AbstractPage{
    public MyInterestsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SpecificTeamPageBase openSpecificTeam(String teamName);

    public abstract AddInterestPageBase addInterest();

    public abstract HomePageBase openHomePage();
}
