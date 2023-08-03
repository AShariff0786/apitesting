package com.solvd.testautomation.carina.web.desktop;

import com.solvd.testautomation.carina.web.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase{

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news");
        setUiLoadedMarker(logo);
    }


}
