package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resource/feature",
        glue = {"stepdefination"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html"
        },
        tags = "@login",
        monochrome = true,
        dryRun = false
)
public class TestRunner {
}
