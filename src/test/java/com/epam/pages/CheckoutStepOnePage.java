package com.epam.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id = "first-name")
    private WebElement firstNameInputField;

    @FindBy(id = "last-name")
    private WebElement lastNameInputField;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInputField;

    @FindBy(className = "error-message-container")
    private WebElement errorMessage;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickToContinueButton() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        logger.info("Clicked to continue button!");
    }

    public String getErrorMessage() {
        waitForElementToBeVisible(errorMessage);
        logger.info("Error message: " + errorMessage);
        return errorMessage.getText();
    }

    public void fillOnlyFirstName(String firstName) {
        waitForElementToBeVisible(firstNameInputField);
        waitForElementToBeVisible(continueButton);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
        logger.info("Entering first name: " + firstName);
        continueButton.click();
        logger.info("Continue button clicked");

    }

    public void fillFirstAndLastName(String firstName, String lastName) {
        waitForElementToBeVisible(firstNameInputField);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
        logger.info("Entering first name: " + firstName);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
        logger.info("Entering last name: " + lastName);
        continueButton.click();
        logger.info("Continue button clicked");
    }

    public void fillAllCheckoutFields(String firstName, String lastName, String postalCode) {
        waitForElementToBeVisible(firstNameInputField);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
        logger.info("Entering first name: " + firstName);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
        logger.info("Entering last name: " + lastName);
        zipCodeInputField.clear();
        zipCodeInputField.sendKeys(postalCode);
        logger.info("Entering postal code: " + postalCode);
        continueButton.click();
        logger.info("Continue button clicked");
    }
}
