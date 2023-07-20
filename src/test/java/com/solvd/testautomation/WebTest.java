package com.solvd.testautomation;

import com.solvd.testautomation.carina.web.AllPlayersPageBase;
import com.solvd.testautomation.carina.web.GamesPageBase;
import com.solvd.testautomation.carina.web.HomePageBase;
import com.solvd.testautomation.carina.web.LoginPageBase;
import com.solvd.testautomation.carina.web.NewsPageBase;
import com.solvd.testautomation.carina.web.SpecificTeamPageBase;
import com.solvd.testautomation.carina.web.TeamsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.report.testrail.TestRailCases;
import org.testng.annotations.Test;


@MethodOwner(owner = "AShariff0786")
public class WebTest implements IAbstractTest {

    @TestRailCases(testCasesId = "10")
    @Test(testName = "Test Login" , description = "Test the ability to login to a web page.")
    public void testLogin(){
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        HomePageBase homePage = loginPage.login();
        homePage.assertPageOpened();

        TeamsPageBase teamsPageBase = homePage.openTeamsPage();
        teamsPageBase.assertPageOpened();
    }

    @TestRailCases(testCasesId = "11")
    @Test(testName = "Test Games Page" , description = "Test ability to get to Games page from home page.")
    public void testGamesPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        GamesPageBase gamesPageBase = homePage.openGamesPage();
        gamesPageBase.assertPageOpened();
    }

    @TestRailCases(testCasesId = "12")
    @Test(testName = "Test Team Page" , description = "Checks the ability to goto a specific team page.")
    public void testTeamPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        TeamsPageBase teamsPageBase = homePage.openTeamsPage();
        teamsPageBase.assertPageOpened();

        SpecificTeamPageBase specificTeam = teamsPageBase.openSpecificTeam("knicks");
        specificTeam.assertPageOpened();

    }

    @TestRailCases(testCasesId = "13")
    @Test(testName = "Test News Page" , description = "Checks Latest News and Display News Related to Searched Term")
    public void testNewsPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        NewsPageBase newsPage = homePage.openNewsPage();
        newsPage.assertPageOpened();
        newsPage.openSearchedNews("cav");
    }

    @TestRailCases(testCasesId = "14")
    @Test(testName = "Test Specific Player Page" , description = "Checks Stats of the Searched Player")
    public void testSpecificPlayerPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        AllPlayersPageBase allPlayersPage = homePage.openAllPlayersPage();
        allPlayersPage.assertPageOpened();
        allPlayersPage.openSpecificPlayer("curry");
    }

}
