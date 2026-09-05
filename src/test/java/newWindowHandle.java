import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
//. Switch between multiple browser windows and verify the page titles.
public class newWindowHandle {
  static   WebDriver driver;
      @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
 @Test
 public void multipleWindows(){
     String parentwindow = driver.getWindowHandle();
          driver.get("https://www.amazon.com/");
          System.out.println(driver.getTitle());
          Set<String> manageWindow = driver.getWindowHandles();
              driver.switchTo().newWindow(WindowType.TAB);
              driver.get("https://www.flipkart.com/");
              System.out.println(driver.getTitle());
              driver.close();
          int coutwindow =manageWindow.size();
          System.out.println(coutwindow);
 }


@AfterClass
    public static void close(){
          if(driver!=null){
              driver.quit();
          }

}
}
