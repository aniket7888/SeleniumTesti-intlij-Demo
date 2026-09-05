import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// Scroll to a specific element on a page and verify its visibility.
public class scrollToElement
{

    static WebDriver driver;
    JavascriptExecutor js =(JavascriptExecutor) driver;
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    @Test
 public void scrollToElementLocator(){
        driver.get("https://www.amazon.com/");
        WebElement element =driver.findElement(By.xpath("//span[text()='Best Sellers in Sports & Outdoors']"));
       // js.executeScript("window.scrollBy(0,300);");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(100));
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }



//    @AfterClass
//    public static void close(){
//        if(driver !=null){
//            driver.quit();
//        }

  //  }
}
