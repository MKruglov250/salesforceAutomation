package Cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Cucumber/steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}