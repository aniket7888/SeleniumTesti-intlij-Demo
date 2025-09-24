import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windowSwitchCase {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");
        Thread.sleep(10);
        driver.findElement(By.xpath("//a[text()='Submit your talk.']")).click();
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("themeToggle")).click();
        driver.findElement(By.id("hamburgerIcon")).click();
        driver.switchTo().window(parentId);
        driver.findElement(By.xpath("/a[@class='nav-link dropdown-toggle show']")).click();
        Thread.sleep(10);
        driver.findElement(By.xpath("//a[text()='History']")).click();
       Thread.sleep(10);

        driver.quit();

    }
}