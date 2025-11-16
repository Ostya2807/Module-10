package com.epam.driver;

import com.epam.utils.HighlightListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class DriverSingleton {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriver webDriver;

            switch (System.getProperty("browser", "chrome")) {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
            }

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
