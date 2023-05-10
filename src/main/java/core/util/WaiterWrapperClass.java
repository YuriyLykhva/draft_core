package core.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static core.util.Constants.WAIT_TIMEOUT_SECONDS;

public class WaiterWrapperClass {

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElement(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
    
    public static void waitUntilElementIsNotDisplayed(List<WebElement> webElements) {
        boolean isDisplayed = true;
        while (isDisplayed) {
            isDisplayed = webElements.size() > 0;
        }
    }
}
