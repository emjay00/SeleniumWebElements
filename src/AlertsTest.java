import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AlertsTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alert = wait.until((ExpectedConditions.alertIsPresent()));
        alert = driver.switchTo().alert();
        alert.accept();

        WebElement element = driver.findElement(By.id("confirmButton"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        alert = driver.switchTo().alert();
        alert.accept();

        WebElement element2 = driver.findElement(By.id("promtButton"));
        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("arguments[0].scrollIntoView()", element2);
        Actions action = new Actions(driver);
        action.moveToElement(element2).click().build().perform();
        alert.sendKeys("Joseph");
        alert.accept();


    }
}
