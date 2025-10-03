package selenium.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import selenium.factory.ChromeDriverGetter;

public class Frame {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://jqueryui.com/droppable/", 2000);
        //This simple instruction will fail since the box is contained in a frame (part of the webpage that loads the DOM independently),
        //so it does not belong to the original HTML webpage
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        //Even this way to access the frame would have worked, by indexes: it's 0 since it's the first and last frame on the page
        //      driver.switchTo().frame(0);
        driver.findElement(By.id("draggable")).click();
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
        driver.switchTo().defaultContent(); //This will bring the driver back to the original DOM
        driver.findElement(By.xpath("//a[text()='Accept']")).click();
    }
}