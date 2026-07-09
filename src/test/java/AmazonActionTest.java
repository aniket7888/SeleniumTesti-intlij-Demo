
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Objects;

public class AmazonActionTest {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    @Test
    public void searchWoodenSpoon() {
        driver.get("https://www.amazon.com");

        // Hover over account list
        WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        action.moveToElement(accountList).perform();

        // Search for product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        action.moveToElement(searchBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("wooden spoon")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();

        driver.findElement(By.id("nav-search-submit-button")).click();
       // Assert.assertEquals("Amazon.com : WOODEN SPOON", driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
