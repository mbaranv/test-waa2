package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {

    }

    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");

        if (driver == null) {
            switch (browser) {

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                  //  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                    //options.addArguments("--start-maximized");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--incognito");

                    //options.addArguments("--window-size=1920,1080");
                    // options.addArguments("--ignore-ssl-errors=yes");
                    // options.addArguments("--ignore-certificate-errors");
                    // options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                    // options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

                    driver = new ChromeDriver(options);
                    break;

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
