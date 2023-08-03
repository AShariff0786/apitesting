package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.support.FindBy;


public abstract class HomePageBase extends AbstractPage {
    @FindBy(xpath = "//button[text()='I Accept']")
    private ExtendedWebElement acceptCookies;


    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }


    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent();
    }



}