import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launcheChromedriver {

    public static void main(String[] args){System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\Selenium-Practice-Test\\sourceDriver\\chromedriver.exe");
 WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");         System.out.println("Title of the page is: " + driver.getTitle());
                   driver.quit();
    }




}

