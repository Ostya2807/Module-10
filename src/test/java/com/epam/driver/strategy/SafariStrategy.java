package com.epam.driver.strategy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariStrategy implements DriverStrategy{
    @Override
    public WebDriver createDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }
}
