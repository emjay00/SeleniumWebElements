import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownList {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gigacalculator.com/randomizers/random-country-generator.php");
        WebElement element = driver.findElement(By.className("form-select"));
        Select select= new Select(element);
        select.selectByValue("nam");

        List<WebElement> cont = driver.findElements(By.tagName("option"));
        System.out.println("Total value are = "+cont.size());
        for(int i=0;i<cont.size();i++)
        {
            System.out.println(cont.get(i).getText());
        }
    }
}
