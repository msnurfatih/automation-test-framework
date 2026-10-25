
package web.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import web.pages.HomePage;

public class DemoBlazeSteps {

    private WebDriver driver;
    private HomePage homePage;

    @Given("the user opens the DemoBlaze homepage")
    public void theUserOpensTheDemoBlazeHomepage() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Then("the homepage title should be displayed")
    public void theHomepageTitleShouldBeDisplayed() {
        String title = homePage.getPageTitle();

        Assert.assertNotNull(
                "Homepage title should not be null",
                title
        );

        Assert.assertTrue(
                "Homepage title should contain STORE",
                title.contains("STORE")
        );

    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
