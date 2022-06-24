import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
    }
}
