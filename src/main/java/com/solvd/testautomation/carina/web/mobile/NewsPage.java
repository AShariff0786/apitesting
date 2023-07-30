package com.solvd.testautomation.carina.web.mobile;

import com.solvd.testautomation.carina.web.common.NewsItem;
import com.solvd.testautomation.carina.web.common.NewsPageBase;
import com.zebrunner.carina.utils.R;
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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    public NewsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(getLogo());
    }

}
