package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//a[text()='READ']")
    private ExtendedWebElement readButton;

    @FindBy(xpath = "//a[@href='/news']")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//a[@href=\"/teams\"]")
    private ExtendedWebElement teamsButton;

    @FindBy(xpath = "//a[@href=\"/games\"]")
    private ExtendedWebElement gamesButton;

    @FindBy(xpath = "//a[@href='/players']")
    private ExtendedWebElement playersButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }


    @Override
    public GamesPageBase openGamesPage() {
        gamesButton.click();
        return initPage(driver, GamesPageBase.class);
    }

    @Override
    public TeamsPageBase openTeamsPage() {
        teamsButton.click();
        return initPage(driver, TeamsPageBase.class);
    }

    @Override
    public NewsPageBase openNewsPage() {
        newsButton.click();
        return initPage(driver, NewsPageBase.class);
    }

    @Override
    public AllPlayersPageBase openAllPlayersPage() {
        playersButton.click();
        return initPage(driver, AllPlayersPageBase.class);
    }


}
