package com.solvd.testautomation.carina.web.desktop;

import com.solvd.testautomation.carina.web.common.AllPlayersPageBase;
import com.solvd.testautomation.carina.web.common.GamesPageBase;
import com.solvd.testautomation.carina.web.common.HomePageBase;
import com.solvd.testautomation.carina.web.common.LoginPageBase;
import com.solvd.testautomation.carina.web.common.NewsPageBase;
import com.solvd.testautomation.carina.web.common.ProfilePageBase;
import com.solvd.testautomation.carina.web.common.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }


}
