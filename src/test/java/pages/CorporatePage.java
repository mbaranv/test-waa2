package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigReader;
import utils.DriverManager;
import utils.JSUtils;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CorporatePage {

    private WebDriver driver;


    public CorporatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
    JSUtils jsUtils = new JSUtils(DriverManager.getDriver());

    Actions actions = new Actions(DriverManager.getDriver());


    @FindBy(xpath = "//*[@title='About']")
    WebElement about;

    @FindBy(linkText = "Add Your Listing")
    WebElement addListing;

    @FindBy(linkText = "Terms of Privacy")
    WebElement termsOfPrivacy;

    @FindBy(xpath = "//*[@href='terms-of-use']")
    WebElement termsOfUse;

    @FindBy(xpath = "//*[contains(@href,'linkedin')]")
    WebElement linkedin;

    @FindBy(xpath = "//*[contains(@href,'instagram')]")
    WebElement instagram;

    @FindBy(xpath = "//*[contains(@href,'facebook')]")
    WebElement facebook;

    @FindBy(xpath = "//*[contains(@href,'twitter')]")
    WebElement twitter;

    @FindBy(xpath = "//*[@href='get-listed']")
    WebElement getListedWaa2;

    @FindBy(xpath = "//*[contains(@href,'-corporate')]")
    List<WebElement> learnMore;

    @FindBy(xpath = "//span[text()='Feed Structure']")
    WebElement feedStructure;


    @FindBy(xpath = "//li[contains(@class,'website')]")
    List<WebElement> websiteCard;


    @FindBy(className = "question_box")
    public WebElement questionBox;



    Select select;

    public void testMt() {

        driver.get("https://www.waa2.com");




    }





    //us03-tc01
    public void checkAddYourListingButton() {
        String homePageId = driver.getWindowHandle();

        jsUtils.clickElementByJS(addListing);
        Set<String> windows = driver.getWindowHandles();

        for (String windowHandle : windows) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Get listed on Waa2")) {
                break;
            }
        }
        Assert.assertEquals(questionBox.getText(), "Get listed on Waa2", "Get listed on Waa2 aktif durumda");
    }

    public void checkHomeLearnMoreButton() {
        actions.moveToElement(websiteCard.get(0)).click(learnMore.get(0)).build().perform();

        Assert.assertEquals(questionBox.getText(), "Homes", "Homes aktif durumdadır");
    }


    public void checkFeedStructure() {
        jsUtils.clickElementByJS(feedStructure);
    }

    public void clickgetListenOnWaa2() {
        jsUtils.clickElementByJS(getListedWaa2);
    }

    public void checkCarLearnMoreButton() {
        actions.moveToElement(websiteCard.get(1)).click(learnMore.get(1)).build().perform();


    }

    public void checkBoatLearnMoreButton() {
        actions.moveToElement(websiteCard.get(2)).click(learnMore.get(2)).build().perform();
    }


    //us03-tc02

    public void checkTermsOfPrivacyButton() {
        String homePageId = driver.getWindowHandle();

        jsUtils.clickElementByJS(termsOfPrivacy);
        Set<String> windows = driver.getWindowHandles();

        for (String windowHandle : windows) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Waa2 Privacy Policy")) {
                break;
            }
        }
    }

    public void clickTermOfUse() {
        jsUtils.clickElementByJS(termsOfUse);
    }

    public void clickAboutUs() {
        jsUtils.clickElementByJS(about);
    }

    //us03-tc03

    public void clickSocialMediaIkon(String key) {

        switch (key) {

            case "linkedin":
                jsUtils.clickElementByJS(linkedin);
                break;
            case "facebook":
                jsUtils.clickElementByJS(facebook);
                break;
            case "twitter":
                wait.until(ExpectedConditions.visibilityOf(twitter));
                jsUtils.clickElementByJS(twitter);
                break;
            case "instagram":
                jsUtils.clickElementByJS(instagram);
                break;
        }
    }

}
