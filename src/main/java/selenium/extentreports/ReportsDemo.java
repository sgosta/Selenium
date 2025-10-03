package selenium.extentreports;

import org.openqa.selenium.WebDriver;
import selenium.factory.ChromeDriverGetter;

public class ReportsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com", 2000);

    }
}