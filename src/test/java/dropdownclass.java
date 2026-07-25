import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;

public class dropdownclass {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void dropdownclass1() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select drop = new Select(dropdown);
        for(WebElement option : drop.getOptions()){
            System.out.println("Option: " + option.getText());

        }
        drop.selectByVisibleText("Option2");
        Assert.assertEquals(drop.getFirstSelectedOption().getText(), "Option2");
    }
    @Test(priority = 2)
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
        Assert.assertEquals(dropdownElement.getAttribute("value"), "Australia");
    }
    @Test(priority = 3)
    public void checkboxClick(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
    }

    @Test(priority = 4)
    public void radioButton(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement radioButton = driver.findElement(By.xpath("(//input[@name='radioButton'])[1]"));
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected());

    }    @AfterClass
    public static void chromeclose () {
            if (driver != null) {
                driver.quit();
            }
        }
}
