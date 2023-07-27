package com.solvd.testautomation.carina.mobile.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage {
    public SearchPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract ResultsPageBase searchTerm(String term);
}
