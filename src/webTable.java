import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webTable {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement element = driver.findElement(By.xpath("//*[@id=\"customers\"]"));
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        System.out.println("Total rows = "+row.size());
        List<WebElement> col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
        System.out.println("Total rows = "+col.size());
        for (int i=2; i<= row.size();i++)
        {
            for (int j=1; j<= col.size(); j++)
            {
                System.out.print(driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText()+"   ");
            }
            System.out.println();
        }

        driver.close();
    }
}






