package core.util;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import core.driver.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static core.driver.WebDriverFactory.getDriver;
import static core.util.Constants.USE_FULL_PAGE_SCREENSHOT;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' PASSED");
        if(iTestResult.getTestClass().getName().endsWith("LoginTest")) {
            saveScreenshot();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' FAILED");
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' SKIPPED");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log("Test Started....");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log("Test finished");
    }

    private void saveScreenshot() {
        if(USE_FULL_PAGE_SCREENSHOT) {
            File screenCapture = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenCapture, new File(
                        ".//target/screenshots/"
                                + getCurrentTimeAsString() +
                                ".png"));
            } catch (IOException e) {
                log("Failed to save screenshot: " + e.getLocalizedMessage());
            }
        } else {
            Shutterbug.shootPage(getDriver(), Capture.FULL_SCROLL).save();
        }
    }

    private void log(String methodName) {
        System.out.println(methodName);
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
