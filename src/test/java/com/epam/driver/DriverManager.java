package com.epam.driver;

import com.epam.driver.DriverFactory;
import com.epam.driver.strategy.DriverStrategy;
import com.epam.utils.HighlightListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (driver.get() == null) {

            String browser = System.getProperty("browser");
            DriverStrategy strategy = DriverFactory.getStrategy(browser);

            WebDriver webDriver = strategy.createDriver();

            webDriver = new EventFiringDecorator(new HighlightListener()).decorate(webDriver);
            webDriver.manage().window().maximize();

            driver.set(webDriver);
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
