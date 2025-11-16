package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage {

    @FindBy(className = "cart_item")
    private List<WebElement> chekcoutItemList;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickToFinishButton(){
        finishButton.click();
        logger.info("Finish button clicked!");
    }

    public String getUrlOfThePage(){
        waitForElementToBeVisible(finishButton);
        logger.info("Given URL: " +driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}
