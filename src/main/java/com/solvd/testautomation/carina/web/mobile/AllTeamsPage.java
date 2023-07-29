package com.solvd.testautomation.carina.web.mobile;

import com.solvd.testautomation.carina.web.common.SpecificTeamPageBase;
import com.solvd.testautomation.carina.web.common.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TeamsPageBase.class)
public class AllTeamsPage extends TeamsPageBase {
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;

    public AllTeamsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public SpecificTeamPageBase openSpecificTeam(String teamName) {
        WebElement link = driver.findElement(By.xpath("//section//parent::a[@href=\"/"+teamName+"/\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
        return initPage(driver, SpecificTeamPageBase.class);
    }
}
