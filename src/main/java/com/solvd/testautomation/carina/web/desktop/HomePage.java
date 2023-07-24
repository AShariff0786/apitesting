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

    @FindBy(xpath = "//button[text()='No thanks']")
    private ExtendedWebElement closePopUp;


    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }


    @Override
    public GamesPageBase openGamesPage() {
        gamesButton.click();
        closePopUp.clickIfPresent();
        return initPage(driver, GamesPageBase.class);
    }

    @Override
    public TeamsPageBase openTeamsPage() {
        teamsButton.click();
        closePopUp.clickIfPresent();
        return initPage(driver, TeamsPageBase.class);
    }

    @Override
    public NewsPageBase openNewsPage() {
        newsButton.click();
        closePopUp.clickIfPresent();
        return initPage(driver, NewsPageBase.class);
    }

    @Override
    public AllPlayersPageBase openAllPlayersPage() {
        playersButton.click();
        closePopUp.clickIfPresent();
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
        if(signInButton.isElementPresent()) {
            signInButton.click();
        }
        return initPage(driver, LoginPageBase.class);
    }


}
