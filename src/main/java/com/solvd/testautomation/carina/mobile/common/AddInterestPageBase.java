package com.solvd.testautomation.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AddInterestPageBase extends AbstractPage {
    public AddInterestPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MyInterestsPageBase addInterest(String interest);
}
