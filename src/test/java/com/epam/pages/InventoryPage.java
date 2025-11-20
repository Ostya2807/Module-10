package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InventoryPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceJacketAddToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartIcon;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void addOneItemToCart() {
        waitForElementToBeVisible(bikeLightAddToCartButton);
        bikeLightAddToCartButton.click();
        logger.info("One item added to the cart!");
    }

    public InventoryPage addItemsToCart() {
        addOneItemToCart();
        waitForElementToBeVisible(fleeceJacketAddToCartButton);
        fleeceJacketAddToCartButton.click();
        logger.info("Second item added to the cart!");
        return new InventoryPage(driver);
    }

    public int getNumberOfCartItems() {
        waitForElementToBeVisible(shoppingCartBadge);
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public void openCartPageWithShoppingCartIcon() {
        waitForElementToBeVisible(shoppingCartIcon);
        shoppingCartIcon.click();
        logger.info("Cart has been opened!");
    }

}
