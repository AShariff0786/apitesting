package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GamesPageBase extends AbstractPage {

    public GamesPageBase(WebDriver driver) {
        super(driver);
    }
}
