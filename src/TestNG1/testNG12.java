package TestNG1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testNG12
{
    public WebDriver driver;
    @BeforeMethod
    public void dolaunch() {
        System.out.println("Method launching");
    }

    @Test(dependsOnMethods = "doreg", alwaysRun = true)
    public void dologin() {
        System.out.println("Do Login");
    }

    @Test
    public void doreg() {
        System.out.println("Do Reg");
       //Assert.fail("USer reg failed");
    }

    @Test(invocationCount = 5)
    public void exec(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.close();

    }
}
