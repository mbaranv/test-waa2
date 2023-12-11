package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JSUtils {

    public  WebDriver driver;

    public JSUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", element);
    }


    public  String getTitleByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        String title = jsexecutor.executeScript("return document.title;").toString();
        return title;
    }


    public  void scrollDownByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public  void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public  void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public  void changeBackgroundColorByJS(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public  void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 5; i++) {
            changeBackgroundColorByJS("rgb(0,200,0", element);
            changeBackgroundColorByJS(bgColor, element);
        }
    }

    public  void generateAlert(String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("alert('" + message + "')");
        Thread.sleep(3000);
    }


    public  void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);
    }

    public  void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command);
    }



    public  void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }

    public  void getValueByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);

    }
    public  void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }
}
