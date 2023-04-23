package pages;

import helpers.HelperWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.Driver;

public class TradeMapPage {

    @FindBy(xpath = "//i[.='perm_identity']")
    private WebElement clicarSair;

    @FindBy(xpath = "//span[.='Logout']")
    private WebElement clicarLogout;


    public TradeMapPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void sairPagina(){

        HelperWait.waitPresenceOfElement(clicarSair, 60);
        clicarSair.click();
        HelperWait.waitPresenceOfElement(clicarLogout, 60);
        clicarLogout.click();
    }
}
