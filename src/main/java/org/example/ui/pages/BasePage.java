package org.example.ui.pages;

import org.example.ui.utils.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BrowserActions {


    public BasePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver, this);
    }
}
