import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindLinks {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        /*List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println("total links are = "+link.size());
        for(WebElement links: link)
        {
            System.out.println( links.getText()+"URL is "+ links.getAttribute("href"));
        }*/
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul"));
        List<WebElement> linkInBlock = element.findElements(By.tagName("a"));
        System.out.println("total links are = "+linkInBlock.size());
        for(WebElement links: linkInBlock)
        {
            System.out.println( links.getText());
        }

        driver.close();
    }
}
