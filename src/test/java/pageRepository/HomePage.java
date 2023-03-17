package pageRepository;

import objectRepository.HomePageObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static credentials.HomePage_credentials.country;
import static tests.HomePageTests.*;


public class HomePage {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void cookie_accept() {
        HomePageObjects.cookies_accept(driver).click();

    }
    public void cookie_agree() {
        if(HomePageObjects.cookies_agree(driver).isDisplayed()){
            test.pass("Cookie agree message is displayed");
            log.info("Agree cookies message is displayed");
        } else {
            test.fail("Cookie  agree message is not displayed");
            log.info("Agree cookies message is not displayed");
        }
        HomePageObjects.cookies_agree(driver).click();
    }
    public void logo() {
        HomePageObjects.logo(driver).isDisplayed();
        if(HomePageObjects.logo(driver).isDisplayed()){
            test.pass("Logo is displayed");
            log.info("Logo is visible");
        } else {
            test.fail("Logo is not displayed");
            log.info("Logo is not visible");
        }
    }

    public void country_change(){
        HomePageObjects.country_and_language(driver).click();
        HomePageObjects.country(driver).click();
        HomePageObjects.country_edit_box(driver).sendKeys(country());
        HomePageObjects.country_enter(driver).click();
        HomePageObjects.product_hover(driver).isDisplayed();
        try{
            HomePageObjects.logo(driver).isDisplayed();
            test.pass("Country is changed");
            log.info("Products option is visible");
        } catch (Exception e){
            test.fail("country is not displayed");
            log.info("Products option is not visible");
        }
    }
    public void firstComponentIsAfterNavigation_bar(){
        Actions actions = new Actions(driver);
        HomePageObjects.product_hover(driver).isDisplayed();
        actions.moveToElement(HomePageObjects.product_hover(driver)).perform();
        if(HomePageObjects.product_hover(driver).isDisplayed()){
            test.pass("First component is next to navigation bar");
            log.info("First component is next to navigation bar");
        } else {
            test.fail("First component is not next to navigation bar");
            log.info("First component is not next to navigation bar");
        }
    }
}
