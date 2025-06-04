package org.example.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(id = "editUserInfoLanguage")
    WebElement editUserInfoButton;

    @FindBy(id = "userInfoLanguage")
    WebElement userInfoLanguage;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public InfoUserPage clickEditUserInfoButton() {
        clickElement(editUserInfoButton);
        return new InfoUserPage(driver);
    }


    public String getUserCorrespondanceLanguage() {
        return userInfoLanguage.getText();
    }
}
