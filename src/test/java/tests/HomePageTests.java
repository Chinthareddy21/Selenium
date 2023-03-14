package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTests {
    private static WebDriver driver = null;

    @BeforeTest
    public void setUp() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+ "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        driver.get("https://www.beckmancoulter.com/");
        Home_page.cookie_accept();
        Home_page.cookie_agree();
    }

    @Test
    public void logoCheck() {
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.logo();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
