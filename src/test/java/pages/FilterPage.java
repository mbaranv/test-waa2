package pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverManager;
import utils.JSUtils;
import utils.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FilterPage {

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));

    JSUtils jsUtils = new JSUtils(DriverManager.getDriver());

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static int numberOfPropType;

    public static int numberOfCountry;
    public static String keyword;
    public static int priceMin;
    public static int priceMax;
    public static int areaMin;
    public static int areaMax;

    @FindBy(id = "q")
    WebElement searchBar;

    @FindBy(id = "l")
    WebElement locationBar;

    @FindBy(id = "text_search_button")
    WebElement searchButton;

    @FindBy(xpath = "//p[contains(text(),'Year')]/following-sibling::p")
    WebElement year;

    @FindBy(xpath = "//p[contains(text(),'Transmission')]/following-sibling::p")
    WebElement transmissionType;

    @FindBy(xpath = "//p[contains(text(),'fuel')]/following-sibling::p")
    WebElement fuelType;

    @FindBy(xpath = "//div[@class='sub_data']//h4")
    List<WebElement> mileage;

    @FindBy(xpath = "//*[contains(@class,'detail')]")
    List<WebElement> resultList;

    @FindBy(tagName = "h3")
    List<WebElement> resultTitles;

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

    @FindBy(xpath = "//*[@id='type_list']//*[contains(@href,'/')]")
    WebElement rentButtonOfHomes;

    @FindBy(xpath = "//*[contains(@class,'content')]")
    public WebElement resultBox;

    @FindBy(xpath = "//h1")
    public WebElement h1;

    @FindBy(xpath = "//*[contains(@style,'display: block;')]")
    public WebElement alertMessage;

    @FindBy(xpath = "//li[contains(text(),'Today')]")
    public WebElement today;

    @FindBy(xpath = "//li[contains(text(),'large')]")
    WebElement sqftLargestFirst;

    @FindBy(xpath = "//li[contains(text(),'cheapest')]")
    WebElement priceCheapestFirst;

    @FindBy(xpath = "//li[contains(text(),'Lower')]")
    WebElement priceLowerFirst;


    @FindBy(className = "dropdown_layout")
    WebElement orderMenu;

    @FindBy(xpath = "//div[@class='item_content_right']//div[@class='sub_data']//h4")
    List<WebElement> areaResultList;

    @FindBy(xpath = "//span[@class='time']")
    List<WebElement> dateResultList;

    @FindBy(xpath = "//span[contains(text(),'Remove')]")
    WebElement remove;

    @FindBy(xpath = "//h4[@class='attribute']")
    List<WebElement> propertyTypeSection;

    @FindBy(xpath = "//ul[@id='filter_property_type']//li")
    List<WebElement> filtersPropType;

    @FindBy(xpath = "//ul[@id='filter_material']//li")
    List<WebElement> filtersMaterial;

    @FindBy(xpath = "//div[contains(@data-items,'length')]//div")
    List<WebElement> lengthMinMax;

    @FindBy(xpath = "(//div[contains(@data-items,'length')])[1]//li")
    List<WebElement> lengthMinList;

    @FindBy(xpath = "(//div[contains(@data-items,'length')])[2]//li")
    List<WebElement> lengthMaxList;

    @FindBy(xpath = "//ul[@id='filter_country_name']//li")
    List<WebElement> filtersCountries;

    @FindBy(xpath = "//*[@class='result_number']")
    WebElement resultNumber;

    @FindBy(xpath = "//div[contains(@data-items,'year')]//div")
    List<WebElement> yearMinMax;

    @FindBy(xpath = "(//div[contains(@data-items,'year')])[1]//li")
    List<WebElement> yearMinList;

    @FindBy(xpath = "(//div[contains(@data-items,'year')])[2]//li")
    List<WebElement> yearMaxList;

    @FindBy(xpath = "//div[contains(@data-items,'mileage')]//div")
    List<WebElement> mileageMinMax;

    @FindBy(xpath = "(//div[contains(@data-items,'mileage')])[1]//li")
    List<WebElement> mileageMinList;

    @FindBy(xpath = "(//div[contains(@data-items,'mileage')])[2]//li")
    List<WebElement> mileageMaxList;

    @FindBy(xpath = "//div[contains(@data-items,'price')]//div")
    List<WebElement> priceMinMax;

    @FindBy(xpath = "(//div[contains(@data-items,'price')])[1]//li")
    List<WebElement> priceMinList;

    @FindBy(xpath = "(//div[contains(@data-items,'price')])[2]//li")
    List<WebElement> priceMaxList;

    @FindBy(xpath = "//span[@class='price']")
    List<WebElement> priceSection;

    @FindBy(xpath = "//div[@class='sub_data']")
    List<WebElement> lengthSection;

    @FindBy(xpath = "//*[@id='filter_city']//li")
    List<WebElement> filtersState;

    @FindBy(xpath = "//*[@id='filter_district']//li")
    List<WebElement> filtersCity;

    @FindBy(xpath = "//*[@id='filter_transmission']//li")
    List<WebElement> filtersTransmission;

    @FindBy(xpath = "//*[@id='filter_fuel']//li")
    List<WebElement> filtersFuel;


    @FindBy(xpath = "//ul[@id='filter_make']//li")
    List<WebElement> filtersBoatMake;

    @FindBy(xpath = "//ul[@id='filter_model']//li")
    List<WebElement> filtersBoatModel;


    @FindBy(xpath = "//span[@class='location']")
    List<WebElement> locationSection;

    @FindBy(xpath = "//div[contains(@data-items,'area')]//div//p")
    List<WebElement> areaMinMax;

    @FindBy(xpath = "(//div[contains(@data-items,'area')])[1]//li")
    List<WebElement> areaMinList;

    @FindBy(xpath = "(//div[contains(@data-items,'area')])[2]//li")
    List<WebElement> areaMaxList;

    @FindBy(xpath = "//*[@id='rooms_min_opt']//label")
    List<WebElement> selectRoom;

    @FindBy(xpath = "//*[@id='bathrooms_min_opt']//label")
    List<WebElement> selectBathoom;

    @FindBy(xpath = "//*[contains(@class,'d_rooms')]")
    List<WebElement> roomSection;

    @FindBy(xpath = "//*[contains(@class,'d_baths')]")
    List<WebElement> bathroomSection;

    @FindBy(xpath = "//strike[@class='old_price']")
    List<WebElement> oldPrice;


    @FindBy(xpath = "//p[@class='att_bottom']")
    List<WebElement> popupWindowValues;

    @FindBy(xpath = "//h4[@class='attribute']")
    List<WebElement> titleMakeModel;

    @FindBy(xpath = "//*[@id='filter_district']//li[contains(@class,'more')]")
    WebElement moreCity;

    @FindBy(xpath = "//*[@id='filter_city']//li[contains(@class,'more')]")
    WebElement moreState;

    @FindBy(xpath = "//*[@id='filter_property_type']//li[contains(@class,'more')]")
    WebElement moreProp;

    @FindBy(xpath = "//*[@id='filter_body_type']//li[contains(@class,'more')]")
    WebElement moreBodyType;

    @FindBy(xpath = "//*[@id='filter_color']//li[contains(@class,'more')]")
    WebElement moreColor;

    @FindBy(xpath = "//*[@id='filter_country_name']//li[contains(@class,'more')]")
    WebElement moreCountry;

    @FindBy(xpath = "//*[@id='filter_make']//li[contains(@class,'more')]")
    WebElement moreMake;

    @FindBy(xpath = "//*[@id='filter_model']//li[contains(@class,'more')]")
    WebElement moreModel;


    //tc01
    public void selectPublicationDate() {
        today.click();
    }


    public void selectOrderByForHome() {

        jsUtils.clickElementByJS(orderMenu);
        jsUtils.clickElementByJS(sqftLargestFirst);
    }

    public void checkResultForArea() {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < areaResultList.size(); i++) {
            if (!areaResultList.get(i).isDisplayed()) {
                jsUtils.scrollIntoViewJS(areaResultList.get(i));
            }
            String eleman = areaResultList.get(i).getText().replaceAll("[^0-9]", "");
            integerList.add(Integer.parseInt(eleman));
        }
        for (int i = 0; i < integerList.size() - 1; i++) {
            Assert.assertTrue(integerList.get(i) > integerList.get(i + 1));
        }
    }

    //tc02
    public void checkResultForDate() {
        for (int i = 0; i < dateResultList.size(); i++) {
            if (!dateResultList.get(i).isDisplayed()) {
                jsUtils.scrollIntoViewJS(dateResultList.get(i));
            }
            Assert.assertTrue(dateResultList.get(i).getText().contains("hour") || dateResultList.get(i).getText().contains("minute"));
        }
    }


    //tc03

    public void checkResultForPropType() {
        Assert.assertTrue(remove.isDisplayed());

        for (WebElement w : propertyTypeSection) {
            if (!w.isDisplayed())
                jsUtils.scrollIntoViewJS(w);

            Assert.assertTrue(w.getText().toLowerCase().contains(keyword));
        }

    }

    public void checkPropTypeResultNumber() {
        String eleman = resultNumber.getText().replaceAll("[^0-9]", "");
        int numberOfResult = Integer.parseInt(eleman);
        Assert.assertEquals(numberOfResult, numberOfPropType);

    }

    public void selectPropType(String key) {
        jsUtils.clickElementByJS(moreProp);
        String actualValue;
        String expectedValue = key.toLowerCase(); // Aranlılan metin
        int index = -1;

        for (int i = 0; i < filtersPropType.size(); i++) {
            actualValue = (filtersPropType.get(i).getText().toLowerCase()).replaceAll("[^a-zA-Z]", "");
            ;
            if (actualValue.contains(expectedValue)) {
                index = i;
                System.out.println("İstenilen metin bulundu: " + expectedValue + " Index değeri: " + index);
                break;
            }
        }

        keyword = ReusableMethods.extractIllegalChar(filtersPropType.get(index));
        numberOfPropType = ReusableMethods.convertStringToInt(filtersPropType.get(index));
        jsUtils.clickElementByJS(filtersPropType.get(index));

    }

    //tc04
    public void selectPrice(String key1, String key2) {
        int index = -1;
        String actualValue;

        for (int i = 0; i <= 1; i++) {

            jsUtils.clickElementByJS(priceMinMax.get(i));
            for (int k = 0; k < priceMinList.size(); k++) {
                actualValue = priceMinList.get(k).getAttribute("value");
                switch (i) {

                    case 0:
                        if (actualValue.equalsIgnoreCase(key1)) {
                            index = k;
                            System.out.println("İstenilen metin bulundu: " + key1 + " Index değeri: " + index);
                            jsUtils.clickElementByJS(priceMinList.get(k));
                            wait.until(ExpectedConditions.elementToBeClickable(priceMinMax.get(1)));
                            priceMin = Integer.parseInt(key1);
                            break;
                        }
                        break;
                    case 1:
                        if (actualValue.equalsIgnoreCase(key2)) {
                            index = k;
                            System.out.println("İstenilen metin bulundu: " + key2 + " Index değeri: " + index);
                            jsUtils.clickElementByJS(priceMaxList.get(k));
                            priceMax = Integer.parseInt(key2);
                            break;
                        }
                        break;
                }
            }
        }


    }

    public void checkResultForPrice(String min, String max) {


        int minPrice = Integer.parseInt(min);
        int maxPrice = Integer.parseInt(max);

        if (maxPrice == minPrice) {
            for (WebElement w : priceSection) {
                jsUtils.scrollIntoViewJS(w);
                Assert.assertEquals(ReusableMethods.convertStringToInt(w), priceMin);
            }
        } else {
            for (int i = 0; i < 20; i++) {
                jsUtils.scrollIntoViewJS(priceSection.get(i));
                System.out.println(i);
                Assert.assertTrue(minPrice <= ReusableMethods.convertStringToInt(priceSection.get(i)) &&
                        ReusableMethods.convertStringToInt(priceSection.get(i)) <= maxPrice);
            }
        }


    }

    //tc05
    public void selectState(String key) {
        jsUtils.clickElementByJS(moreState);
        String actualValue;
        String expectedValue = key.toLowerCase();

        for (WebElement elm : filtersState) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }
    }

    public void selectCity(String key) {
        jsUtils.clickElementByJS(moreCity);
        String actualValue;
        String expectedValue = key.toLowerCase();

        for (WebElement elm : filtersCity) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }
    }

    public void checkResultForLocation(String state, String city) {
        for (int i = 0; i < 20; i++) {
            jsUtils.scrollIntoViewJS(locationSection.get(i));
            Assert.assertTrue(locationSection.get(i).getText().toLowerCase().contains(state + " - " + city));
        }
    }

    //tc06
    public void selectM2(String min, String max) {
        int index = -1;
        String actualValue;


        for (int i = 0; i <= 1; i++) {
            jsUtils.clickElementByJS(areaMinMax.get(i));
            for (int k = 0; k < areaMinList.size(); k++) {
                actualValue = areaMinList.get(k).getAttribute("value");
                System.out.println(actualValue);
                switch (i) {

                    case 0:
                        if (actualValue.equalsIgnoreCase(min)) {
                            index = k;
                            System.out.println("İstenilen metin bulundu: " + min + " Index değeri: " + index);
                            jsUtils.clickElementByJS(areaMinList.get(k));
                            wait.until(ExpectedConditions.elementToBeClickable(areaMinMax.get(1)));
                            areaMin = Integer.parseInt(min);
                            break;
                        }
                        break;
                    case 1:
                        if (actualValue.equalsIgnoreCase(max)) {
                            index = k;
                            System.out.println("İstenilen metin bulundu: " + max + " Index değeri: " + index);
                            jsUtils.clickElementByJS(areaMaxList.get(k));
                            areaMax = Integer.parseInt(max);
                            break;
                        }
                        break;
                }
            }
        }

    }

    public void checkResultForAreaFilter(String min, String max) {

        int expectedValueMin = Integer.parseInt(min);
        int expectedValueMax = Integer.parseInt(max);


        for (int i = 0; i < 20; i++) {
            jsUtils.scrollIntoViewJS(areaResultList.get(i));
            Assert.assertTrue(expectedValueMin <= ReusableMethods.convertStringToInt(areaResultList.get(i))
                    && ReusableMethods.convertStringToInt(areaResultList.get(i)) <= expectedValueMax);
        }
    }

    public void selectRoomAndBathroom(String room, String bathroom) {
        int choosenRoom;

        for (WebElement elm : selectRoom) {
            if (elm.getText().contains(room)) {
                choosenRoom = ReusableMethods.convertStringToInt(elm);
                jsUtils.clickElementByJS(selectRoom.get(choosenRoom));
                break;
            }
        }

        for (WebElement elm : selectBathoom) {
            if (elm.getText().contains(bathroom)) {
                choosenRoom = ReusableMethods.convertStringToInt(elm);
                jsUtils.clickElementByJS(selectBathoom.get(choosenRoom));
                break;
            }
        }
    }

    public void checkResultForRooms(String room, String bathroom) {

        for (int i = 0; i < 20; i++) {
            jsUtils.scrollIntoViewJS(roomSection.get(i));
            Assert.assertTrue(Integer.parseInt(room) <= ReusableMethods.convertStringToInt(roomSection.get(i)) &&
                    Integer.parseInt(bathroom) <= ReusableMethods.convertStringToInt(bathroomSection.get(i)));
        }

    }

    public void checkChoosenLoc(String state, String city) {
        Assert.assertTrue(filtersState.get(0).getText().contains("Remove") && filtersState.get(0).getText().toLowerCase().contains(state));
        Assert.assertTrue(filtersCity.get(0).getText().contains("Remove") && filtersCity.get(0).getText().toLowerCase().contains(city));
    }

    public void checkChoosenPropType(String key) {
        Assert.assertTrue(filtersPropType.get(0).getText().contains("Remove") && filtersPropType.get(0).getText().toLowerCase().contains(key));
    }

    //us07-tc01
    public void selectOrderByForCar() {
        orderMenu.click();
        priceCheapestFirst.click();
    }

    public void checkPriceAfterOrder() {
        List<Integer> allPrice = new ArrayList<>();//sıralama kontrolü için ilan fiyatları listte toplanacak
        int result;
        for (int i = 0; i < priceSection.size(); i++) {//Görüntülenen her ilan kontrol ediliyor
            String newPrice = "";

            for (int k = 0; k < oldPrice.size(); k++) {//çift fiyat yazan ilanların indirimsiz fiyatları listte toplanıyor
                if (priceSection.get(i).getText().contains(oldPrice.get(k).getText()) &&
                        !priceSection.get(i).getText().trim().equalsIgnoreCase(oldPrice.get(k).getText().trim())) {//ilan fiyatı indirimsiz fiyatıda içeriyorsa indirimsiz fiyat string içinden atılıyor
                    newPrice = priceSection.get(i).getText().replace(oldPrice.get(k).getText(), "");//yeni string değer variabla atandı
                    break;
                }
            }

            if (!newPrice.isEmpty())//ilk olarak boş tanımlanan newprice değeri eğer if döngüsünde değer aldıysa karşılaştırmanın yapılacağı int liste ,içindeki indirimsiz fiyat atılarak eklencek
                result = Integer.parseInt(newPrice.replaceAll("[^0-9]", ""));
            else {//tek fiyat varsa ilanda normal dönüşüm yapılıp liste eklencek
                result = Integer.parseInt(priceSection.get(i).getText().replaceAll("[^0-9]", ""));

            }
            allPrice.add(result);
        }
        for (int i = 0; i < allPrice.size() - 1; i++) {//ilan fiyatının bir sonraki ilan fiyatıyla kıyaslaması
            Assert.assertTrue(allPrice.get(i) <= allPrice.get(i + 1));
        }
    }


    public void checkResultForPriceV2(String min, String max) {
        int result = 0;
        for (int i = 0; i < priceSection.size(); i++) {//Görüntülenen her ilan kontrol ediliyor
            // System.out.println("pricesection= " + priceSection.get(i).getText());
            String newPrice = "";
            // System.out.println(oldPrice.size());

            for (int k = 0; k < oldPrice.size(); k++) {//çift fiyat yazan ilanların indirimsiz fiyatları listte toplanıyor
                if (priceSection.get(i).getText().contains(oldPrice.get(k).getText()) &&
                        !priceSection.get(i).getText().trim().equalsIgnoreCase(oldPrice.get(k).getText().trim())) {//ilan fiyatı indirimsiz fiyatıda içeriyorsa indirimsiz fiyat string içinden atılıyor
                    newPrice = priceSection.get(i).getText().replace(oldPrice.get(k).getText(), "");//yeni string değer variabla atandı
                    System.out.println("newprice= " + newPrice);
                    break;
                }
            }

            if (!newPrice.isEmpty())//ilk olarak boş tanımlanan newprice değeri eğer if döngüsünde değer aldıysa karşılaştırmanın yapılacağı int liste ,içindeki indirimsiz fiyat atılarak eklencek
                result = Integer.parseInt(newPrice.replaceAll("[^0-9]", ""));
            else {//tek fiyat varsa ilanda normal dönüşüm yapılıp liste eklencek
                result = Integer.parseInt(priceSection.get(i).getText().replaceAll("[^0-9]", ""));

            }
        }


        int minPrice = Integer.parseInt(min);
        int maxPrice = Integer.parseInt(max);

        if (maxPrice == minPrice) {
            for (WebElement w : priceSection) {
                jsUtils.scrollIntoViewJS(w);
                Assert.assertEquals(ReusableMethods.convertStringToInt(w), priceMin);
            }
        } else {
            for (int i = 0; i < 20; i++) {
                jsUtils.scrollIntoViewJS(priceSection.get(i));
                //   System.out.println(result);
                Assert.assertTrue(minPrice <= result && result <= maxPrice);
            }
        }
    }

    //us09-tc03
    public void selectCountry(String country) {
        jsUtils.clickElementByJS(moreCountry);
        String actualValue;
        String expectedValue = country.toLowerCase(); // Aranlılan metin
        int index = -1;

        for (int i = 0; i < filtersCountries.size(); i++) {
            actualValue = (filtersCountries.get(i).getText().toLowerCase()).replaceAll("[^a-zA-Z]", "");
            ;
            if (actualValue.contains(expectedValue)) {
                index = i;
                System.out.println("İstenilen metin bulundu: " + expectedValue + " Index değeri: " + index);
                break;
            }
        }

        keyword = ReusableMethods.extractIllegalChar(filtersCountries.get(index));
        numberOfCountry = ReusableMethods.convertStringToInt(filtersCountries.get(index));
        jsUtils.clickElementByJS(filtersCountries.get(index));

    }

    public void checkCountryResultNumber() {
        String eleman = resultNumber.getText().replaceAll("[^0-9]", "");
        int numberOfResult = Integer.parseInt(eleman);
        // Assert.assertEquals(numberOfResult, numberOfCountry);
    }


    public void checkResultForChoosenValue(String country) {

        String anaPencereHandle = driver.getWindowHandle();
        boolean flag = false;

        for (int i = 0; i < resultList.size(); i++) {
            Set<String> tumPencereHandles = driver.getWindowHandles();
            System.out.println(i);
            jsUtils.clickElementByJS(resultList.get(i));
            for (String pencereHandle : tumPencereHandles) {
                if (!pencereHandle.equals(anaPencereHandle)) {
                    driver.switchTo().window(pencereHandle);

                    for (WebElement w : popupWindowValues) {
                        if (w.getText().toLowerCase().contains(country)) {
                            Assert.assertTrue(w.getText().toLowerCase().contains(country));
                            flag = true;
                            break;
                        }
                    }

                    if (!flag)
                        Assert.fail(i + " indexdeki ilan bilgileri istenilen değeri içermemektedir");

                    driver.close();
                }
            }
            driver.switchTo().window(anaPencereHandle);
        }
    }

    //us09-tc04
    public void selectMaterial(String material) throws InterruptedException {
        Thread.sleep(2000);
        String actualValue;
        String expectedValue = material.toLowerCase();

        for (WebElement elm : filtersMaterial) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }
    }

    public void selectLength(String min, String max) {
        int index = -1;
        String actualValue;

        for (int i = 0; i <= 1; i++) {

            jsUtils.clickElementByJS(lengthMinMax.get(i));
            for (int k = 0; k < lengthMinList.size(); k++) {
                actualValue = lengthMinList.get(k).getAttribute("value");
                switch (i) {

                    case 0:
                        if (actualValue.equalsIgnoreCase(min)) {
                            index = k;
                            System.out.println("İstenilen metin bulundu: " + min + " Index değeri: " + index);
                            jsUtils.clickElementByJS(lengthMinList.get(k));
                            wait.until(ExpectedConditions.elementToBeClickable(lengthMinMax.get(1)));
                            break;
                        }
                        break;
                    case 1:
                        if (actualValue.equalsIgnoreCase(max)) {
                            index = k;
                            System.out.println("İstenilen metin bulundu: " + max + " Index değeri: " + index);
                            jsUtils.clickElementByJS(lengthMaxList.get(k));
                            break;
                        }
                        break;
                }
            }
        }
    }

    public void selectOrderByForBoat() {
        jsUtils.clickElementByJS(orderMenu);
        jsUtils.clickElementByJS(priceLowerFirst);
    }

    public void checkResultForChoosenMultiValue(String country, String material) {
        String anaPencereHandle = driver.getWindowHandle();
        boolean flag = false;

        for (int i = 0; i < resultList.size(); i++) {
            Set<String> tumPencereHandles = driver.getWindowHandles();
            System.out.println(i);
            jsUtils.clickElementByJS(resultList.get(i));
            for (String pencereHandle : tumPencereHandles) {
                if (!pencereHandle.equals(anaPencereHandle)) {
                    driver.switchTo().window(pencereHandle);

                    for (WebElement w : popupWindowValues) {
                        if (w.getText().toLowerCase().contains(country)) {
                            Assert.assertTrue(w.getText().toLowerCase().contains(country));
                            flag = true;
                            break;
                        }
                    }

                    if (!flag)
                        Assert.fail(i + " indexdeki ilan bilgileri istenilen değeri içermemektedir");

                    flag = false;
                    for (WebElement w : popupWindowValues) {
                        if (w.getText().toLowerCase().contains(material)) {
                            Assert.assertTrue(w.getText().toLowerCase().contains(material));
                            flag = true;
                            break;
                        }
                    }

                    if (!flag)
                        Assert.fail(i + " indexdeki ilan bilgileri istenilen değeri içermemektedir");

                    driver.close();
                }
            }
            driver.switchTo().window(anaPencereHandle);
        }
    }

    public void checkResultForLength(String min, String max) {

        int minLength = Integer.parseInt(min);
        int maxLength = Integer.parseInt(max);

        for (int i = 0; i < 20; i++) {
            jsUtils.scrollIntoViewJS(lengthSection.get(i));
            Assert.assertTrue(minLength <= ReusableMethods.convertStringToInt(lengthSection.get(i)) &&
                    ReusableMethods.convertStringToInt(lengthSection.get(i)) <= maxLength);
        }
    }

    public void selectBoatMake(String make) {
        jsUtils.clickElementByJS(moreMake);
        String actualValue;
        String expectedValue = make.toLowerCase();

        for (WebElement elm : filtersBoatMake) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }
    }

    public void selectBoatModel(String model) {
        jsUtils.clickElementByJS(moreModel);
        String actualValue;
        String expectedValue = model.toLowerCase();

        for (WebElement elm : filtersBoatModel) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }
    }

    //us07-tc02
    public void checkResultForTitle(String make, String model) {

        for (WebElement w : resultTitles) {
            Assert.assertTrue(w.getText().toLowerCase().contains(make));
            Assert.assertTrue(w.getText().toLowerCase().contains(model));
        }
    }

    public void checkResultForMakeModel(String make, String model) {

        for (WebElement w : titleMakeModel) {
            System.out.println(1);
            Assert.assertTrue(w.getText().toLowerCase().contains(make + " " + model));
        }
    }

    //us07-tc03
    public void selectYear(String min, String max) {

        for (WebElement w : yearMinList) {
            if (w.getText().contains(min)) {
                jsUtils.clickElementByJS(yearMinMax.get(0));
                jsUtils.clickElementByJS(w);
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(yearMinMax.get(1)));

        for (WebElement w : yearMaxList) {
            if (w.getText().contains(max)) {
                jsUtils.clickElementByJS(yearMinMax.get(1));
                jsUtils.clickElementByJS(w);
                break;
            }
        }

    }

    public void checkResultForYear(String min, String max) {

        String anaPencereHandle = driver.getWindowHandle();

        for (int i = 0; i < resultList.size(); i++) {
            Set<String> tumPencereHandles = driver.getWindowHandles();
            jsUtils.clickElementByJS(resultList.get(i));
            for (String pencereHandle : tumPencereHandles) {
                if (!pencereHandle.equals(anaPencereHandle)) {
                    driver.switchTo().window(pencereHandle);

                    System.out.println(year.getText());
                    Assert.assertTrue(Integer.parseInt(min) <= Integer.parseInt(year.getText()) &&
                            Integer.parseInt(year.getText()) <= Integer.parseInt(max), "Yıl verisi eksik veya hatalı");

                    driver.close();
                }
            }
            driver.switchTo().window(anaPencereHandle);
        }

    }

    public void selectMileage(String min, String max) {


        for (WebElement w : mileageMinList) {
            if (w.getAttribute("value").contains(min)) {
                jsUtils.clickElementByJS(mileageMinMax.get(0));
                jsUtils.clickElementByJS(w);
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(mileageMinMax.get(1)));

        for (WebElement w : mileageMaxList) {
            if (w.getAttribute("value").contains(max)) {
                jsUtils.clickElementByJS(mileageMinMax.get(1));
                jsUtils.clickElementByJS(w);
                break;
            }
        }
    }

    public void checkResultForMileage(String min, String max) {
        int expectedValueMin = Integer.parseInt(min);
        int expectedValueMax = Integer.parseInt(max);


        for (int i = 0; i < 20; i++) {
            jsUtils.scrollIntoViewJS(mileage.get(i));
            System.out.println("mil " + mileage.get(i).getText());
            Assert.assertTrue(expectedValueMin <= ReusableMethods.convertStringToInt(mileage.get(i))
                    && ReusableMethods.convertStringToInt(mileage.get(i)) <= expectedValueMax);
        }

    }

    public void checkResultForChoosenMultiValue2(String transmission, String fuel) {
        String anaPencereHandle = driver.getWindowHandle();

        for (int i = 0; i < resultList.size(); i++) {
            Set<String> tumPencereHandles = driver.getWindowHandles();
            jsUtils.clickElementByJS(resultList.get(i));
            for (String pencereHandle : tumPencereHandles) {
                if (!pencereHandle.equals(anaPencereHandle)) {
                    driver.switchTo().window(pencereHandle);

                    Assert.assertTrue(transmissionType.getText().toLowerCase().contains(transmission));
                    Assert.assertTrue(fuelType.getText().toLowerCase().contains(fuel));

                    driver.close();
                }
            }
            driver.switchTo().window(anaPencereHandle);
        }
    }

    public void selectTransmission(String key) {
        String actualValue;
        String expectedValue = key.toLowerCase();

        for (WebElement elm : filtersTransmission) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }
    }

    public void selectFuel(String key) {
        String actualValue;
        String expectedValue = key.toLowerCase();

        for (WebElement elm : filtersFuel) {
            actualValue = elm.getText().toLowerCase();
            if (actualValue.contains(expectedValue)) {
                jsUtils.clickElementByJS(elm);
                break;
            }
        }

    }
}