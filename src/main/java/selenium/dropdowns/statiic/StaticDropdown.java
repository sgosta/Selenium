package selenium.dropdowns.statiic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import selenium.factory.ChromeDriverGetter;

public class StaticDropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriverGetter().getDriver("https://rahulshettyacademy.com/dropdownsPractise/", 2000);
        Select select = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        interactWithStaticDropdownIn3DifferentWays(select);
    }

    private static void interactWithStaticDropdownIn3DifferentWays(Select select) {
        select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("AED");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());
    }
}