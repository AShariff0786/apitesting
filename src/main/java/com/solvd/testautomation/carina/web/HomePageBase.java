package com.solvd.testautomation.carina.web;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;


public abstract class HomePageBase extends AbstractPage {


    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract GamesPageBase openGamesPage();
    public abstract TeamsPageBase openTeamsPage();

    public abstract NewsPageBase openNewsPage();
    public abstract AllPlayersPageBase openAllPlayersPage();

    public abstract ProfilePageBase openProfilePage();

    public abstract LoginPageBase openLoginPage();

}