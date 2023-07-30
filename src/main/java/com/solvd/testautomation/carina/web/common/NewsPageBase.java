package com.solvd.testautomation.carina.web.common;

import com.solvd.testautomation.carina.web.mobile.NewsPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;

public abstract class NewsPageBase extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsPageBase.class);

    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;
    @FindBy(xpath = "//article[@class='ArticleTile_tileArticle__XV7_D']")
    private List<NewsItem> news;
    public NewsPageBase(WebDriver driver) {
        super(driver);
    }


    public ExtendedWebElement getLogo() {
        return logo;
    }

    public List<NewsItem> getNews() {
        return news;
    }

    public void openSearchedNews(String searchedTerm) {
        IntStream.rangeClosed(0,9).forEach(i ->{
            if(StringUtils.containsAnyIgnoreCase(news.get(i).getLink(), searchedTerm)){
                LOGGER.info("Links with searched term: " + R.CONFIG.get("url")+ news.get(i).getLink());
            }
        });
    }
}
