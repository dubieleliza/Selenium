import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTableEdit {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://demoqa.com/webtables");

        WebElement editField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("edit-record-1"))
        );
        editField.click();

        WebElement firstNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))
        );
        firstNameField.clear();
        firstNameField.sendKeys("Victoria");

        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit"))
        );
        submitButton.click();

        driver.quit();
    }
}
