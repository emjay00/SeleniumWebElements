package TestNG1;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class cListen implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("screenshot captured " + result.getName());
        Reporter.log("<a href=\"C:\\Users\\ManuJohn\\OneDrive - PQA\\Pictures\\Screenshots\\Screenshot (2).png\">Screenshot link</a>");
    }
}
