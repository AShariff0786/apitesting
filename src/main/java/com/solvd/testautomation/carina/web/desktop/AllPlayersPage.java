package com.solvd.testautomation.carina.web.desktop;

import com.solvd.testautomation.carina.web.common.AllPlayersPageBase;
import com.solvd.testautomation.carina.web.common.PlayerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AllPlayersPageBase.class)
public class AllPlayersPage extends AllPlayersPageBase{

    @FindBy(xpath = "//input[@placeholder='Search Players']")
    private ExtendedWebElement searchBox;


    public AllPlayersPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    @Override
    public void searchPlayerName(String playerName){
        searchBox.type(playerName);
    }

}
