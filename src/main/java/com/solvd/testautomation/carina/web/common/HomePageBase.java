package com.solvd.testautomation.carina.web.common;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.support.FindBy;


public abstract class HomePageBase extends AbstractPage {
    @FindBy(xpath = "//button[text()='I Accept']")
    private ExtendedWebElement acceptCookies;


    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }


    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent();
    }


    public abstract GamesPageBase openGamesPage();
    public abstract TeamsPageBase openTeamsPage();

    public abstract NewsPageBase openNewsPage();
    public abstract AllPlayersPageBase openAllPlayersPage();

    public abstract ProfilePageBase openProfilePage();

    public abstract LoginPageBase openLoginPage();

}