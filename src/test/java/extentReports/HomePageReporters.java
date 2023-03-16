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
    public void cookieCheckReporter() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("sparkReports/HomePageReports/Cookies.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        test = extent.createTest("Cookies_check");

        HomePage Home = new HomePage(driver);

        if(HomePageObjects.cookies_agree(driver).isDisplayed()){
            test.pass("Cookie agree message is displayed");
        } else {
            test.fail("Cookie  agree message is not displayed");
        }

        Home.cookie_agree();

        extent.flush();
    }

    public void logoCheckReporter() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("sparkReports/HomePageReports/LogoCheck.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        test = extent.createTest("LogoCheck");

        HomePage Home = new HomePage(driver);
        Home.logo();

        if(HomePageObjects.logo(driver).isDisplayed()){
            test.pass("Logo is displayed");
        } else {
            test.fail("Logo is not displayed");
        }
        extent.flush();
    }

    public void countryChangeReporter() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("sparkReports/HomePageReports/Country.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        test = extent.createTest("Country_change");

        HomePage Home = new HomePage(driver);
        Home.country_change();

        if(HomePageObjects.logo(driver).isDisplayed()){
            test.pass("Country is changed");
        } else {
            test.fail("Country is not changed");
        }
        extent.flush();
    }
}
