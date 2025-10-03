package selenium.factory;

import org.openqa.selenium.WebDriver;

public interface GetDriver {

    WebDriver getDriver(String url, Integer millis);
}