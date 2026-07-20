import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchthePosition {

   static WebDriver driver;
    @BeforeClass
    public static void chromedetup(){
      
        driver = new ChromeDriver();
    }

}
