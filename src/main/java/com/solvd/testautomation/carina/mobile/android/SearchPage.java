package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.HomePageBase;
import com.solvd.testautomation.carina.mobile.common.ResultsPageBase;
import com.solvd.testautomation.carina.mobile.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(id="edit_search")
    private ExtendedWebElement searchBar;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultsPageBase searchTerm(String term) {
        searchBar.click();
        searchBar.type(term);
        List<WebElement> results = driver.findElements(By.xpath("//android.view.ViewGroup[@clickable=\"true\"]"));
        results.get(0).click();
        return initPage(driver, ResultsPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return searchBar.isElementPresent();
    }
}
