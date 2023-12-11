package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.DriverManager;

public class US01_StepDefinitions {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @Given("Kullanıcı {string} açtığında sayfadaki logo ve title görünür olmalıdır")
    public void kullanıcıAçtığındaSayfadakiLogoVeTitleGörünürOlmalıdır(String key){
        homePage.openPage(key);
    }

    @Then("Homes cars ve boats linkleri tıklanır ve çalıştığı kontrol edilir")
    public void homesCarsVeBoatsLinkleriTıklanırVeÇalıştığıKontrolEdilir() {
     //   homePage.checkmainPageLink();
    }


}
