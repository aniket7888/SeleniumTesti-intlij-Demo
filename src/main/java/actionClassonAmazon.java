import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class actionClassonAmazon {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//span/button[@type='submit']")).click();
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
        WebElement search =driver.findElement(By.id("twotabsearchtextbox"));
        action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("wooden spoon").build().perform();
        action.click(driver.findElement(By.id("nav-search-submit-button"))).build().perform();
        Thread.sleep(2000);
        driver.quit();


    }
}
