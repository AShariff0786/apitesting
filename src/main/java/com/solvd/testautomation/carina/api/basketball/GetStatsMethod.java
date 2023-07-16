package com.solvd.testautomation.carina.api.basketball;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/stats/?seasons[]=2018&player_ids[]=17", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/stats/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetStatsMethod extends AbstractApiMethodV2 {
    public GetStatsMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
