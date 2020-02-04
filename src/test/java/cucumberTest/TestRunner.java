package cucumberTest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


/*@CucumberOptions(features ="Features", glue={"stepDefinition"},plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" }
          ,tags= {"@Smoke"})*/


@CucumberOptions(features ="Features", glue={"stepDefinition"},plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
        "html:target/cucumber-reports","json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt"}
          ,tags= {"@Smoke"})


public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    
}