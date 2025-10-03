package selenium.dropdowns.updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.factory.ChromeDriverGetter;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/dropdownsPractise/", 2000);
        driver.findElement(By.id("divpaxinfo")).click(); //Opens the updated dropdown
        interactWithUpdatedDropdownLoopingActionsForSpecificOption(driver, PassengerCategory.ADULT, "5");
        interactWithUpdatedDropdownLoopingActionsForSpecificOption(driver, PassengerCategory.CHILD, "4");
        interactWithUpdatedDropdownLoopingActionsForSpecificOption(driver, PassengerCategory.INFANT, "4");
        driver.findElement(By.id("btnclosepaxoption")).click(); //Once all passengers are set, close the menu

    }

    private static void interactWithUpdatedDropdownLoopingActionsForSpecificOption(WebDriver driver, PassengerCategory category, String targetCount) throws InterruptedException {
        Thread.sleep(1000);
        WebElement option = driver.findElement(category.getCountLocator());
        WebElement plus = driver.findElement(category.getIncrementLocator());

        while (!option.getText().equals(targetCount))
            plus.click();

        System.out.println(category + " number = " + option.getText());
    }
}