package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static url.URL_S.base;

public class HomePageTests {
    private static WebDriver driver = null;

    @BeforeMethod
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
        extentReports.HomePageReporters Cookie_Report = new extentReports.HomePageReporters(driver);

        Cookie_Report.cookieCheckReporter();
    }

    @Test(priority = 2)
    public void logoCheck() {
        extentReports.HomePageReporters Cookie_Report = new extentReports.HomePageReporters(driver);
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        Home_page.cookie_agree();
        Cookie_Report.logoCheckReporter();
    }

    @Test(priority = 3)
    public void changeCountry(){
        extentReports.HomePageReporters Cookie_Report = new extentReports.HomePageReporters(driver);
        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        Home_page.cookie_agree();
        Cookie_Report.countryChangeReporter();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
