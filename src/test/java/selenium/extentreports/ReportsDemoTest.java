package selenium.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.factory.ChromeDriverGetter;

@Slf4j
public class ReportsDemoTest {

    private WebDriver driver;
    private ExtentReports extent;

    @BeforeTest
    public void setUp() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/index.html");
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Stefano");
    }

    @Test
    public void firstTest() {
        extent.createTest("firstTest");
        driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com", 2000);
        extent.flush();
    }
}