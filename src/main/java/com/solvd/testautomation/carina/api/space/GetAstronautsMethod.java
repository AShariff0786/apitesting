package com.solvd.testautomation.carina.api.space;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/astronaut/?format=json&limit=10&offset=10", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/astronauts/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAstronautsMethod extends AbstractApiMethodV2 {
    public GetAstronautsMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("space_api_url"));
    }
}
