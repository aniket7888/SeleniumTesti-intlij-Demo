import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Httpscertificate {

    public static void main(String[] args) throws InterruptedException{
    ChromeOptions options = new ChromeOptions();
    options.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");
}
}