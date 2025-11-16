package com.epam.tests;

import com.epam.driver.DriverSingleton;
import com.epam.models.User;
import com.epam.service.UserCreator;
import com.epam.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({TestListener.class})
public abstract class CommonConditions {
    protected WebDriver driver;
    protected User user;
    protected final String URL = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp(){
        driver = DriverSingleton.getDriver();
        user = UserCreator.withAllCredentials();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}
