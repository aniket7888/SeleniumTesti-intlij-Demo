import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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
    public void dropdownclass1() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select drop = new Select(dropdown);
        for(WebElement option : drop.getOptions()){
            System.out.println("Option: " + option.getText());

        }
        drop.selectByVisibleText("Option2");
      Assert.assertEquals("Option2", drop.getFirstSelectedOption().getText());
    }
    @Test
    public void dropdownclass2() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropdownElement = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        dropdownElement.sendKeys("Aus");
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
        for (WebElement option : options) {

            if (option.getText().equals("Australia")) {
                option.click();
                break;
            }
        }
        Assert.assertEquals("Australia", dropdownElement.getAttribute("value"));
    }
    @Test
    public void checkboxClick(){
      //  driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
    }
        @AfterClass
        public static void chromeclose () {
            if (driver != null) {
                driver.quit();
            }
        }
    }
