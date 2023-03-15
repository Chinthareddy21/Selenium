package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import objectRepository.HomePageObjects;
import org.openqa.selenium.WebDriver;
import pageRepository.HomePage;

public class HomePageReporters {

    ExtentSparkReporter spark;
    ExtentTest test;
    ExtentReports extent;
    WebDriver driver;

    public HomePageReporters(WebDriver driver) {
        this.driver = driver;
    }
    public void logoCheckReporter() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/sparkReports/Country.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        test = extent.createTest("Cookies_check");

        HomePage Home = new HomePage(driver);
        Home.country_change();

        if(HomePageObjects.logo(driver).isDisplayed()){
            test.pass("Logo is displayed");
        }else {
            test.fail("Logo is not displayed");
        }
    }
}
