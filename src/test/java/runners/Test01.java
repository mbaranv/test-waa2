package runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Test01 {

    WebDriverWait wait;

    @Test()
    public void test001() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-gpu");


        WebDriver driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.waa2.com");

        System.out.println(driver.getTitle());
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //wait.until(ExpectedConditions.visibilityOf(waa2Picture));

    }


}
