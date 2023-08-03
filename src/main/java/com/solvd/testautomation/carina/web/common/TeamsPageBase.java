package com.solvd.testautomation.carina.web.common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class TeamsPageBase extends AbstractPage {

    public TeamsPageBase(WebDriver driver) {
        super(driver);
    }

    public SpecificTeamPageBase openSpecificTeam(String teamName) {
        WebElement link = driver.findElement(By.xpath("//section//parent::a[@href=\"/"+teamName+"/\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
        return initPage(driver, SpecificTeamPageBase.class);
    }

}
