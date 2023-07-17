package com.solvd.testautomation.carina.api.jsonapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/posts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/posts/_post/rq.json")
@ResponseTemplatePath(path = "api/posts/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostJSONMethod extends AbstractApiMethodV2 {
    public PostJSONMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("json_api_url"));
    }
}
