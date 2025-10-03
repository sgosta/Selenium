package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Introduction {

    public static void main(String[] args) throws InterruptedException {

        //Let's try to automate the processes for Chrome browser
        //We need the class whose methods' goal is to access and operate with Chrome browser
        //ChromeDriver, SafariDriver, EdgeDriver... are classes that implement the WebDriver interface, which
        //describes the automation methods that each class must implement accordingly

        //ChromeDriver can't directly access Chrome browser, so the Chromium team developed a Proxy which
        //will translate Selenium instruction in Chrome native language

        //This instruction will allow ChromeDriver to automatically pick the proper Chrome browser executable
        WebDriver driver;
//        driver.get("https://rahulshettyacademy.com");
//        System.out.println("Title of the page: " + driver.getTitle());
//        System.out.println("URL of the page: " + driver.getCurrentUrl());
//        driver.close(); //driver.quit() This method closes every associated window;

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        //LOCATORS (always check for uniqueness of the locator chosen)
        //Find the HTML element by ID locator, then strike the given keys
        driver.findElement(By.id("inputUsername")).sendKeys("Stefano");
        //Find the HTML element by name locator, then strike the given keys
        driver.findElement(By.name("inputPassword")).sendKeys("pwinsertedbybot");
        //Now it's time to send the fulfilled form by the dedicated button
        driver.findElement(By.className("signInBtn")).click();

        //Find the HTML element by cssSelector() locator, (use SelectorsHub plugin)
        //This instruction < System.out.println(driver.findElement(By.cssSelector("p.error")).getText()) >
        //will fail as the element p.error is loaded after Selenium executed the instruction.

        //So there are 2 ways to tell Selenium to wait the needed time
        //Implicit and explicit wait
        //Implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
        //It seems that 2.5 seconds are enough to the p.error component to show up, so it works just fine
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        //Since our user appears to have wrong credentials, we navigate to the user restore tab dedicated
        driver.findElement(By.linkText("Forgot your password?")).click();
        //We set the credentials for the user, using SelectorsHub
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Stefano");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("stef99@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //resets the value of the email field
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("stef99@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456");

        Thread.sleep(1000); //Necessary since the Reset Login button hasn't still rendered

        //Form is ready, now it's time to send it to reset the password
        driver.findElement(By.xpath("//form/div/button[2]")).click();
        System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Stefano");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        System.out.println("Successfully logged in");

        Thread.sleep(1000); //We'll wait 1 second, and we press the button to log out
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        System.out.println("Successfully logged out");
        driver.close();
    }
}