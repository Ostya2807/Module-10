package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getSizeOfCart(){
        logger.info("Shopping cart size: " + cartItems.size());
        return this.cartItems.size();
    }

    public void clickToCheckout(){
        waitForElementToBeVisible(checkoutButton);
        checkoutButton.click();
        logger.info("Clicked to checkout button!");
    }
}
