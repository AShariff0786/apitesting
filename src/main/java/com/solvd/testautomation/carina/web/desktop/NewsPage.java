package com.solvd.testautomation.carina.web.desktop;

import com.solvd.testautomation.carina.web.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.IntStream;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;
    @FindBy(xpath = "//article[@class='ArticleTile_tileArticle__XV7_D']")
    private List<NewsItem> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news");
        setUiLoadedMarker(logo);
    }

    @Override
    public void openSearchedNews(String searchedTerm){
        IntStream.rangeClosed(0,9).forEach(i ->{
            if(StringUtils.containsAnyIgnoreCase(news.get(i).getLink(), searchedTerm)){
                LOGGER.info("Links with searched term:" + news.get(i).getLink());
            }
        });
    }

}
