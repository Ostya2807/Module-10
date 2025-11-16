package com.epam.tests;

import com.epam.pages.InventoryPage;
import com.epam.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class InventoryPageTest extends CommonConditions {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeClass
    public void initPages(){
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }
    @BeforeMethod
    public void startBrowser() {
        driver.get(URL);

    }
    @Test
    public void addOneItemToCartTest() {
        loginPage.login(user);
        inventoryPage.addOneItemToCart();
        Assert.assertEquals(inventoryPage.getNumberOfCartItems(), 1);
    }

    @Test
    public void addMoreItemsToCartTest() {
        loginPage.login(user);
        inventoryPage.addItemsToCart();
        Assert.assertEquals(inventoryPage.getNumberOfCartItems(), 2);
    }
}