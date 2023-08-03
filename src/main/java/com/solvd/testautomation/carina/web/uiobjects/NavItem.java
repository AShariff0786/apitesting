package com.solvd.testautomation.carina.web.uiobjects;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavItem extends AbstractUIObject {
    @FindBy(xpath = "./a")
    private ExtendedWebElement navItem;

    public NavItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String getLink(){
        return navItem.getAttribute("href");
    }
    public void click(){
        navItem.click();
    }
}
