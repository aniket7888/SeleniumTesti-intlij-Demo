package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class launchingwebsit {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "\\Maven-project-development\\Selenium-Practice-Test\\sourceDriver\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.get("https://www.amazon.com");
            driver.findElement(By.xpath("//span/button[@type='submit']")).click();
    //  driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")).click();
        Select dropdown=new Select(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']")));
          dropdown.selectByVisibleText("Home & Kitchen");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
            driver.findElement(By.id("nav-search-submit-button")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElements(By.xpath("//button[@aria-label='Add to cart']")).get(1).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.quit();
        }
    }

