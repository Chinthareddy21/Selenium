package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

    public static WebElement cookies_accept(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"ccc-notify-accept\"]"));
    }
    public static WebElement cookies_reject(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"ccc-notify-accept\"]"));
    }
    public static WebElement cookies_agree(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']"));
    }
    public static WebElement logo(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"universal-nav-link\"]/a/img"));
    }
    public static WebElement country_and_language(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"universal-nav-country-language-link\"]/a"));
    }
    public static WebElement country(WebDriver driver){
        return driver.findElement(By.xpath("//div[@class='ui search selection fluid dropdown country-dropdown']//i[@class='dropdown icon']"));
    }
    public static WebElement country_edit_box(WebDriver driver){
        return driver.findElement(By.xpath("//input[@class='search']"));
    }
    public static WebElement country_enter(WebDriver driver){
        return driver.findElement(By.xpath("//input[@name='launch-language-selection']"));
    }
    public static WebElement product_hover(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id='dx-navigation']/div[1]/a"));
    }
}
