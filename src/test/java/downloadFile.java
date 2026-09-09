import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class downloadFile {

  static WebDriver driver;

  @BeforeClass
  public static void setup() {
      System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");

      HashMap<String, Object> chromePrefs = new HashMap<>();
      chromePrefs.put("download.default_directory", "D:\\Maven-project-development\\Supportingfile\\DownloadedFiles");
      chromePrefs.put("download.prompt_for_download", false);

      ChromeOptions options = new ChromeOptions();
      options.setExperimentalOption("prefs", chromePrefs);

      driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
  }

  @Test(priority = 1)
  public void downloadFileTest() {
      driver.get("https://practice.rcvacademy.com/file-download");
      driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
      driver.findElement(By.xpath("//tr/td[text()=' data-export.csv']/following-sibling::td/a")).click();
  }

  @Test(priority = 2)
  public void uploadFileTest() {
      driver.get("https://practice.rcvacademy.com/file-upload");
      driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
      driver.findElement(By.id("uploadFile")).sendKeys("D:\\Maven-project-development\\Supportingfile\\DownloadedFiles\\Upload files.xlsx");
  }

  @AfterClass
  public static void closeBrowser() {
      if (driver != null) {
          driver.quit();
      }
  }
}
