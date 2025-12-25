import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/radio-button");


        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveLabel = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noLabel = driver.findElement(By.xpath("//label[@for='noRadio']"));


        yesLabel.click();
        Thread.sleep(5000);


        impressiveLabel.click();
        Thread.sleep(5000);


        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        WebElement noRadio = driver.findElement(By.id("noRadio"));


        System.out.println("Yes selected: " + yesRadio.isSelected());
        System.out.println("Impressive selected: " + impressiveRadio.isSelected());
        System.out.println("No enabled: " + noRadio.isEnabled());


        driver.quit();
    }
}
