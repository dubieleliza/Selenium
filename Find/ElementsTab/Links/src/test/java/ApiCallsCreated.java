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

public class ApiCallsCreated {

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
    void shouldDisplay201Status() {
        // GIVEN
        WebElement createdLink = driver.findElement(By.id("created"));

        // WHEN
        createdLink.click();

        // THEN
        WebElement response = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse"))
        );

        String responseText = response.getText();


        Assertions.assertAll(
                () -> Assertions.assertTrue(responseText.contains("201"), "Status code should be 201"),
                () -> Assertions.assertTrue(responseText.contains("Created"), "Link has responded with status 201")
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
