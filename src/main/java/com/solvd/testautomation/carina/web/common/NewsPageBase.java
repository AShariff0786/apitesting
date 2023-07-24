package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class NewsPageBase extends AbstractPage {
    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openSearchedNews(String searchedTerm);
}
