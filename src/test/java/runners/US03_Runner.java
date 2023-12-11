package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/us03.feature",
        tags = "@tc03",
        glue = {"stepdefinitions","hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reportsUI.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        }

)
public class US03_Runner extends AbstractTestNGCucumberTests {
}
