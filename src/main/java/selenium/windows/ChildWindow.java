package selenium.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.factory.ChromeDriverGetter;

import java.util.Iterator;
import java.util.Set;

public class ChildWindow {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/loginpagePractise/", 2000);
        driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> tabsIt = tabs.iterator();
        String parentTabId = tabsIt.next();
        String childTabId = tabsIt.next();
        driver.switchTo().window(childTabId);
        String username = driver.findElement(By.xpath("//a[text()='mentor@rahulshettyacademy.com']")).getText();
        driver.switchTo().window(parentTabId);
        String domain = username.substring(username.indexOf("@") + 1);
        driver.findElement(By.id("username")).sendKeys(domain.substring(0, domain.indexOf(".")));
        driver.findElement(By.id("password")).sendKeys("Stock Ats");
    }
}