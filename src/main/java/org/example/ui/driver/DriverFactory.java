package org.example.ui.driver;

import lombok.extern.slf4j.Slf4j;
import org.example.handlers.PropertiesHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Slf4j
public class DriverFactory {

    static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    static Properties properties = PropertiesHandler.getProperties();

    public static WebDriver create() {
        try {
            switch (properties.getProperty("browser").toUpperCase()) {
                case "CHROME":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    setupChromiumOptions(chromeOptions);
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
                case "EDGE":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    setupChromiumOptions(edgeOptions);
                    driver.set(new EdgeDriver(edgeOptions));
                    break;
                default:
                    throw new Exception("Browser {} is not supported yet.");
            }
            driver.get().manage().deleteAllCookies();
            driver.get().manage().window().maximize();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        log.info("Starting browser in thread: " + Thread.currentThread().getId() + " and driver ref: " + driver);
        return driver.get();
    }

    public static void closeDriver() {
        log.info("Quitting driver in thread: " + Thread.currentThread().getId() + " and driver ref: " + driver);
        driver.get().quit();
        driver.remove();
    }

    public static <T extends ChromiumOptions<?>> T setupChromiumOptions(ChromiumOptions<T> options) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.cookies", 2);
        if (Boolean.parseBoolean(properties.getProperty("headless"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        options.setExperimentalOption("prefs", prefs);
        options.setAcceptInsecureCerts(Boolean.parseBoolean(properties.getProperty("ignoreSSL")));
        return (T) options;
    }
}
