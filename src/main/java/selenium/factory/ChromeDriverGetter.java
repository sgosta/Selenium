package selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeDriverGetter implements GetDriver {

    @Override
    public WebDriver getDriver(String url, Integer millis) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        if (millis != null)
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
        return driver;
    }
}