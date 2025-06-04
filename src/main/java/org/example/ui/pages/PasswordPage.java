package org.example.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends BasePage {

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-password")
    WebElement submitButton;

    public PasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PasswordPage typePassword(String password) {
        waitForElementToBeDisplayed(passwordInput);
        sendKeys(passwordInput, password);
        return this;
    }

    public MainPage clickSubmitButton() {
        clickElement(submitButton);
        return new MainPage(driver);
    }
}
