package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utils.DriverManager;
import utils.ReusableMethods;


import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {


        System.out.println("Senaryo basladi");
        System.out.println("scenario id si=" + scenario.getId());
        System.out.println("scenario name=" + scenario.getName());

    }


    @After
    public void tearDown(Scenario scenario)  {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Screenshots");

        //    ReusableMethods.emailSender();
        }
        DriverManager.closeDriver();
    }


}