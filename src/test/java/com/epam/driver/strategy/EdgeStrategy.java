package com.epam.driver.strategy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeStrategy implements DriverStrategy{
    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
