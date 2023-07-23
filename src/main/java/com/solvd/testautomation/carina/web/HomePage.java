package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = "//a[@href='/account/nbaprofile']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//div[@class='NavBar_div__74CVO']")
    private ExtendedWebElement profileDropDown;

    @FindBy(xpath = "//a[@href='/account/sign-in']")
    private ExtendedWebElement signInButton;

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

    @Override
    public ProfilePageBase openProfilePage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='2022-23 Standings']")));
        profileDropDown.click();
        profileButton.click();
        return initPage(driver, ProfilePageBase.class);
    }

    @Override
    public LoginPageBase openLoginPage() {
        profileDropDown.click();
        signInButton.click();
        return initPage(driver, LoginPageBase.class);
    }


}
