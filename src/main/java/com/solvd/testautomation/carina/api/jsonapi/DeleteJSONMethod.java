package com.solvd.testautomation.carina.api.jsonapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/posts/1", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/delete/_delete/rq.json")
@ResponseTemplatePath(path = "api/delete/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteJSONMethod extends AbstractApiMethodV2 {
    public DeleteJSONMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("json_api_url"));
    }
}
