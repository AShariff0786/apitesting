package com.solvd.testautomation;

import com.solvd.testautomation.carina.api.GetPlayersMethods;
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
    public void testGetPlayer(){
        GetPlayersMethods getPlayersMethods = new GetPlayersMethods();
        getPlayersMethods.callAPIExpectSuccess();
        getPlayersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPlayersMethods.validateResponseAgainstSchema("api/players/_get/rs.schema");
    }

}
