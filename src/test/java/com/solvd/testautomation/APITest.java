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
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetPlayers(){
        GetPlayersMethod getPlayersMethods = new GetPlayersMethod();
        getPlayersMethods.callAPIExpectSuccess();
        getPlayersMethods.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPlayersMethods.validateResponseAgainstSchema("api/players/_get/rs.schema");
    }


    @Test
    public void testGetTeams(){
        GetTeamsMethod getTeamsMethods = new GetTeamsMethod();
        getTeamsMethods.callAPIExpectSuccess();
        getTeamsMethods.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getTeamsMethods.validateResponseAgainstSchema("api/teams/_get/rs.schema");
    }

    @Test
    public void testGetGames(){
        GetGamesMethod getGamesMethod = new GetGamesMethod();
        getGamesMethod.callAPIExpectSuccess();
        getGamesMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getGamesMethod.validateResponseAgainstSchema("api/games/_get/rs.schema");
    }

    @Test
    public void testGetStats(){
        GetStatsMethod getStatsMethod = new GetStatsMethod();
        getStatsMethod.callAPIExpectSuccess();
        getStatsMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getStatsMethod.validateResponseAgainstSchema("api/stats/_get/rs.schema");
    }

    @Test
    public void testGetSeasonAverages(){
        GetSeasonAveragesMethod getSeasonAveragesMethod = new GetSeasonAveragesMethod();
        getSeasonAveragesMethod.callAPIExpectSuccess();
        getSeasonAveragesMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getSeasonAveragesMethod.validateResponseAgainstSchema("api/seasonaverages/_get/rs.schema");
    }

    @Test
    public void testGetAstronauts(){
        GetAstronautsMethod getAstronautsMethod = new GetAstronautsMethod();
        getAstronautsMethod.callAPIExpectSuccess();
        getAstronautsMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAstronautsMethod.validateResponseAgainstSchema("api/astronauts/_get/rs.schema");
    }

    @Test
    public void testGetLaunch(){
        GetLaunchMethod getLaunchMethod = new GetLaunchMethod();
        getLaunchMethod.callAPIExpectSuccess();
        getLaunchMethod.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getLaunchMethod.validateResponseAgainstSchema("api/launch/_get/rs.schema");
    }

    @Test
    public void testCreateJsonMethod() {
        PostJSONMethod api = new PostJSONMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    public void testDeleteUsers() {
        DeleteJSONMethod deleteJSONMethod = new DeleteJSONMethod();
        deleteJSONMethod.callAPIExpectSuccess();
        deleteJSONMethod.validateResponse();
    }

}
