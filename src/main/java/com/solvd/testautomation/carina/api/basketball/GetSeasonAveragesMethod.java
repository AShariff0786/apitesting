package com.solvd.testautomation.carina.api.basketball;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/season_averages/?season=2018&player_ids[]=1&player_ids[]=2&player_ids[]=17", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/seasonaverages/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetSeasonAveragesMethod extends AbstractApiMethodV2{
    public GetSeasonAveragesMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
