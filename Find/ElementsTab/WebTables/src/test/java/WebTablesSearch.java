import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTablesSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/webtables");

        WebElement  SearchField = driver.findElement(By.id("searchBox"));
        SearchField.click();
        SearchField.sendKeys("Cierra");
        WebElement SearchButton = driver.findElement(By.id("basic-addon2"));
        SearchButton.click();
        Thread.sleep(5000);

        driver.quit();
    }
}
