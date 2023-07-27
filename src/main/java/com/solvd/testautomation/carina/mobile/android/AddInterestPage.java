package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.AddInterestPageBase;
import com.solvd.testautomation.carina.mobile.common.MyInterestsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddInterestPageBase.class)
public class AddInterestPage extends AddInterestPageBase {
    @FindBy(id = "toolbar_title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text=\"NBA\"]//parent::android.widget.RelativeLayout")
    private ExtendedWebElement nbaButton;

    @FindBy(id = "search_src_text")
    private ExtendedWebElement searchBar;

    @FindBy(className = "android.widget.CheckBox")
    private ExtendedWebElement checkBox;

    @FindBy(id = "menu_done")
    private ExtendedWebElement doneButton;

    public AddInterestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyInterestsPageBase addInterest(String interest) {
        nbaButton.click();
        searchBar.click();
        searchBar.type(interest);
        checkBox.click();
        driver.navigate().back();
        driver.navigate().back();
        doneButton.click();
        return initPage(driver, MyInterestsPageBase.class);

    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }
}
