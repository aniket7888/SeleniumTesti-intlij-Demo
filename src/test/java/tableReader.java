import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class tableReader {
  static   WebDriver driver;
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void readTableText(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
       List<WebElement> tableRow = driver.findElements(By.xpath("//tbody/tr"));
         for(WebElement row:tableRow){
              List<WebElement> tableData = row.findElements(By.tagName("td"));
              for(WebElement data:tableData){
                  if(data.getText().equals("Learn SQL in Practical + Database Testing from Scratch")) {
                      System.out.println("Found the text: " + data.getText());
                  }
              }
              System.out.println();
         }
    }
    @AfterClass
    public static void closeCrowser(){
        if(driver !=null) {
            driver.quit();
        }
    }
}
