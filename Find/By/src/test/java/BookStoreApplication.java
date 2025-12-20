import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookStoreApplication {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");

        WebElement BookStoreApplicationElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div"));
        boolean isDisplayed = BookStoreApplicationElement.isDisplayed();
        System.out.println("BookStoreApplication is visible? " + isDisplayed);

        BookStoreApplicationElement.click();
    }
}
