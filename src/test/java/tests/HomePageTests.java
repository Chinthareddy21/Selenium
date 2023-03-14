package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static url.URL_S.base;

public class HomePageTests {
    private static WebDriver driver = null;

    @BeforeTest
    public void setUp() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+ "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        driver.get(base());
        Home_page.cookie_accept();
    }

    @Test(priority = 1)
    public void cookieCheck(){
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.cookie_check();
    }

    @Test(priority = 2)
    public void logoCheck() {
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.cookie_agree();
        Home_page.logo();
    }

    @Test(priority = 3)
    public void changeCountry(){
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.cookie_agree();
        Home_page.country_change();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
