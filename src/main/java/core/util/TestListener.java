package core.util;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

import static core.driver.WebDriverFactory.getDriver;
import static core.util.Settings.PROPERTIES;

public class TestListener implements ITestListener {

    private static final Logger logger = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logInfo(String.format("Test '%s' PASSED", iTestResult.getName()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logError(String.format("Test '%s' FAILED", iTestResult.getName()));
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logWarning(String.format("Test '%s' SKIPPED", iTestResult.getName()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logInfo("Test Started....");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logInfo("Test finished");
    }

    private void saveScreenshot() {
        boolean useFullPageScreenshot = Boolean.parseBoolean(PROPERTIES.getProperty("USE_FULL_PAGE_SCREENSHOT"));

        if(useFullPageScreenshot) {
            Shutterbug.shootPage(getDriver(), Capture.FULL_SCROLL).save();
        } else {
            Shutterbug.shootPage(getDriver(), Capture.VIEWPORT).save();
        }
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warning(message);
    }

    public static void logError(String message) {
        logger.severe(message);
    }
}
