import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowIframe {
     static WebDriver driver;
      WebDriverWait wait =new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        Actions act  = new Actions(driver);
        @BeforeClass
        public static void chromesetup(){
            System.setProperty("Webdriver.chrome.driver","\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    @Test
    public void iframeHandling(){
            driver.get("https://jqueryui.com/droppable/");
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
            driver.switchTo().frame(iframe);
            WebElement draggframe = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement droppframe = driver.findElement(By.xpath("//div[@id='droppable']"));
              act.dragAndDrop(draggframe,droppframe).perform();
              driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

            draggframe.click();
    }

    @AfterClass
    public static void closechrome(){
            if (driver!=null) {
                driver.quit();

            }
        }
}
