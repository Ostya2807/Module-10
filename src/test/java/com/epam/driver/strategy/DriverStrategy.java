package com.epam.driver.strategy;

import org.openqa.selenium.WebDriver;

public interface DriverStrategy {
    WebDriver createDriver();
}
