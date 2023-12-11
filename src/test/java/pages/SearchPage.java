package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ConfigReader;
import utils.DriverManager;
import utils.JSUtils;
import utils.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    JSUtils jsUtils = new JSUtils(DriverManager.getDriver());
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(DriverManager.getDriver());
    Select select;


    static String keyword;

    public static int countryIndex;
    @FindBy(id = "q")
    WebElement searchBar;

    @FindBy(id = "l")
    WebElement locationBar;

    @FindBy(id = "text_search_button")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(@class,'detail')]")
    List<WebElement> resultList;

    @FindBy(linkText = "Homes")
    WebElement homes;

    @FindBy(linkText = "Cars")
    WebElement cars;

    @FindBy(linkText = "Boats")
    WebElement boats;

    @FindBy(id = "//span[@id='cookie_accept_button']")
    WebElement cookie;

    @FindBy(xpath = "//a[@rel='nofollow']")
    List<WebElement> countries;

    @FindBy(xpath = "//*[contains(@class,'vertical item')]")
    List<WebElement> car_home;

    @FindBy(xpath = "//*[@id='property_type_list']//a[contains(@href,'/')]")
    List<WebElement> listOfPropertyType;

    @FindBy(xpath = "//*[@id='location_list']//a[contains(@href,'/')]")
    List<WebElement> listOfCity;

    @FindBy(xpath = "//*[@id='boat_type_list']//a[contains(@href,'/')]")
    List<WebElement> listOfBoatType;

    @FindBy(xpath = "//*[@id='type_list']//*[contains(@href,'/')]")
    WebElement rentButtonOfHomes;

    @FindBy(xpath = "//*[@id='type_list']//*[contains(@href,'/')]")
    WebElement powerBoatButton;

    @FindBy(className = "home_type")
    WebElement home_type;

    @FindBy(xpath = "//*[contains(@class,'content')]")
    public WebElement resultBox;

    @FindBy(xpath = "//ins[contains(@class,'adsbygoogle')]//div[@id='aswift_3_host']")
   static WebElement ads;

    @FindBy(xpath = "//div[contains(@id,'dismiss')]")
   static WebElement closeAd;



    @FindBy(xpath = "//h1")
    public WebElement h1;

    @FindBy(xpath = "//li//a[contains(@href,'https')]//span")
    List<WebElement> countryDropDown;

    @FindBy(xpath = "//*[contains(@style,'display: block;')]")
    public WebElement alertMessage;

    @FindBy(xpath = "//img[contains(@src,'car_brands')]")
    List<WebElement> makeLogos;

    @FindBy(xpath = "//div[@class='popular_brand']//p//a[contains(@href,'used-cars/')]")
    List<WebElement> models;

    @FindBy(id = "breadcrumb")
    WebElement resultKeywordHead;

    @FindBy(xpath = "//div[@class='item_content']//h3//div")
    List<WebElement> resultTitles;

    @FindBy(xpath = "//h4[@class='attribute']")
    List<WebElement> titleMakeModel;





    public void testMt() {

        driver.get("https://www.waa2.com");

        homes.click();

        System.out.println(countryDropDown.size());

        jsUtils.clickElementByJS(countryDropDown.get(3));
    }

    //tc01-tc02

    public void clickHomes() {
        jsUtils.clickElementByJS(homes);
    }

    public void selectPropType(String key) {
        jsUtils.clickElementByJS(listOfPropertyType.get(ReusableMethods.findElementInList(key)));
    }

    public void selectCity(String key)  {
        jsUtils.clickElementByJS(listOfCity.get(ReusableMethods.findElementInList(key)));

        actions.click().perform();
        wait.until(ExpectedConditions.visibilityOf(resultBox));
    }

    public void checkResultList() {
        for (WebElement w : resultList) {
            Assert.assertTrue(w.isDisplayed());
        }

    }

    //tc03
    public void entryKeyword(String key) {
        keyword = key;
        searchBar.sendKeys(key);

    }

    public void entryLocation(String key) {
        keyword = key;
        locationBar.sendKeys(key);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void checkKeywordResult() {//later check for upgrade
        Assert.assertTrue(h1.getText().contains(keyword));
    }

    public void changeCountry(String index) {
        countryIndex = Integer.parseInt(index);
        System.out.println(countryIndex);
        System.out.println(countryDropDown.size());
        jsUtils.clickElementByJS(countryDropDown.get(3));
    }

    public void checkResultCountryChange() {
        String[] countryHomesValue = ReusableMethods.filterCountriesForHomes();
        System.out.println(countryHomesValue[3]);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(ConfigReader.getProperty(countryHomesValue[SearchPage.countryIndex])));

    }

    //us06-tc02
    public void clickCars() {
        cars.click();
    }

    public void selectModel(String make, String model) {

        for (WebElement w : models) {
            if (w.getAttribute("href").contains(model)) {
                jsUtils.clickElementByJS(w);
                break;
            }
        }
    }

    public void checkResultKeyword(String make, String model) {
        Assert.assertTrue(resultKeywordHead.getText().contains(make + " " + model));
    }

    public void checkResultTitle(String model) {

        for (WebElement w : resultTitles) {
            jsUtils.scrollIntoViewJS(w);
            Assert.assertTrue(w.getText().toLowerCase().contains(model));
        }
    }

    //us08-tc01
    public void clickBoats() {
        boats.click();
    }

    //us08-tc02
    public void selectSailBoat(String key) {
        for (WebElement w:listOfBoatType) {
            if (w.getText().toLowerCase().contains(key)){
                jsUtils.clickElementByJS(w);
                break;
            }
        }
    }

    public void selectPowerBoat(String key) throws InterruptedException {

        powerBoatButton.click();

        for (WebElement w:listOfBoatType) {
            if (w.getText().toLowerCase().contains(key)){
                jsUtils.clickElementByJS(w);
                break;
            }
        }

       closeIframe();
    }
    public static void closeIframe(){
        if (ads.isDisplayed()){
            DriverManager.getDriver().switchTo().frame("aswift_3");
            DriverManager.getDriver().switchTo().frame("ad_iframe");
            System.out.println("iframe geçtim");
            closeAd.click();
            DriverManager.getDriver().switchTo().defaultContent();
        }
    }
}
