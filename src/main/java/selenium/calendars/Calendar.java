package selenium.calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.factory.ChromeDriverGetter;

import java.util.List;

public class Calendar {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/dropdownsPractise/", 2000);

        //Let's try to make a one-way trip from Goa to Gorakhpur for 2 adults
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).sendKeys("GOI");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("GOP");
        driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
        List<WebElement> days = driver.findElements(By.cssSelector(".ui-state-default"));

        clickDayByNumber(days, "16");

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);
        driver.findElement(By.id("hrefIncAdt")).click();
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }

    //Method ti check if a component is enabled or not by checking its style adjustments
    private static boolean isReturnDateCalendarEnabled(WebDriver driver) {
        return driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity: 1");
    }

    private static void clickDayByNumber(List<WebElement> days, String number) {
        for (WebElement day : days)
            if (day.getText().equals(number)) {
                day.click();
                break;
            }
    }
}