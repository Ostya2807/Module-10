package com.epam.tests;

import com.epam.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutStepTwoPageTest extends CommonConditions{

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;

    private CheckoutStepTwoPage checkoutStepTwoPage;
    @BeforeClass
    public void initPages(){
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
    }
    @BeforeMethod
    public void startBrowser() {
        driver.get(URL);
    }
    @Test
    public void checkTheCurrentUrl(){
        loginPage.login(user);
        inventoryPage.addItemsToCart();
        inventoryPage.openCartPageWithShoppingCartIcon();
        cartPage.clickToCheckout();
        checkoutStepOnePage.fillAllCheckoutFields("Vass", "Jennő", "1032");
        Assert.assertEquals(checkoutStepTwoPage.getUrlOfThePage(), "https://www.saucedemo.com/checkout-step-two.html");
    }

}