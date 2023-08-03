package com.solvd.testautomation.carina.web.common;

import com.solvd.testautomation.carina.web.uiobjects.NavItem;
import com.solvd.testautomation.carina.web.uiobjects.NewsItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public abstract class AbstractPage extends com.zebrunner.carina.webdriver.gui.AbstractPage {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    protected ExtendedWebElement logo;

    @FindBy(xpath = "//ul[@id='nav-ul']/li")
    protected List<NavItem> navItemList;

    @FindBy(xpath = "//div[@id='nav-controls']")
    protected ExtendedWebElement profileDropDown;

    @FindBy(xpath = "//a[@href='/account/sign-in']")
    protected ExtendedWebElement signInButton;

    @FindBy(xpath = "//a[@href='/account/nbaprofile']")
    protected ExtendedWebElement profileButton;

    @FindBy(xpath = "//button[@aria-label='No thanks; close the dialog']")
    protected ExtendedWebElement popUpButton;

    @FindBy(xpath = "//button[@aria-label='Decline Offer; close the dialog']")
    protected ExtendedWebElement declineButton;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement submitButton;



    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    public NavItem getItem(String name){
        for(int i=0; i<navItemList.size(); i++){
            if(navItemList.get(i).getLink().contains(name)){
                return navItemList.get(i);
            }
        }
        return null;
    }
    public void clickButton(String name){
        switch (name){
            case ("Games"):
                getItem("games").click();
                break;
            case("Schedule"):
                getItem("schedule").click();
                break;
            case("News"):
                getItem("news").click();
                break;
            case("Teams"):
                getItem("teams").click();
                break;
            case("Players"):
                getItem("players").click();
                break;
            default:
                break;
        }
    }

    public void closePopUp(){
        popUpButton.clickIfPresent(10);
        declineButton.clickIfPresent(10);
    }

    public void openProfileDropDownMenu(){
        profileDropDown.click();
    }

    public void clickProfileButton(){
        profileButton.click();
    }

    public LoginPageBase clickSignInButton(){
        signInButton.click();
        return initPage(driver, LoginPageBase.class);
    }

    public HomePageBase clickSubmitButton(){
        submitButton.click();
        return initPage(driver, HomePageBase.class);
    }

    public boolean isLoggedIn(){
        return signInButton.isElementPresent();
    }

    public GamesPageBase openGamesPage() {
        clickButton("Games");
        closePopUp();
        return initPage(driver, GamesPageBase.class);
    }


    public TeamsPageBase openTeamsPage() {
        clickButton("Teams");
        closePopUp();
        return initPage(driver, TeamsPageBase.class);
    }


    public NewsPageBase openNewsPage() {
        clickButton("News");
        closePopUp();
        return initPage(driver, NewsPageBase.class);
    }


    public AllPlayersPageBase openAllPlayersPage() {
        clickButton("Players");
        closePopUp();
        return initPage(driver, AllPlayersPageBase.class);
    }


    public ProfilePageBase openProfilePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://socialimpact.nba.com']")));
        openProfileDropDownMenu();
        clickProfileButton();
        return initPage(driver, ProfilePageBase.class);
    }



    public LoginPageBase openLoginPage() {
        openProfileDropDownMenu();
        if(isLoggedIn()) {
            clickSignInButton();
        }
        return initPage(driver, LoginPageBase.class);
    }
}
