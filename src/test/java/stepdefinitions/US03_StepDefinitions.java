package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CorporatePage;
import pages.HomePage;
import utils.DriverManager;

public class US03_StepDefinitions {
    CorporatePage corporatePage = new CorporatePage(DriverManager.getDriver());

    //tc01
    @Then("Kullanıcı add your listinge tıkladıgında Get listed on Waa2 yazısı görülmelidir")
    public void kullanıcıAddYourListingeTıkladıgındaGetListedOnWaaYazısıGörülmelidir() {
        corporatePage.checkAddYourListingButton();
    }

    @Then("Home için Learn More tıkladığında Homes yazısı görülmelidir")
    public void homeIçinLearnMoreTıkladığındaHomesYazısıGörülmelidir() {
        corporatePage.checkHomeLearnMoreButton();
    }

    @Then("Homes mimarisi için Feed Structure tıkladığında Structure yazısı görülmelidir")
    public void homesMimarisiIçinFeedStructureTıkladığındaStructureYazısıGörülmelidir() {
        corporatePage.checkFeedStructure();
        Assert.assertEquals(corporatePage.questionBox.getText(), "Structure", "Structure aktif durumdadır");

    }

    @When("Get Listed on Waa2 tıklanır")
    public void getListedOnWaaTıklanır() {
        corporatePage.clickgetListenOnWaa2();
    }

    @And("Car için Learn More tıklanır")
    public void carIçinLearnMoreTıklanır() {
        corporatePage.checkCarLearnMoreButton();
    }

    @Then("Açılan sayfada Cars bilgi kısmı görülür")
    public void açılanSayfadaCarsBilgiKısmıGörülür() {
        Assert.assertEquals(corporatePage.questionBox.getText(), "Cars", "Cars aktif durumdadır");
    }

    @Then("Cars mimarisi için Feed Stracture tıkladığında Structure kısmı görülür")
    public void carsMimarisiIçinFeedStractureTıkladığındaStructureKısmıGörülür() {
        corporatePage.checkFeedStructure();
        Assert.assertEquals(corporatePage.questionBox.getText(), "Structure", "Structure aktif durumdadır");
    }

    @And("Boat için Learn More tıklanır")
    public void boatIçinLearnMoreTıklanır() {
        corporatePage.clickgetListenOnWaa2();
        corporatePage.checkBoatLearnMoreButton();

    }

    @Then("Açılan sayfada Boats bilgi kısmı görülür")
    public void açılanSayfadaBoatsBilgiKısmıGörülür() {
        Assert.assertEquals(corporatePage.questionBox.getText(), "Boats", "Boats aktif durumdadır");

    }

    @Then("Boats mimarisi için Feed Stracture tıklandığında Structure kısmı görülür")
    public void boatsMimarisiIçinFeedStractureTıklandığındaStructureKısmıGörülür() {
        corporatePage.checkFeedStructure();
        Assert.assertEquals(corporatePage.questionBox.getText(), "Structure", "Structure aktif durumdadır");
    }

    //tc02
    @When("Sayfa altında bulunan Terms of privacy tıklanır")
    public void sayfaAltındaBulunanTermsOfPrivacyTıklanır() {
        corporatePage.checkTermsOfPrivacyButton();
    }

    @Then("Waa2 Privacy Policy görülür")
    public void waaPrivacyPolicyGörülür() {
        Assert.assertEquals(corporatePage.questionBox.getText(), "Privacy Policy", "Privacy Policy aktif durumda");
    }

    @When("Sayfa altında bulunan Terms of use tıklanır")
    public void sayfaAltındaBulunanTermsOfUseTıklanır() {
        corporatePage.clickTermOfUse();
    }

    @Then("Waa2 Terms Of Use görülür")
    public void waaTermsOfUseGörülür() {
        Assert.assertEquals(corporatePage.questionBox.getText(), "Terms Of Use", "Terms Of Use aktif durumda");
    }

    @When("About us tıklanır")
    public void aboutUsTıklanır() {
        corporatePage.clickAboutUs();
    }

    @Then("Our Mission görülür")
    public void ourMissionGörülür() {
        Assert.assertEquals(DriverManager.getDriver().findElement(By.className("box")).getText(), "About Us", "About Us aktif durumda");

    }

    //tc03
    @When("{string} tıklanır")
    public void tıklanır(String key) {
        corporatePage.clickSocialMediaIkon(key);
    }

    @Then("Açılan sayfanın {string} olduğu görülür")
    public void açılanSayfanınOlduğuGörülür(String key) {
        try {
            Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(key),"Sayfa açılamadı");
            throw new Exception("Sayfa açılamadı");
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            System.out.println(e.getMessage());

        }

    }
}
