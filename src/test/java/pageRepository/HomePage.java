package pageRepository;

import objectRepository.HomePageObjects;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void cookie_accept() {
        HomePageObjects.cookies_accept(driver).click();
    }
    public void cookie_agree() {
        HomePageObjects.cookies_agree(driver).click();
    }
    public void logo() {
        HomePageObjects.logo(driver).isDisplayed();
    }
}
