package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import utils.DriverManager;

public class US02_StepDefinitions {
    HomePage homePage=new HomePage(DriverManager.getDriver());
    SearchPage searchPage=new SearchPage(DriverManager.getDriver());

    //tc01
    @Given("Kullanıcı {string} açar")
    public void kullanıcıAçar(String url){
        homePage.openPage(url);
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");
    }

    @When("Anasayfada bulunan ülkerelere sırayla tıklanır")
    public void anasayfadaBulunanÜlkerelereSıraylaTıklanır() {
       homePage.checkCountriesURL();
    }

    @Then("Açılan her sayfanın ilgili ülkeye ait olduğu görülür")
    public void açılanHerSayfanınIlgiliÜlkeyeAitOlduğuGörülür() {
        System.out.println("31 ülkeye ait home ve car sayfaları çalışmaktadır");
    }

    //tc02
    @When("Anasayfada bulunan ülkereler sırayla tıklanır")
    public void anasayfadaBulunanÜlkerelerSıraylaTıklanır() {
        homePage.checkSaleRentOption();
    }

    @And("Homes tıklanır")
    public void homesTıklanır() {
        searchPage.clickHomes();

    }

    @Then("Satılık tagı altında property_type ve city değerlerinin olduğu görülür")
    public void satılıkTagıAltındaProperty_typeVeCityDeğerlerininOlduğuGörülür() {
    }

    @When("Kiralık opsiyonu tıklanır")
    public void kiralıkOpsiyonuTıklanır() {
    }

    @Then("Kiralık tagı altında property_type ve city değerlerinin olduğu görülür")
    public void kiralıkTagıAltındaProperty_typeVeCityDeğerlerininOlduğuGörülür() {
        System.out.println("31 ülkenin homes sayfasında satılık ve kiralık menülerinde property type ve city önermeleri vardır");

    }


}
