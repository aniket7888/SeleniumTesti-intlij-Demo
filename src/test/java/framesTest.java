
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class framesTest {

  static  WebDriver driver ;
    @BeforeClass
    public static void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test
    public void framesTest(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement frame = driver.findElement(By.xpath("(//input[@class='btn-style'])[1]"));
        frame.click();
        Alert alrt =driver.switchTo().alert();
        System.out.println("Alert Text: "+alrt.getText());

        Assert.assertEquals("Hello , share this practice page and share your knowledge",alrt.getText());
        alrt.accept();

    }


    @AfterClass
    public static void closeBrowser() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
