
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v137.memory.model.Module;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class appicationScreenShot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\Selenium-Practice-Test\\sourceDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     WebElement headers = (WebElement) driver.findElements(By.xpath("//span[@class='_1XjE3T']"));
        List<Module> modules =new ArrayList<>();
        for(Module model : modules){
            System.out.println(model.getName());
        }
        TakesScreenshot ts = (TakesScreenshot) driver;
      File scrfilescrfile = ts.getScreenshotAs(OutputType.FILE);
      File destination = new File("\\Maven-project-development\\Selenium-Practice-Test\\supportingFile");
      FileUtils.copyFile(scrfilescrfile ,destination);
      driver.quit();
    }
}
