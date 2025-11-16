package com.epam.driver.strategy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeStrategy implements DriverStrategy{
    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
