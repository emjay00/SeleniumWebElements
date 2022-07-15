import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class FindLinks {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com/");
        String url="";
        HttpURLConnection huc= null;
        int respCode=200;
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
            System.out.println(links.getText());
            url=links.getAttribute("href");
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        driver.close();
    }
}
