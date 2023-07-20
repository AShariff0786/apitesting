package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsItem extends AbstractUIObject {
    @FindBy(xpath = "./a")
    private ExtendedWebElement headlineLink;
    public NewsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public String readHeadline(){
        return headlineLink.getText();
    }
    public String getLink(){
        return headlineLink.getAttribute("href");
    }

}
