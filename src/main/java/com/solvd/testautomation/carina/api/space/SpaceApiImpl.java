package com.solvd.testautomation.carina.api.space;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.binding.TemplateFactory;

public class SpaceApiImpl implements SpaceApiTemplate{
    private final SpaceApiTemplate spaceApiTemplate;

    public SpaceApiImpl(SpaceApiTemplate spaceApiTemplate){
        this.spaceApiTemplate = TemplateFactory.prepareTemplate(SpaceApiTemplate.class);
    }



    @Override
    public AbstractApiMethodV2 getAstronautsMethod() {
        return spaceApiTemplate.getAstronautsMethod();
    }

    @Override
    public AbstractApiMethodV2 getLaunchMethod() {
        return spaceApiTemplate.getLaunchMethod();
    }
}
