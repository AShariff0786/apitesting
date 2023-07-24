package com.solvd.testautomation.carina.web.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PlayerPageBase extends AbstractPage {
    public PlayerPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readName();
}
