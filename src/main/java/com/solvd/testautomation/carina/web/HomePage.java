package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
        setUiLoadedMarker(logo);
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
