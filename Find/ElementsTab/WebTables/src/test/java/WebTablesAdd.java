import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WebTablesAdd {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://demoqa.com/webtables");

        WebElement addButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        addButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")))
                .sendKeys("Eliza");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")))
                .sendKeys("Dubiel");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")))
                .sendKeys("dubieleliza@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age")))
                .sendKeys("24");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary")))
                .sendKeys("9000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department")))
                .sendKeys("Legal");

        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitButton.click();

        driver.quit();
    }
}
