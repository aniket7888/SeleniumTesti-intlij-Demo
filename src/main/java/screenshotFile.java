import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class screenshotFile {
    public static void main(String[] args) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //  FileUtiles.copyFile(src,new File(".\\Supportingfile\\Screenshotscreenshot.png"));
    }
}
