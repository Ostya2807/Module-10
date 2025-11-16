package com.epam.utils;

import com.epam.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private Logger log = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ThreadContext.put("testName", testName);
        log.info("===== STARTING TEST: {} =====", testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("===== TEST PASSED: {} =====", result.getMethod().getMethodName());
        ThreadContext.clearAll();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("===== TEST FAILED: {} =====", result.getMethod().getMethodName(), result.getTestClass().getRealClass().getSimpleName());
        saveScreenshot(result);
        ThreadContext.clearAll();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("===== TEST SKIPPED: {} =====", result.getMethod().getMethodName());
        ThreadContext.clearAll();
    }

    private void saveScreenshot(ITestResult result){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/"
                    + getCurrentTimeAsString()+ result.getMethod().getMethodName() + ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot:" + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
