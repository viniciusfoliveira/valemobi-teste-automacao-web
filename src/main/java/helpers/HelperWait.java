package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Driver;

public class HelperWait {

    public static void waitPresenceOfElement(WebElement locator, long timeout) {
        new WebDriverWait(Driver.getDriver(), timeout).until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitPresenceOfElementLocated(WebElement locator, int timeout, String texto) {
        new WebDriverWait(Driver.getDriver(), timeout).until(ExpectedConditions.textToBePresentInElement(locator, texto));
    }

    public static boolean waitVisible(WebElement locator, int timeout) {

        try {
            new WebDriverWait(Driver.getDriver(), timeout).until(ExpectedConditions.visibilityOf(locator));
            return false;
        } catch (Exception ex) {
            return true;
        }
    }

    public static WebElement waitClicable(WebElement locator, int timeout) {
        return new WebDriverWait(Driver.getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
