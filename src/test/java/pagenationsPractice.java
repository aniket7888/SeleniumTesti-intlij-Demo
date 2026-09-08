import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class pagenationsPractice {

    static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void paginationTest() {
        driver.get("https://practice.rcvacademy.com/pagination-table");
       driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
         // Add your pagination test logic here
        List<WebElement> row = driver.findElements(By.xpath("//tbody/tr"));
        wait.until(ExpectedConditions.visibilityOfAllElements(row));
        boolean found = false;
        while (!found) {
            for (WebElement r : row) {
                List<WebElement> data = r.findElements(By.tagName("td"));
                for (WebElement d : data) {
                    if (d.getText().equals("Portable SSD 1TB")) {
                        System.out.println("Found the text: " + r.getText());
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (!found) {
                WebElement nextButton = driver.findElement(By.xpath("//button[text()='Next →']"));
                if (nextButton.isEnabled()) {
                    nextButton.click();
                    driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
                    row = driver.findElements(By.xpath("//tbody/tr")); // Re-locate rows after clicking next
                    wait.until(ExpectedConditions.visibilityOfAllElements(row));
                } else {
                    System.out.println("Reached the last page, text not found.");
                    break;
                }
            }
        }
    }

    @AfterClass
    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }

    }
}
