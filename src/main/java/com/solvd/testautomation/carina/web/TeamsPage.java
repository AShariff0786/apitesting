package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.naming.ldap.ExtendedRequest;

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
        driver.findElement(By.xpath("//section//parent::a[@href=\"/"+teamName+"/\"]")).click();
        return initPage(driver, SpecificTeamPageBase.class);
    }
}
