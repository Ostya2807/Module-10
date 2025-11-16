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

    public void enterFirstName(String firstName) {
        waitForElementToBeVisible(firstNameInputField);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
        logger.info("Entered first name: " + firstName);
    }

    public void enterLastName(String lastName) {
        waitForElementToBeVisible(lastNameInputField);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
        logger.info("Entered last name: " + lastName);
    }

    public void enterPostalCode(String postalCode) {
        waitForElementToBeVisible(zipCodeInputField);
        zipCodeInputField.clear();
        zipCodeInputField.sendKeys(postalCode);
        logger.info("Entered postal code: " + postalCode);
    }

    public void clickContinue() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        logger.info("Clicked Continue button");
    }

    public void fillCheckoutWithOnlyFirstName(String firstName) {
        enterFirstName(firstName);
    }


    public void fillCheckoutWithFullName(String firstName, String lastName) {
        enterFirstName(firstName);
        enterLastName(lastName);
    }


    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public String getErrorMessage() {
        waitForElementToBeVisible(errorMessage);
        String text = errorMessage.getText();
        logger.info("Error message: " + text);
        return text;
    }

}