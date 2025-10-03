package selenium.multitabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.factory.ChromeDriverGetter;

public class OpenLinksInTabs {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://www.qaclickacademy.com/", 2000);
        WebElement footerDivWithLinks = driver.findElement(By.cssSelector(".footer-link.mt-40"));

        // 2 ways of interacting with links

//        for (WebElement link : footerDivWithLinks.findElements(By.tagName("a")))
//            new Actions(driver).keyDown(Keys.CONTROL)
//                    .click(link)
//                    .keyUp(Keys.CONTROL)
//                    .build()
//                    .perform();

        //Open each link in a new tab by Ctrl+Enter
        for (WebElement link : footerDivWithLinks.findElements(By.tagName("a")))
            link.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

        //Print each tab name
        for (String tabName : driver.getWindowHandles())
            System.out.println(driver.switchTo().window(tabName).getTitle());
    }
}