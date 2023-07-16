package com.solvd.testautomation;

import com.solvd.testautomation.carina.api.GetGamesMethod;
import com.solvd.testautomation.carina.api.GetPlayersMethod;
import com.solvd.testautomation.carina.api.GetStatsMethod;
import com.solvd.testautomation.carina.api.GetTeamsMethod;
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
        getPlayersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPlayersMethods.validateResponseAgainstSchema("api/players/_get/rs.schema");
    }


    @Test
    public void testGetTeams(){
        GetTeamsMethod getTeamsMethods = new GetTeamsMethod();
        getTeamsMethods.callAPIExpectSuccess();
        getTeamsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getTeamsMethods.validateResponseAgainstSchema("api/teams/_get/rs.schema");
    }

    @Test
    public void testGetGames(){
        GetGamesMethod getGamesMethod = new GetGamesMethod();
        getGamesMethod.callAPIExpectSuccess();
        getGamesMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getGamesMethod.validateResponseAgainstSchema("api/games/_get/rs.schema");
    }

    @Test
    public void testGetStats(){
        GetStatsMethod getStatsMethod = new GetStatsMethod();
        getStatsMethod.callAPIExpectSuccess();
        getStatsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getStatsMethod.validateResponseAgainstSchema("api/stats/_get/rs.schema");
    }


}
