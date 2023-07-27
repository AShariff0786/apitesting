package com.solvd.testautomation;

import com.solvd.testautomation.carina.mobile.common.AddInterestPageBase;
import com.solvd.testautomation.carina.mobile.common.BoxScorePageBase;
import com.solvd.testautomation.carina.mobile.common.HomePageBase;
import com.solvd.testautomation.carina.mobile.common.MyInterestsPageBase;
import com.solvd.testautomation.carina.mobile.common.ResultsPageBase;
import com.solvd.testautomation.carina.mobile.common.SearchPageBase;
import com.solvd.testautomation.carina.mobile.common.SpecificTeamPageBase;
import com.solvd.testautomation.carina.mobile.common.WelcomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AndroidMobileTest implements IAbstractTest, IMobileUtils {

    @BeforeTest
    @Test
    public void testInitialization(){
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        HomePageBase homePage = welcomePage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

    }

    @Test
    public void testSpecificTeamPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        MyInterestsPageBase myTeamsPage = homePage.openMyTeamPage();
        Assert.assertTrue(myTeamsPage.isPageOpened(), "My Interests page isn't opened");

        SpecificTeamPageBase specificTeamPage = myTeamsPage.openSpecificTeam("Warriors");
        Assert.assertTrue(specificTeamPage.isPageOpened(), "Specific Team page isn't opened");
    }

    @Test
    public void testSearch(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        SearchPageBase searchPage = homePage.openSearchPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page isn't opened");

        ResultsPageBase resultsPage = searchPage.searchTerm("stephen curry");
        Assert.assertTrue(resultsPage.isPageOpened(), "Results page isn't opened");
    }

    @Test
    public void testBoxScore(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        BoxScorePageBase boxScorePage = homePage.openBoxScore();
        Assert.assertTrue(boxScorePage.isPageOpened(), "Box Score page isn't opened");
    }

    @Test
    public void testAddToMyInterests(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        MyInterestsPageBase myInterestsPage = homePage.openMyTeamPage();
        Assert.assertTrue(myInterestsPage.isPageOpened(), "My Interests page isn't opened");

        AddInterestPageBase addInterestPage = myInterestsPage.addInterest();
        Assert.assertTrue(addInterestPage.isPageOpened(), "Add Interests page isn't opened");

        myInterestsPage = addInterestPage.addInterest("Knicks");
        Assert.assertTrue(myInterestsPage.isPageOpened(), "My Interests page isn't opened");

    }
}
