package org.example.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoUserPage extends BasePage {

    @FindBy(id = "languages")
    WebElement languagesSelect;

    public InfoUserPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfilePage selectLanguage(String language) {
        selectByText(languagesSelect, language);
        return new ProfilePage(driver);
    }
}
