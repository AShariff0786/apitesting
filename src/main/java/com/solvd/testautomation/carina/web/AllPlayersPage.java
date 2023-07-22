package com.solvd.testautomation.carina.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AllPlayersPageBase.class)
public class AllPlayersPage extends AllPlayersPageBase{
    @FindBy(xpath = "//a//img[@title='NBA Logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//input[@placeholder='Search Players']")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//table//a")
    private ExtendedWebElement searchedPlayer;

    public AllPlayersPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public PlayerPageBase openSpecificPlayer(String playerName) {
        searchBox.type(playerName);
        searchedPlayer.click();
        return initPage(driver, PlayerPageBase.class);
    }
}
