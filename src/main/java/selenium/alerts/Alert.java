package selenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.factory.ChromeDriverGetter;

public class Alert {

    public static void main(String[] args) {
        //2 types of alert: 1 with confirmation button only (generally OK),
        //the other one with both confirmation and dismiss buttons
        String name = "Stefano";
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/AutomationPractice", 2000);
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        //This instruction will allow the driver to access the alert prompted js
        System.out.println("The text contained in alert = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }
}