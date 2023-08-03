package com.solvd.testautomation.carina.api.basketball;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.EndpointTemplateMethod;
import com.zebrunner.carina.api.annotation.PathParam;
import com.zebrunner.carina.api.binding.TemplateFactory;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

public class BasketballApiImpl implements BasketballApiTemplate{
    private final BasketballApiTemplate basketballApiTemplate;

    public BasketballApiImpl(BasketballApiTemplate basketballApiTemplate){
        this.basketballApiTemplate = TemplateFactory.prepareTemplate(BasketballApiTemplate.class);

    }

    public AbstractApiMethodV2 getGamesMethod(){
        return basketballApiTemplate.getGamesMethod();
    }

    @Override
    public AbstractApiMethodV2 getTeamsMethod() {
        return basketballApiTemplate.getTeamsMethod();
    }

    @Override
    public AbstractApiMethodV2 getPlayersMethod() {
        return basketballApiTemplate.getPlayersMethod();
    }

    @Override
    public AbstractApiMethodV2 getStatsMethod(String season, String playerId) {
        return basketballApiTemplate.getStatsMethod(season, playerId);
    }

    @Override
    public AbstractApiMethodV2 getSeasonsAverageMethod(String season, String playerId) {
        return basketballApiTemplate.getSeasonsAverageMethod(season, playerId);
    }
}
