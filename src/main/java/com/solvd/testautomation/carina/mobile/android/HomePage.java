package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.BoxScorePageBase;
import com.solvd.testautomation.carina.mobile.common.HomePageBase;
import com.solvd.testautomation.carina.mobile.common.MyInterestsPageBase;
import com.solvd.testautomation.carina.mobile.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "br_toolbar")
    private ExtendedWebElement toolbar;

    @FindBy(id="welcomeSignIn")
    private ExtendedWebElement signInButton;

    @FindBy(id="mybr")
    private ExtendedWebElement myTeams;

    @FindBy(id = "menu_search")
    private ExtendedWebElement searchButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyInterestsPageBase openMyTeamPage() {
        myTeams.click();
        return initPage(driver, MyInterestsPageBase.class);
    }

    @Override
    public SearchPageBase openSearchPage() {
        searchButton.click();
        return initPage(driver, SearchPageBase.class);
    }

    @Override
    public BoxScorePageBase openBoxScore() {
        List<WebElement> games = driver.findElements(By.xpath("//android.widget.LinearLayout[@clickable=\"true\"]"));
        games.get(0).click();
        return initPage(driver, BoxScorePageBase.class);
    }


    @Override
    public boolean isPageOpened() {
        return toolbar.isElementPresent();
    }
}
