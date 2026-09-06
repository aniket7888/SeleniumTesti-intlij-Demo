package entities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    private WebDriver driver;

    // Add a no-argument constructor
    public ScreenshotListener() {
        // Default constructor
    }

    public ScreenshotListener(WebDriver driver) {
        this.driver = driver;
    }

    public void onTestFailure(ITestResult result) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String testName = result.getName();

        // Capture screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(srcFile, new File("./screenshots/" + testName + "_" + timestamp + ".png"));
            System.out.println("Screenshot saved for failed test: " + testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
