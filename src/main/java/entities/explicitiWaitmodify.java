package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//. Write a method to wait explicitly for an element to be clickable.
public class  explicitiWaitmodify {

    public static WebElement explicitwaitcondition(WebDriver driver, WebElement element ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

}
