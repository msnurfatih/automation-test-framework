
package web.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String url = "https://www.demoblaze.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public void open() {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isCategoryDisplayed(String categoryName) {
        By category = By.xpath(
                "//a[@id='itemc' and normalize-space()='"
                        + categoryName + "']"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(category)
        ).isDisplayed();
    }

    public void selectFirstAvailableProduct() {
        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#tbodyid .card-title a")
                )
        );

        firstProduct.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h2.name")
                )
        );
    }

    public boolean isProductDetailsDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h2.name")
                )
        ).isDisplayed();
    }

    public String addCurrentProductToCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("a.btn.btn-success.btn-lg")
                )
        ).click();

        Alert alert = wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String message = alert.getText();
        alert.accept();

        return message;
    }

    public void openShoppingCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("cartur")
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#tbodyid tr")
                )
        );
    }

    public boolean cartContainsProduct() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#tbodyid tr")
                )
        ).isDisplayed();
    }

    public void proceedToCheckout() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Place Order']")
                )
        ).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("orderModal")
                )
        );
    }

    public String completeCheckout(
            String name,
            String country,
            String city,
            String card,
            String month,
            String year
    ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name")
        )).sendKeys(name);

        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(card);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Purchase']")
                )
        ).click();

        try {
            Alert alert = new WebDriverWait(
                    driver,
                    Duration.ofSeconds(3)
            ).until(ExpectedConditions.alertIsPresent());

            String confirmation = alert.getText();
            alert.accept();

            return confirmation;

        } catch (TimeoutException e) {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".sweet-alert h2")
                    )
            ).getText();
        }
    }
}
