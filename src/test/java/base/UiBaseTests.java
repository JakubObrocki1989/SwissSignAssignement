package base;

import org.example.ui.driver.DriverFactory;
import org.example.ui.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class UiBaseTests extends BaseTests {

    public WebDriver driver;
    protected InfoUserPage infoUserPage;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected NavbarPage navbarPage;
    protected PasswordPage passwordPage;
    protected ProfilePage profilePage;

    @BeforeEach
    public void setupTest() {
        driver = DriverFactory.create();
        driver.get(properties.getProperty("baseUrl"));
        infoUserPage = new InfoUserPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        navbarPage = new NavbarPage(driver);
        passwordPage = new PasswordPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterEach
    void teardown() {
        DriverFactory.closeDriver();
    }
}
