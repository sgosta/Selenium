package selenium.screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.factory.ChromeDriverGetter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotMaking {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriverGetter().getDriver("https://www.google.com/", 2000);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        saveFileinDownloadsDir(screenshot);

    }

    private static void saveFileinDownloadsDir(File screenshot) {
        Path targetPath = Path.of(System.getProperty("user.home"), "Downloads").resolve("screenshot");

        try {
            Files.move(screenshot.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot salvato in: " + targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}