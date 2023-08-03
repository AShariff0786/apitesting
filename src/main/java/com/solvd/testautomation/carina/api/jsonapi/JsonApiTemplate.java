package com.solvd.testautomation.carina.api.jsonapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.EndpointTemplate;
import com.zebrunner.carina.api.annotation.EndpointTemplateMethod;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url="${config.json_api_url}")
public interface JsonApiTemplate {
    @EndpointTemplateMethod(url = "/posts/1", methodType = HttpMethodType.DELETE)
    @RequestTemplatePath(path = "api/delete/_delete/rq.json")
    @ResponseTemplatePath(path = "api/delete/_delete/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 deleteJSONMethod();

    @EndpointTemplateMethod(url = "/posts", methodType = HttpMethodType.POST)
    @RequestTemplatePath(path = "api/posts/_post/rq.json")
    @ResponseTemplatePath(path = "api/posts/_post/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
    AbstractApiMethodV2 postJSONMethod();
}
