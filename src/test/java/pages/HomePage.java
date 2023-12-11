package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ConfigReader;
import utils.DriverManager;
import utils.JSUtils;
import utils.ReusableMethods;


import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    JSUtils jsUtils = new JSUtils(DriverManager.getDriver());
    SoftAssert softAssert = new SoftAssert();

    //elements
    @FindBy(xpath = "//button[contains(@class,'consent')]")
    WebElement consent;
    @FindBy(xpath = "//*[@alt='Waa2']")
    WebElement waa2Picture;

    @FindBy(xpath = "//h1[@id='title_short']")
    WebElement mainPageTitle;

    @FindBy(xpath = "//*[contains(text(),'Advanced')]")
    WebElement advanced;

    @FindBy(linkText = "Proceed to www.waa2.net (unsafe)")
    WebElement proceed;

    @FindBy(id = "dismiss-button")
    WebElement popup;

    @FindBy(id = "text_search_button")
    WebElement searchButton;

    @FindBy(linkText = "Homes")
    WebElement homes;

    @FindBy(linkText = "Cars")
    WebElement cars;

    @FindBy(linkText = "Boats")
    WebElement boats;

    @FindBy(id = "//span[@id='cookie_accept_button']")
    WebElement cookie;

    @FindBy(linkText = "About")
    WebElement about;

    @FindBy(xpath = "//a[@rel='nofollow']")
    List<WebElement> countries;

    @FindBy(xpath = "//*[contains(@class,'vertical item')]")
    List<WebElement> car_home;

    @FindBy(xpath = "//*[@id='property_type_list']//a[contains(@href,'/')]")
    List<WebElement> listOfPropertyType;

    @FindBy(xpath = "//*[@id='location_list']//a[contains(@href,'/')]")
    List<WebElement> listOfCity;

    @FindBy(xpath = "//*[@id='type_list']//*[contains(@href,'/')]")
    WebElement rentButtonOfHomes;

    @FindBy(xpath = "//ul[@id='filter_property_type']//li")
    List<WebElement> filtersPropType;

    //String[] country={"au","aucar","auhome","ar","arcar","arhome","br","brcar","brhome","be","becar","behome","ca","cacar","cahome","co","cocar","cohome","cl","clcar","clhome","de","decar","dehome","es","escar","eshome","fr","frcar","frhome","hu","hucar","huhome","idd","idcar","idhome","in","incar","inhome","ir","ircar","irhome","it","itcar","ithome","kz","kzcar","kzhome","mx","mxcar","mxhome","my","mycar","myhome","nl","nlcar","nlhome","ph","phcar","phhome","pk","pkcar","pkhome","pl","plcar","plhome","ro","rocar","rohome","pt","ptcar","pthome","ua","uacar","uahome","uk","ukcar","ukhome","za","zacar","zahome","dk","dkcar","dkhome","se","secar","sehome","no","nocar","nohome"};
    String[] readCountry = {"aucar", "auhome", "arcar", "arhome", "brcar", "brhome", "becar", "behome", "cacar", "cahome", "cocar", "cohome", "clcar", "clhome", "decar", "dehome", "escar", "eshome", "frcar", "frhome", "huhome", "hucar", "idhome", "idcar", "inhome", "incar", "ircar", "irhome", "itcar", "ithome", "kzcar", "kzhome", "mxcar", "mxhome", "myhome", "mycar", "nlcar", "nlhome", "phhome", "phcar", "pkcar", "pkhome", "plcar", "plhome", "rocar", "rohome", "ptcar", "pthome", "uacar", "uahome", "ukcar", "ukhome", "homes", "cars", "zacar", "zahome", "dkcar", "dkhome", "secar", "sehome", "nohome", "nocar"};

    //methods

    public void testMt() {

        driver.get("https://google.com");


        System.out.println(driver.getCurrentUrl());


        // Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty(readCountry[6])));
    }

    //us01
    public void openPage(String url) {
        driver.get(url);

        if (consent.isDisplayed())
            consent.click();

        Assert.assertTrue(waa2Picture.isDisplayed());
        System.out.println(mainPageTitle.getText());

    }

    //us01-tc01
    public void checkmainPageLink() {
        driver.get("https://www.waa2.com");

       homes.click();
       Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty("homes")));
       driver.navigate().back();
       cars.click();
       Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty("cars")));
       driver.navigate().back();
       boats.click();
       Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty("boats")));
    }

    //us02-tc02
    public void checkSaleRentOption() {
        String[] filteredCountries = ReusableMethods.filterCountriesForHomes();
        int j = 0;

        for (int i = 0; i <= 30; i++) {
            if (!countries.get(i).isSelected())
                jsUtils.scrollIntoViewJS(countries.get(i));

            if (i == 0)
                jsUtils.clickElementByJS(countries.get(i));
            else jsUtils.clickElementByJS(countries.get(i - 1));


            System.out.println(ConfigReader.getProperty(filteredCountries[i]) + " test ediliyor");
            if (ConfigReader.getProperty(filteredCountries[i]).contains(car_home.get(0).getText().toLowerCase()))
                car_home.get(0).click();
            else if (i == 12)
                car_home.get(0).click();
            else if (i == 30)
                car_home.get(0).click();
            else car_home.get(1).click();


            softAssert.assertTrue(!listOfPropertyType.isEmpty(),ConfigReader.getProperty(filteredCountries[i])+ " sitesinin sale bölümündeki property_type verisi boş");
            softAssert.assertTrue(!listOfCity.isEmpty(), ConfigReader.getProperty(filteredCountries[i])+" sitesinin sale bölümündeki city verisi boş");
            rentButtonOfHomes.click();
            softAssert.assertTrue(!listOfPropertyType.isEmpty(), ConfigReader.getProperty(filteredCountries[i])+" sitesinin rent bölümündeki property_type verisi boş");
            softAssert.assertTrue(!listOfCity.isEmpty(), ConfigReader.getProperty(filteredCountries[i])+" sitesinin rent bölümündeki city verisi boş");

            driver.navigate().back();

            driver.navigate().back();

        }
        softAssert.assertAll();
    }

    //us02-tc01
    public void checkCountriesURL() {
        int j = 0;
        int sayac = 0;
        for (int i = 0; i < 30; i++) {
            //  if (!countries.get(i).isSelected())
            //      jsUtils.scrollIntoViewJS(countries.get(i));

            jsUtils.clickElementByJS(countries.get(i));

            for (int k = 0; k < 2; k++) {

                car_home.get(k).click();
                Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty(readCountry[j])));
                driver.navigate().back();
                j++;
            }


            while (sayac < 1) {
                i = -1;
                sayac++;
            }
        }
    }

    public void selectCountryAndVertical(String country, String vertical) {

        switch (country) {

            case "belgium":
                jsUtils.clickElementByJS(countries.get(3));
                break;
            case "spain":
                jsUtils.clickElementByJS(countries.get(8));
                break;
            case "kazakhstan":
                jsUtils.clickElementByJS(countries.get(15));
                break;
            case "romania":
                jsUtils.clickElementByJS(countries.get(22));
                break;
            case "ukraine":
                jsUtils.clickElementByJS(countries.get(24));
                break;
            default:
                for (WebElement w : countries) {
                    if (w.getText().toLowerCase().equalsIgnoreCase(country)) {
                        jsUtils.clickElementByJS(w);
                        break;
                    }
                }
                break;

        }

        if (car_home.get(0).getAttribute("class").toLowerCase().contains(vertical))
            car_home.get(0).click();
        else car_home.get(1).click();

    }
}
