import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxTest {
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

        WebElement checkBoxMenu = driver.findElement(By.xpath("//*[@id=\"item-1\"]"));
        checkBoxMenu.click();

        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label"));
        checkbox.click();
    }
}
