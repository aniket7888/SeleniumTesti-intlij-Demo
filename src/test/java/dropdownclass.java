import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdownclass {
  static   WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    @Test
    public void dropdownclass1(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select drop = new  Select(dropdown);
        List<WebElement> list = drop.getOptions();
        System.out.println(list);
        drop.selectByVisibleText("India");
        Assert.assertEquals("India",drop.getFirstSelectedOption().getText());
    }



    @AfterClass
    public static void chromeclose(){
        if (driver != null){
            driver.quit();
        }
    }
}
