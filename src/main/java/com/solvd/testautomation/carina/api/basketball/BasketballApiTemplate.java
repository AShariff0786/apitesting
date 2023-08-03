package com.solvd.testautomation.carina.api.basketball;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.EndpointTemplate;
import com.zebrunner.carina.api.annotation.EndpointTemplateMethod;
import com.zebrunner.carina.api.annotation.PathParam;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@EndpointTemplate(url="${config.api_url}")
public interface BasketballApiTemplate {

    @EndpointTemplateMethod(url = "/games", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/games/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getGamesMethod();

    @EndpointTemplateMethod(url = "/teams", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/teams/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getTeamsMethod();

    @EndpointTemplateMethod(url = "/players", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/players/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getPlayersMethod();

    @EndpointTemplateMethod(url = "/stats/?seasons[]=${season}&player_ids[]=${player_id}", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/stats/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getStatsMethod(@PathParam(key = "season")String season, @PathParam(key = "player_id") String playerId);

    @EndpointTemplateMethod(url = "/season_averages/?season=${season}&player_ids[]=${player_id}", methodType = HttpMethodType.GET)
    @ResponseTemplatePath(path = "api/seasonaverages/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getSeasonsAverageMethod(@PathParam(key = "season")String season, @PathParam(key = "player_id") String playerId);
}
