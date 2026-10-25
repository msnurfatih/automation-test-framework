package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "api.stepdefinitions",
        plugin = {
                "pretty",
                "html:build/reports/cucumber/api-report.html",
                "json:build/reports/cucumber/api-report.json"
        },
        tags = "@api"
)
public class ApiTestRunner {
}
