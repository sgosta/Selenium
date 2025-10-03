package selenium.jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.factory.ChromeDriverGetter;

import java.util.List;

public class JsScriptExecution {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/AutomationPractice/", 2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //The params taken by js scrollBy function are pixelsToScrollUp and pixelsToScrollDown
        //This will scroll the scrollBar of the window by given pixels
        js.executeScript("window.scrollBy(0, 500)");
        //Now if we want to scroll the bar of an element (a table in this case) present in the DOM
        js.executeScript("document.querySelector('.tableFixHead').scrollBy(0, 25)");
        List<WebElement> elementsInFourthColumn = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));

        for (WebElement cell : elementsInFourthColumn)
            System.out.println(cell.getText());

        System.out.println("Elements values added up = " + elementsInFourthColumn.stream()
                .map(WebElement::getText)
                .mapToInt(Integer::parseInt)
                .sum()
        );
    }
}