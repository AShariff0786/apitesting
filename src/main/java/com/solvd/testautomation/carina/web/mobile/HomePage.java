package com.solvd.testautomation.carina.web.mobile;

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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//span[text()='Sign In']//parent::button")
    private ExtendedWebElement signInDropDownMenu;

    @FindBy(xpath = "//a[@data-text='Sign in with NBA ID']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[@id='nav-controls']")
    private ExtendedWebElement navDropDownMenu;

    @FindBy(xpath = "//a[@data-text='My NBA ID']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//a[@data-text='Games']")
    private ExtendedWebElement gamesButton;

    @FindBy(xpath = "//button[@data-section='drawer' and text()='News']")
    private ExtendedWebElement newsButton;

    @FindBy(xpath = "//a[@data-section='drawer' and text()='Home']")
    private ExtendedWebElement newsHomeButton;

    @FindBy(xpath = "//button[@data-content='menu-hamburger']")
    private ExtendedWebElement menuDropDown;

    @FindBy(xpath = "//a[@data-section='drawer' and text()='Teams']")
    private ExtendedWebElement teamsButton;

    @FindBy(xpath = "//button[@data-section='drawer' and text()='Players']")
    private ExtendedWebElement playersButton;

    @FindBy(xpath = "//a[@data-section='drawer' and text()='Players Home']")
    private ExtendedWebElement playersHomeButton;

    @FindBy(xpath = "//button[text()='No thanks']")
    private ExtendedWebElement closePopUpButton;


    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public GamesPageBase openGamesPage() {
        gamesButton.click();
        closePopUpButton.clickIfPresent();
        return initPage(driver, GamesPageBase.class);
    }

    @Override
    public TeamsPageBase openTeamsPage() {
        menuDropDown.click();
        teamsButton.click();
        closePopUpButton.clickIfPresent();
        return initPage(driver, TeamsPageBase.class);
    }

    @Override
    public NewsPageBase openNewsPage() {
        menuDropDown.click();
        newsButton.click();
        newsHomeButton.click();
        closePopUpButton.clickIfPresent();
        return initPage(driver, NewsPageBase.class);
    }

    @Override
    public AllPlayersPageBase openAllPlayersPage() {
        menuDropDown.click();
        playersButton.click();
        playersHomeButton.click();
        closePopUpButton.clickIfPresent();
        return initPage(driver, AllPlayersPageBase.class);
    }

    @Override
    public ProfilePageBase openProfilePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Go to Standings']")));
        navDropDownMenu.click();
        profileButton.click();
        return initPage(driver, ProfilePageBase.class);
    }

    @Override
    public LoginPageBase openLoginPage() {
        signInDropDownMenu.click();
        signInButton.click();
        return initPage(driver, LoginPageBase.class);
    }
}
