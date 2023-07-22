package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.ldap.ExtendedRequest;
import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TeamsPageBase.class)
public class TeamsPage extends TeamsPageBase{
    @FindBy(xpath = "//h1[text()='All Teams']")
    private ExtendedWebElement marker;


    public TeamsPage(WebDriver driver) {
        super(driver);
        setPageURL("/teams");
        setUiLoadedMarker(marker);
    }

    @Override
    public SpecificTeamPageBase openSpecificTeam(String teamName) {
        WebElement link = driver.findElement(By.xpath("//section//parent::a[@href=\"/"+teamName+"/\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
        return initPage(driver, SpecificTeamPageBase.class);
    }
}
