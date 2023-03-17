package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static url.URL_S.base;

public class HomePageTests {
    private static WebDriver driver;
    private static final Logger log = LogManager.getLogger(HomePageTests.class);
    private static ExtentReports extent;
    public static ExtentTest test;
    @BeforeTest
    public void setUp() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("sparkReports/HomePageReport.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        test = extent.createTest("Homepage_tests");


        WebDriverManager .chromedriver().setup();
        driver = new ChromeDriver();
        log.info("Chrome driver set up completed");
        log.info("Chrome browser started");

        pageRepository.HomePage Home_page = new pageRepository.HomePage(driver);

        driver.get(base());
        log.info("Home page loaded successfully");
        Home_page.cookie_accept();
        log.info("Accepted cookies");
    }

    @Test
    public void HomePage(){
        pageRepository.HomePage Home_Report = new pageRepository.HomePage(driver);
        Home_Report.cookie_agree();
        Home_Report.logo();
        Home_Report.country_change();
        Home_Report.firstComponentIsAfterNavigation_bar();
    }
    @AfterTest
    public void tearDown() {
        extent.flush();
        driver.close();
        log.info("Closing chrome browser");
        driver.quit();
        log.info("closing all running browsers");
    }
}
