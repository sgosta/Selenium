package selenium.exercise.greenkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.factory.ChromeDriverGetter;

import java.time.Duration;
import java.util.List;

public class GreenKart {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/seleniumPractise/", 2000);
        List<WebElement> products = driver.findElements(By.cssSelector("div[class='product']"));

        for (WebElement product : products)
            if (product.findElement(By.cssSelector("h4")).getText().contains("Cucumber")) {
                product.findElement(By.cssSelector("button")).click();
                break;
            }

        driver.findElement(By.cssSelector("a.cart-icon img")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))
        );
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Select select = new Select(driver.findElement(By.cssSelector("select")));
        select.selectByValue("Italy");
        driver.findElement(By.cssSelector("input.chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}