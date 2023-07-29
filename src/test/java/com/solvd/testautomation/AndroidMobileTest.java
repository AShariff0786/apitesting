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
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class AndroidMobileTest implements IAbstractTest, IMobileUtils {

    @BeforeClass
    @Test(testName = "Test Profile Set Up" , description = "Test the ability to set up user profile on apps first launch.")
    public void testProfileSetUp(){
/*      String apkpath="../testautomation/src/main/resources/bleacher_report.apk";
        File app=new File(apkpath);
        R.CONFIG.put("capabilities.app", app.getAbsolutePath());*/


        //checks if profile is already set up
        List<WebElement> pickTeams = getDriver().findElements(By.xpath("//android.widget.Button[@text='Pick Teams']"));
        if(pickTeams.size() > 0) {
            WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
            Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

            HomePageBase homePage = welcomePage.openHomePage();
            Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        }else{
            HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
            Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        }


    }

    @Test(testName = "Test Specific Team Page" , description = "Test the ability to open a specific team page.")
    public void testSpecificTeamPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        MyInterestsPageBase myTeamsPage = homePage.openMyTeamPage();
        Assert.assertTrue(myTeamsPage.isPageOpened(), "My Interests page isn't opened");

        SpecificTeamPageBase specificTeamPage = myTeamsPage.openSpecificTeam("Warriors");
        Assert.assertTrue(specificTeamPage.isPageOpened(), "Specific Team page isn't opened");

        homePage = specificTeamPage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
    }

    @Test(testName = "Test Search" , description = "Test the ability to search for a term the user enters.")
    public void testSearch(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        SearchPageBase searchPage = homePage.openSearchPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page isn't opened");

        ResultsPageBase resultsPage = searchPage.searchTerm("stephen curry");
        Assert.assertTrue(resultsPage.isPageOpened(), "Results page isn't opened");

        homePage = resultsPage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
    }

    @Test(testName = "Test Box Score Page" , description = "Test the ability to open the box score for a specific game.")
    public void testBoxScorePage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        BoxScorePageBase boxScorePage = homePage.openBoxScore();
        Assert.assertTrue(boxScorePage.isPageOpened(), "Box Score page isn't opened");

        homePage = boxScorePage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
    }

    @Test(testName = "Test Add to My Interests" , description = "Test the ability to add to the users interest page.")
    public void testAddToMyInterests(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        MyInterestsPageBase myInterestsPage = homePage.openMyTeamPage();
        Assert.assertTrue(myInterestsPage.isPageOpened(), "My Interests page isn't opened");

        AddInterestPageBase addInterestPage = myInterestsPage.addInterest();
        Assert.assertTrue(addInterestPage.isPageOpened(), "Add Interests page isn't opened");

        myInterestsPage = addInterestPage.addInterest("Knicks");
        Assert.assertTrue(myInterestsPage.isPageOpened(), "My Interests page isn't opened");

        homePage = myInterestsPage.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
    }
}
