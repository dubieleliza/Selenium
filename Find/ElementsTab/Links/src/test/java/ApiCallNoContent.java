import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApiCallNoContent {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
    }

    @Test
    void shouldDisplay204Status() {

        // GIVEN
        WebElement noContentLink = driver.findElement(By.id("no-content"));

        // WHEN
        noContentLink.click();

        // THEN
        WebElement response = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse"))
        );

        String responseText = response.getText();

        Assertions.assertAll(
                () -> Assertions.assertTrue(responseText.contains("204"), "Status code should be 204"),
                () -> Assertions.assertTrue(responseText.contains("No Content"), "Link has responded with status 204")
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
