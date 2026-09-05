import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class
WindowHandleOnNewPage {
    static WebDriver driver ;
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    @BeforeClass
    public static void setup(){
         System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
    @Test
    public void newBrowser() {
        driver.get("https://www.amazon.com/");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
//        searchbox.sendKeys("CUP");
//        searchbox.sendKeys(Keys.ENTER);
        Actions action = new Actions(driver);
        action.moveToElement(searchbox).click().sendKeys("CUP").sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals("Amazon.com : CUP", driver.getTitle());
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(100));
        WebElement productclick = driver.findElement(By.xpath("(//button[@name='submit.addToCart'])[1]"));
        action.moveToElement(productclick).click().build().perform();
        WebElement cartadd=driver.findElement(By.xpath("//span[text()='1 in cart']"));
        Assert.assertEquals(cartadd.getText(),"1 in cart");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
       WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='sc-subtotal-label-activecart']")));
        Boolean isDisplayed = cart.isDisplayed();

        Assert.assertTrue(isDisplayed);
    }

    @AfterClass
    public static void closeBrowser(){
        if(driver!=null){
            driver.quit();
        }

    }
}
