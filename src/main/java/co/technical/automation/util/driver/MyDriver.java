package co.technical.automation.util.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {

    static WebDriver driver;

    // Method to initialize the driver
    public static MyDriver web() {
        System.setProperty("webdriver.chrome.driver", "resources//driver//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars", "--start-maximized", "--no-sandbox", "--incognito",
                "--lang=es", "--disable-popup-blocking", "--disable-download-notification",
                "--start-maximized", "--test-type", "--ignore-certificate-errors",
                "--allow-running-insecure-content", "--disable-translate",
                "--always-authorize-plugins", "--log-level=ALL");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pageLoadStrategy", "none");
        options.merge(capabilities);

        driver = new ChromeDriver(options);
        return new MyDriver();
    }

    // Method to navigate to a page
    public WebDriver inPage(String url) {
        driver.get(url);
        return driver;
    }

    // Method to close the browser and clean up
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
