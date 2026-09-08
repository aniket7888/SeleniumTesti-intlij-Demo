import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class modifyCalenderDate {
    static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test
    public void modifyCalender() {
        driver.get("https://adventure.inc/in-en/flights/domestic/india?gad_source=1&gad_campaignid=23885096613&gbraid=0AAAABDX95zUURLvul4RbGhGaAm9ag5-gM&gclid=CjwKCAjwnvTUBhBoEiwAZNDxZxqbiRzvMmyswYiOX1VRzTohdiGrCormzh7ZPUt2J-aJAqHzseG7WRoCI5wQAvD_BwE");
        WebElement pageload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Domestic Flights in India']")));
       driver.findElement(By.xpath("//button[text()='One Way']")).click();
       driver.findElement(By.xpath("//span[text()='Departure']")).click();
       driver.findElement(By.xpath("//table[@aria-label='Days in November 2026']/tbody/tr/td/div/button/span[text()='18 ']")).click();
    }


    @AfterClass
    public static void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}