package pageRepository;

import objectRepository.HomePageObjects;
import org.openqa.selenium.WebDriver;

import static credentials.HomePage_credentials.country;

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
    public void cookie_check(){

        HomePageObjects.cookies_agree(driver).isDisplayed();
    }
    public void country_change(){
        HomePageObjects.country_and_language(driver).click();
        HomePageObjects.country(driver).click();
        HomePageObjects.country_edit_box(driver).sendKeys(country());
        HomePageObjects.country_enter(driver).click();
    }
}
