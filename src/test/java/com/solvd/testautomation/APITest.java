package com.solvd.testautomation;

import com.solvd.testautomation.carina.api.basketball.GetGamesMethod;
import com.solvd.testautomation.carina.api.basketball.GetPlayersMethod;
import com.solvd.testautomation.carina.api.basketball.GetSeasonAveragesMethod;
import com.solvd.testautomation.carina.api.basketball.GetStatsMethod;
import com.solvd.testautomation.carina.api.basketball.GetTeamsMethod;
import com.solvd.testautomation.carina.api.jsonapi.DeleteJSONMethod;
import com.solvd.testautomation.carina.api.jsonapi.PostJSONMethod;
import com.solvd.testautomation.carina.api.space.GetAstronautsMethod;
import com.solvd.testautomation.carina.api.space.GetLaunchMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.report.testrail.TestRailCases;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

@MethodOwner(owner = "AShariff0786")
public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(testName = "Get Players" , description = "Get All the Players Currently in the NBA.")
    public void testGetPlayers(){
        GetPlayersMethod getPlayersMethods = new GetPlayersMethod();
        getPlayersMethods.callAPIExpectSuccess();
        getPlayersMethods.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPlayersMethods.validateResponseAgainstSchema("api/players/_get/rs.schema");

    }



    @Test(testName = "Get Teams" , description = "Get All the Teams Currently in the NBA.")
    public void testGetTeams(){
        GetTeamsMethod getTeamsMethods = new GetTeamsMethod();
        getTeamsMethods.callAPIExpectSuccess();
        getTeamsMethods.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getTeamsMethods.validateResponseAgainstSchema("api/teams/_get/rs.schema");
    }


    @Test(testName = "Get Games" , description = "Get statistics of every game that was played and the outcome of the game.")
    public void testGetGames(){
        GetGamesMethod getGamesMethod = new GetGamesMethod();
        getGamesMethod.callAPIExpectSuccess();
        getGamesMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getGamesMethod.validateResponseAgainstSchema("api/games/_get/rs.schema");
    }

    @DataProvider(name = "playersProvider")
    public Object[][] seasonsDataProvider(){
        return new Object[][] {
            {"2018", "237"},
            {"2019", "17"},
            {"2020", "237"}
        };
    }


    @Test(testName = "Get Stats" , description = "Get All Game Stats for a Player in a Season",
            dataProvider = "playersProvider")
    public void testGetStats(String season, String playerId){
        GetStatsMethod getStatsMethod = new GetStatsMethod(season, playerId);
        getStatsMethod.callAPIExpectSuccess();
        getStatsMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getStatsMethod.validateResponseAgainstSchema("api/stats/_get/rs.schema");
    }

    @Test(testName = "Get Season Averages" , description = "Get The Average of Stats for a Player in a Season",
            dataProvider = "playersProvider")
    public void testGetSeasonAverages(String season, String playerId){
        GetSeasonAveragesMethod getSeasonAveragesMethod = new GetSeasonAveragesMethod(season, playerId);
        getSeasonAveragesMethod.callAPIExpectSuccess();
        getSeasonAveragesMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getSeasonAveragesMethod.validateResponseAgainstSchema("api/seasonaverages/_get/rs.schema");
    }

    @Test(testName = "Get Astronauts" , description = "Get all the astronauts from NASA.")
    public void testGetAstronauts(){
        GetAstronautsMethod getAstronautsMethod = new GetAstronautsMethod();
        getAstronautsMethod.callAPIExpectSuccess();
        getAstronautsMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAstronautsMethod.validateResponseAgainstSchema("api/astronauts/_get/rs.schema");
    }

    @Test(testName = "Get Launch" , description = "Get Every space launch from NASA.")
    public void testGetLaunch(){
        GetLaunchMethod getLaunchMethod = new GetLaunchMethod();
        getLaunchMethod.callAPIExpectSuccess();
        getLaunchMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getLaunchMethod.validateResponseAgainstSchema("api/launch/_get/rs.schema");
    }

    @Test(testName = "Create JSON" , description = "Post a created JSON object to the site.")
    public void testCreateJsonMethod() {
        PostJSONMethod api = new PostJSONMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test(testName = "Delete JSON" , description = "Delete a JSON object from the site.")
    public void testDeleteJson() {
        DeleteJSONMethod deleteJSONMethod = new DeleteJSONMethod();
        deleteJSONMethod.callAPIExpectSuccess();
        deleteJSONMethod.validateResponse();
    }

}
