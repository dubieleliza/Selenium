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

public class ButtonLinkRedirection {

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
    void shouldRedirectToButtonPage() {
        // GIVEN
        String originalWindow = driver.getWindowHandle();
        WebElement buttonPageLink = driver.findElement(By.id("dynamicLink"));

        // WHEN
        buttonPageLink.click();

        // THEN
        wait.until(driver -> driver.getWindowHandles().size() == 2);

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
