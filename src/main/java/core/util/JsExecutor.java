package core.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.driver.WebDriverFactory.getDriver;

public class JsExecutor {

    private static JavascriptExecutor jsExecutor;
    private static WebDriver driver;

    private JsExecutor() {}

    public static synchronized JavascriptExecutor getInstance() {
        if (jsExecutor == null) {
            driver = getDriver();
            jsExecutor = (JavascriptExecutor) driver;
        }
        return jsExecutor;
    }

    protected void jsClickElement(WebElement element) {
        JavascriptExecutor executor = JsExecutor.getInstance();
        executor.executeScript("arguments[0].click();", element);
    }

    protected void jsViewElement(WebElement element) {
        JavascriptExecutor executor = JsExecutor.getInstance();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
