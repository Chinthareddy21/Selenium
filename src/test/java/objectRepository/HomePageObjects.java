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
}
