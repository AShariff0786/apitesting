package com.solvd.testautomation;

import com.solvd.testautomation.carina.api.basketball.BasketballApiTemplate;
import com.solvd.testautomation.carina.api.jsonapi.JsonApiTemplate;
import com.solvd.testautomation.carina.api.space.SpaceApiTemplate;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@MethodOwner(owner = "AShariff0786")
public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(APITest.class);
    private static final BasketballApiTemplate basketballApi = TemplateFactory.prepareTemplate(BasketballApiTemplate.class);
    private static final SpaceApiTemplate spaceApi = TemplateFactory.prepareTemplate(SpaceApiTemplate.class);
    private static final JsonApiTemplate jsonApi = TemplateFactory.prepareTemplate(JsonApiTemplate.class);


    @Test(testName = "Get Players" , description = "Get All the Players Currently in the NBA.")
    public void testGetPlayers(){
        LOGGER.info("Testing Get Players Method");
        AbstractApiMethodV2 getPlayersMethod = basketballApi.getPlayersMethod();
        getPlayersMethod.callAPIExpectSuccess();
        getPlayersMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPlayersMethod.validateResponseAgainstSchema("api/players/_get/rs.schema");

    }


    @Test(testName = "Get Teams" , description = "Get All the Teams Currently in the NBA.")
    public void testGetTeams(){
        LOGGER.info("Testing Get Teams Method");
        AbstractApiMethodV2 getTeamsMethod = basketballApi.getTeamsMethod();
        getTeamsMethod.callAPIExpectSuccess();
        getTeamsMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getTeamsMethod.validateResponseAgainstSchema("api/teams/_get/rs.schema");
    }


    @Test(testName = "Get Games" , description = "Get statistics of every game that was played and the outcome of the game.")
    public void testGetGames(){
        LOGGER.info("Testing Get Games Method");
        AbstractApiMethodV2 getGamesMethod = basketballApi.getGamesMethod();
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
        LOGGER.info("Testing Get Stats Method");
        AbstractApiMethodV2 getStatsMethod = basketballApi.getStatsMethod(season, playerId);
        getStatsMethod.callAPIExpectSuccess();
        getStatsMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getStatsMethod.validateResponseAgainstSchema("api/stats/_get/rs.schema");
    }

    @Test(testName = "Get Season Averages" , description = "Get The Average of Stats for a Player in a Season",
            dataProvider = "playersProvider")
    public void testGetSeasonAverages(String season, String playerId){
        LOGGER.info("Testing Get Season Averages Method");
        AbstractApiMethodV2 getSeasonAveragesMethod = basketballApi.getSeasonsAverageMethod(season, playerId);
        getSeasonAveragesMethod.callAPIExpectSuccess();
        getSeasonAveragesMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getSeasonAveragesMethod.validateResponseAgainstSchema("api/seasonaverages/_get/rs.schema");
    }

    @Test(testName = "Get Astronauts" , description = "Get all the astronauts from NASA.")
    public void testGetAstronauts(){
        LOGGER.info("Testing Get Astronauts Method");
        AbstractApiMethodV2 getAstronautsMethod = spaceApi.getAstronautsMethod();
        getAstronautsMethod.callAPIExpectSuccess();
        getAstronautsMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAstronautsMethod.validateResponseAgainstSchema("api/astronauts/_get/rs.schema");
    }

    @Test(testName = "Get Launch" , description = "Get Every space launch from NASA.")
    public void testGetLaunch(){
        LOGGER.info("Testing Get Launch Method");
        AbstractApiMethodV2 getLaunchMethod = spaceApi.getLaunchMethod();
        getLaunchMethod.callAPIExpectSuccess();
        getLaunchMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getLaunchMethod.validateResponseAgainstSchema("api/launch/_get/rs.schema");
    }

    @Test(testName = "Create JSON" , description = "Post a created JSON object to the site.")
    public void testCreateJsonMethod() {
        LOGGER.info("Testing Create Json Method");
        AbstractApiMethodV2 createJsonMethod = jsonApi.postJSONMethod();
        createJsonMethod.callAPIExpectSuccess();
        createJsonMethod.validateResponse();
    }

    @Test(testName = "Delete JSON" , description = "Delete a JSON object from the site.")
    public void testDeleteJson() {
        LOGGER.info("Testing Delete Json Method");
        AbstractApiMethodV2 deleteJSONMethod = jsonApi.deleteJSONMethod();
        deleteJSONMethod.callAPIExpectSuccess();
        deleteJSONMethod.validateResponse();
    }

}
