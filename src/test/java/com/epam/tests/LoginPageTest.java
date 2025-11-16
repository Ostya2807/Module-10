package com.epam.tests;

import com.epam.driver.DriverSingleton;
import com.epam.models.User;
import com.epam.pages.LoginPage;
import com.epam.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    protected LoginPage loginPage;

    private final String URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void loadApplication() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
        loginPage = new LoginPage(this.driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        DriverSingleton.closeDriver();
    }

    @Test
    public void validLoginTest() {
        User user = UserCreator.withAllCredentials();
        loginPage.login(user);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
