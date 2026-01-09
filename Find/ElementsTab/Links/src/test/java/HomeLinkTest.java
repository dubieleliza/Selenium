import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeLinkTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
    }

    @Test
    void shouldGoBackToHomePage() {
        // GIVEN
        String originalWindow = driver.getWindowHandle();
        WebElement homePageLink = driver.findElement(By.id("simpleLink"));

        // WHEN
        homePageLink.click();

        // THEN  czekamy na nową kartę
        wait.until(driver -> driver.getWindowHandles().size() == 2);

        // przełączamy się na nową kartę
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Assertions.assertEquals(
                "https://demoqa.com/",
                driver.getCurrentUrl()
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}