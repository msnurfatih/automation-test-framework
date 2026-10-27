
package web.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import web.pages.HomePage;

public class DemoBlazeSteps {

    private WebDriver driver;
    private HomePage homePage;
    private String orderConfirmation;

    @Given("the user opens the DemoBlaze homepage")
    public void theUserOpensTheDemoBlazeHomepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
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

    @Then("the {string} category should be displayed")
    public void theCategoryShouldBeDisplayed(String categoryName) {
        Assert.assertTrue(
                "Category " + categoryName + " should be displayed",
                homePage.isCategoryDisplayed(categoryName)
        );
    }

    @When("the user selects the first available product")
    public void theUserSelectsTheFirstAvailableProduct() {
        homePage.selectFirstAvailableProduct();
    }

    @Then("the product details should be displayed")
    public void theProductDetailsShouldBeDisplayed() {
        Assert.assertTrue(
                "Product details should be displayed",
                homePage.isProductDetailsDisplayed()
        );
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        String message = homePage.addCurrentProductToCart();

        Assert.assertTrue(
                "Expected the Product added confirmation",
                message.contains("Product added")
        );
    }

    @When("the user opens the shopping cart")
    public void theUserOpensTheShoppingCart() {
        homePage.openShoppingCart();
    }

    @Then("the shopping cart should contain a product")
    public void theShoppingCartShouldContainAProduct() {
        Assert.assertTrue(
                "The shopping cart should contain a product",
                homePage.cartContainsProduct()
        );
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        homePage.proceedToCheckout();
    }

    @When(
            "the user completes checkout with name {string}, country {string}, "
                    + "city {string}, card {string}, month {string}, and year {string}"
    )
    public void theUserCompletesCheckout(
            String name,
            String country,
            String city,
            String card,
            String month,
            String year
    ) {
        orderConfirmation = homePage.completeCheckout(
                name,
                country,
                city,
                card,
                month,
                year
        );
    }

    @Then("the order confirmation should be displayed")
    public void theOrderConfirmationShouldBeDisplayed() {
        Assert.assertNotNull(
                "Order confirmation should not be null",
                orderConfirmation
        );

        Assert.assertTrue(
                "Expected successful purchase confirmation",
                orderConfirmation.contains("Thank you for your purchase!")
        );
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
