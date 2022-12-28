package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/cucumber/test.feature"},
        glue = {"cucumber"},
        plugin={"html:test-output\\cucumber-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {

}

