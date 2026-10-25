package web.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private final String url = "https://www.demoblaze.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
