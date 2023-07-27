package com.solvd.testautomation.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BoxScorePageBase extends AbstractPage {
    public BoxScorePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HomePageBase openHomePage();
}
