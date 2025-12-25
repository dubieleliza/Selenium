

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

    public class TextBoxTest {
        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            WebDriver driver = new ChromeDriver(options);
            driver.get("https://demoqa.com/");

            WebElement ElementTabElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div"));
            boolean isDisplayed = ElementTabElement.isDisplayed();
            System.out.println("Element Tab is visible? " + isDisplayed);

            ElementTabElement.click();

            WebElement textBoxMenu = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
            textBoxMenu.click();


            driver.findElement(By.id("userName")).sendKeys("Eliza Dubiel");
            driver.findElement(By.id("userEmail")).sendKeys("dubieleliza89@gmail.com");
            driver.findElement(By.id("currentAddress")).sendKeys("Łada 44A , Lublin");
            driver.findElement(By.id("permanentAddress")).sendKeys("Łada 42, Lublin");


            WebElement submitButton = driver.findElement(By.id("submit"));

            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", submitButton);

            submitButton.click();
        }
    }
