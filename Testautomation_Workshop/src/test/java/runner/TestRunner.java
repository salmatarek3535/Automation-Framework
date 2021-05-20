package runner;

import base.BaseTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import reporting.CucumberReporting;

@CucumberOptions(features = "src/test/java/features", glue = {"stepsDefinitions"}, plugin = {"pretty","json:target/cucumber.json"})
public class TestRunner extends BaseTests
{
    @AfterSuite
    public void reporting()
    {
        CucumberReporting.generateReport();
    }

}
