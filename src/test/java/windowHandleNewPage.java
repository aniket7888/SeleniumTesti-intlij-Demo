import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class  windowHandleNewPage {
    static   WebDriver driver;
    static String DriverName ="Chrome";
    @BeforeClass
    public static void setup(){

        if (DriverName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (DriverName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "\\Maven-project-development\\fireFoxDriver\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (DriverName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "\\Maven-project-development\\EdgeDriver\\msedgedriver.exe");
            driver = new EdgeDriver();

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + DriverName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
@Test
public void window(){

}

    @AfterClass
    public static void closeBrowser(){
        if(driver !=null){
            driver.close();
        }
    }
}
