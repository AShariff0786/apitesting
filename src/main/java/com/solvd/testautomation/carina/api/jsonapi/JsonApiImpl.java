package com.solvd.testautomation.carina.api.jsonapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;

public class JsonApiImpl implements JsonApiTemplate{
    private final JsonApiTemplate jsonApiTemplate;

    public JsonApiImpl(JsonApiTemplate jsonApiTemplate){
        this.jsonApiTemplate = TemplateFactory.prepareTemplate(JsonApiTemplate.class);
    }
    @Override
    public AbstractApiMethodV2 deleteJSONMethod() {
        return jsonApiTemplate.deleteJSONMethod();
    }

    @Override
    public AbstractApiMethodV2 postJSONMethod() {
        return jsonApiTemplate.postJSONMethod();
    }
}
