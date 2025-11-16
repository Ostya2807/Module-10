package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{

    @FindBy(className = "complete-header")
    private WebElement completeHeaderText;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getCompleteHeaderText(){
        waitForElementToBeVisible(completeHeaderText);
        logger.info("Order submission successful.");
        return completeHeaderText.getText();
    }
}
