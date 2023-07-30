package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SpecificTeamPageBase extends AbstractPage {
    @FindBy(xpath = "//span[@class='sr-only']")
    private ExtendedWebElement teamName;
    public SpecificTeamPageBase(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getTeamName() {
        return teamName;
    }

    public String readTeamName() {
        assertElementPresent(teamName);
        return teamName.getText();
    }
}
