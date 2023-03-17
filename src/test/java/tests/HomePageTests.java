package tests;

import extentReports.HomePageReporters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static url.URL_S.base;

public class HomePageTests {
    private static WebDriver driver;
    private static final Logger log = LogManager.getLogger(HomePageReporters.class);

    @BeforeMethod
    public void setUp() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+ "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        log.info("Chrome driver set up completed");
        log.info("Chrome browser started");

        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        driver.get(base());
        log.info("Home page loaded successfully");
        Home_page.cookie_accept();
        log.info("Accepted cookies");
    }

    @Test(priority = 1)
    public void cookieCheck(){
        extentReports.HomePageReporters Cookie_Report = new extentReports.HomePageReporters(driver);

        Cookie_Report.cookieCheckReporter();
    }

    @Test(priority = 2)
    public void logoCheck() {
        extentReports.HomePageReporters Logo = new extentReports.HomePageReporters(driver);

        Logo.logoCheckReporter();
    }

    @Test(priority = 3)
    public void changeCountry(){
        extentReports.HomePageReporters Country_change = new extentReports.HomePageReporters(driver);

        Country_change.countryChangeReporter();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        log.info("Closing chrome browser");
        driver.quit();
        log.info("closing all running browsers");
    }
}
