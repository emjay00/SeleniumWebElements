import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class svgElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.worldometers.info/coronavirus/coronavirus-cases/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> points=driver.findElements(By.xpath("(//*[name()='svg' and @version='1.1'])[3]//*[name()='g']//*[name()='g']//*[name()='rect']"));
        Actions act = new Actions(driver);
        for(WebElement e:points){
        act.moveToElement(e).perform();
        System.out.println(driver.findElement(By.xpath("(//*[name()='svg' and @version='1.1'])[3]//*[name()='g' and @data-z-index='8']//*[name()='text']")).getText());
        }
        driver.close();

    }

}
