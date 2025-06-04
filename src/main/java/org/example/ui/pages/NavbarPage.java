package org.example.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarPage extends BasePage {

    @FindBy(xpath = "//a[@title='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@data-dropdown='klp-widget-authenticated-menu']")
    WebElement profileButton;

    @FindBy(xpath = "//a[contains(@href, 'https://account.post.ch/selfadmin/?lang')]")
    WebElement myProfileButton;

    public NavbarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickLoginButton() {
        clickElement(loginButton);
        return new LoginPage(driver);
    }

    public NavbarPage clickProfileButton() {
        clickElement(profileButton);
        return this;
    }

    public ProfilePage clickMyProfileButton() {
        clickElement(myProfileButton);
        return new ProfilePage(driver);
    }
}
