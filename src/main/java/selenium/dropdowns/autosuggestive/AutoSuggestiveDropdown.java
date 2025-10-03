package selenium.dropdowns.autosuggestive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.factory.ChromeDriverGetter;

import java.util.List;

public class AutoSuggestiveDropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/dropdownsPractise/", 2000);
        driver.findElement(By.id("autosuggest")).sendKeys("ind"); //This will trigger all the options which contain "ind"
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //All options satisfied by input text

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }
}