package selenium.dropdowns.dynamic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.factory.ChromeDriverGetter;

public class DynamicDropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/dropdownsPractise/", 2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        //Using parent-child relationship locators
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='GOP']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
        String from = printElementTextByLocator(driver, "//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='GOP']");
        String to = printElementTextByLocator(driver, "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']");
        System.out.println("Flight from: " + from + "to: " + to + "confirmed!");
    }

    private static String printElementTextByLocator(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator)).getAttribute("text");
    }
}