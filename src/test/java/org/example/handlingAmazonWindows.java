package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class handlingAmazonWindows {
    static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass
    public static void lounchChrome() {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

    }

    @Test
    public void selectAmazonProduct() {
        driver.get("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Iphone 17 pro max");
        searchBox.sendKeys(Keys.ENTER);
        WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Apple iPhone 17 Pro Max, US Version, 256GB, eSIM, Cosmic Orange- Unlocked (Renewed)']")));
        productLink.click();
        String parentWindowHandle = driver.getWindowHandle();
        for (int i = 0; i < 5; i++) {
            driver.switchTo().newWindow(WindowType.TAB);

            // String childWindowHandle  = String.valueOf(driver.switchTo().newWindow(WindowType.TAB));
            driver.get("https://www.amazon.com/Apple-Version-Orange-Unlocked-Renewed/dp/B0FTC2PRVZ/ref=sr_1_1?dib=eyJ2IjoiMSJ9.Vudqhevj2dRM8tXLm5h2VDcTxQjeRcc-TRS6Ww4XhaTPXVYFj1LQM1hYLivhaULRCvBBLH519WpfM2ISZ_QN1ndC4_hdYQdwRHuBpkavKGLjXt5UDZzXwfOymE4RcrbxLaIlWUJlQRFXY-agRJoAf7ohent8fYwS5VZA86yYo4UWsXGLXWhQ9vl59lehJYOrhX_iYR_k0L1czgZbmpjXUa4F5n69v6rvCobK8Pjgt-4.ivg_oYfXun13RTQF-DNOMPsgLGstafA_zOxwfs_a4r0&dib_tag=se&keywords=Iphone+17+pro+max&qid=1783534251&sr=8-1");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Assert.assertEquals("Amazon.com: Apple iPhone 17 Pro Max, US Version, 256GB, eSIM, Cosmic Orange- Unlocked (Renewed) : Cell Phones & Accessories", driver.getTitle());
            if (driver.getWindowHandles().equals(parentWindowHandle)) {
                driver.close();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
            driver.switchTo().window(parentWindowHandle);
        }

    }
    @AfterClass
    public static void closeChrome() {
        if (driver != null) {
            driver.quit();

        }
    }
}