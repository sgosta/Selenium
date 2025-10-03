package selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import selenium.factory.ChromeDriverGetter;

public class Action {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://www.amazon.it/", 2000);
        Actions action = new Actions(driver);
        //First, the desired action needs to be built. Then it can be performed
        action.moveToElement(driver.findElement(By.id("nav-link-accountList")))
                .build().perform();
        //Example of composite actions -> click + typing a String in caps + double-clicking the text box to select the whole content
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("product")
                .doubleClick()
                .build().perform();
    }
}