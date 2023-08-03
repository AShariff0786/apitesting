package com.solvd.testautomation.carina.api.space;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.EndpointTemplate;
import com.zebrunner.carina.api.annotation.EndpointTemplateMethod;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url="${config.space_api_url}")
public interface SpaceApiTemplate {
    @EndpointTemplateMethod(url = "/astronaut/?format=json&limit=10&offset=10", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/astronauts/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getAstronautsMethod();

    @EndpointTemplateMethod(url = "/launch/?format=json&limit=10&offset=10", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/launch/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getLaunchMethod();
}
