import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    @Test
    public void printTitle(){
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        System.out.println( driver.getTitle());
        Assert.assertEquals("Amazon.com", driver.getTitle());
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.close();

    }

    @AfterClass
    public static void closeChrome() {
        if (driver !=null) {
            driver.quit();
        }
    }
}
