package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static url.URL_S.base;

public class HomePageTests {
    private static WebDriver driver = null;
    ExtentReports extent;
    ExtentSparkReporter spark;

    @BeforeMethod
    public void setUp() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+ "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);

        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        driver.get(base());
        Home_page.cookie_accept();
    }

    @Test(priority = 1)
    public void cookieCheck(){
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.cookie_check();
        driver.close();
    }

    @Test(priority = 2)
    public void logoCheck() {
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.cookie_agree();
        Home_page.logo();
        driver.close();
    }

    @Test(priority = 3)
    public void changeCountry(){
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);
        Home_page.cookie_agree();
        Home_page.country_change();
        driver.close();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
