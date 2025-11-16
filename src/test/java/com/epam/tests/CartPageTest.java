package com.epam.tests;

import com.epam.pages.CartPage;
import com.epam.pages.InventoryPage;
import com.epam.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends CommonConditions{
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;

    @BeforeClass
    public void initPages(){
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @BeforeMethod
    public void startBrowser(){
        driver.get(URL);
    }

    @Test
    public void checkSizeOfTheCart(){
        loginPage.login(user);
        inventoryPage.addItemsToCart();
        inventoryPage.openCartPageWithShoppingCartIcon();
        Assert.assertEquals(cartPage.getSizeOfCart(), 2);
    }
}
