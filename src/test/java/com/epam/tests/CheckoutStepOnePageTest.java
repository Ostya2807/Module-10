package com.epam.tests;

import com.epam.pages.CartPage;
import com.epam.pages.CheckoutStepOnePage;
import com.epam.pages.InventoryPage;
import com.epam.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CheckoutStepOnePageTest extends CommonConditions {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutStepOnePage checkoutStepOnePage;

    @BeforeClass
    public void initPages(){
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
    }
    @BeforeMethod
    public void startBrowser() {
        driver.get(URL);

    }
    @Test
    public void shouldShowErrorWhenOnlyFirstNameIsFilled(){
        loginPage.login(user);
        inventoryPage.addItemsToCart();
        inventoryPage.openCartPageWithShoppingCartIcon();
        cartPage.clickToCheckout();
        checkoutStepOnePage.fillOnlyFirstName("Vass");
        checkoutStepOnePage.clickToContinueButton();
        Assert.assertEquals( checkoutStepOnePage.getErrorMessage(),"Error: Last Name is required");
    }

    @Test
    public void shouldShowErrorWhenFirstNameAndLastIsFilled(){
        loginPage.login(user);
        inventoryPage.addItemsToCart();
        inventoryPage.openCartPageWithShoppingCartIcon();
        cartPage.clickToCheckout();
        checkoutStepOnePage.fillFirstAndLastName("Vass", "Jenő");
        checkoutStepOnePage.clickToContinueButton();
        Assert.assertEquals( checkoutStepOnePage.getErrorMessage(),"Error: Postal Code is required");
    }

    @Test
    public void continueCheckoutWhenFormIsFilledCorrectly(){
        loginPage.login(user);
        inventoryPage.addItemsToCart();
        inventoryPage.openCartPageWithShoppingCartIcon();
        cartPage.clickToCheckout();
        checkoutStepOnePage.fillAllCheckoutFields("Vass", "Jennő", "1032");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }
}