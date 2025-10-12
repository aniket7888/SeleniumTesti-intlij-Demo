import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class calender {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://www.timeanddate.com/calendar/");
        List<WebElement> country=driver.findElements(By.xpath("//select[@id='sf_country']"));
        System.out.println(country);

        for (WebElement eachcountry:country){
            if (eachcountry.getText().equals("Brunei")){
                eachcountry.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.id("sf_year")).click();
    }
}