package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "web.stepdefinitions",
        plugin = {
                "pretty",
                "html:build/reports/cucumber/web-report.html",
                "json:build/reports/cucumber/web-report.json"
        },
        tags = "@web"
)
public class WebTestRunner {
}
