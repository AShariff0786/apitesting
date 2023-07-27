package com.solvd.testautomation.carina.mobile.android;

import com.solvd.testautomation.carina.mobile.common.AddInterestPageBase;
import com.solvd.testautomation.carina.mobile.common.MyInterestsPageBase;
import com.solvd.testautomation.carina.mobile.common.SpecificTeamPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MyInterestsPageBase.class)
public class MyInterestsPage extends MyInterestsPageBase {
    @FindBy(id = "edit_button")
    private ExtendedWebElement editButton;

    @FindBy(id="add_button")
    private ExtendedWebElement addButton;

    public MyInterestsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SpecificTeamPageBase openSpecificTeam(String teamName) {
        WebElement teamButton = driver.findElement(By.xpath("//android.widget.TextView[@text=\""+teamName+"\"]"));
        teamButton.click();
        return initPage(driver, SpecificTeamPageBase.class);
    }

    @Override
    public AddInterestPageBase addInterest() {
        addButton.click();
        return initPage(driver, AddInterestPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return editButton.isElementPresent();
    }


}
