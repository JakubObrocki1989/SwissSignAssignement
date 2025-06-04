package org.example.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "login-email")
    WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage typeEmail(String email) {
        waitForElementToBeDisplayed(emailInput);
        sendKeys(emailInput, email);
        return this;
    }

    public PasswordPage clickSubmit() {
        clickElement(submitButton);
        return new PasswordPage(driver);
    }
}
