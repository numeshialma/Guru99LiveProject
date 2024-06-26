package testScripts;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testScripts.Util.*;

/**

 @author Numeshi Alma
 Test Script 04

 Test Steps
 1)  Go to http://www.demo.guru99.com/V4/
 2) Enter valid UserId
 3) Enter valid Password
 4) Click Login
 5) Verify ManagerID + Welcome To Manager's Page of Guru99 Bank
 */

public class TestScript04 {

    public static void main(String[] args) {

    String username, password;

    //Setup Chrome driver
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get(BASE_URL);

    driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys(USER_NAME);

    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(PASSWORD);

    driver.findElement(By.name("btnLogin")).click();


    // Verify ManagerID + Welcome To Manager's Page of Guru99 Bank
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Welcome To Manager's Page of Guru99 Bank")));

    boolean isDisplayedMessage = welcomeMessage.isDisplayed();
    if( isDisplayedMessage){
        System.out.println("Test case : Passed ");
    } else {
        System.out.println("Test case : Failed - Failed to find welcome message element ");
    }

    // Verify ManagerID
    wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    WebElement managerID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Manger Id")));

    boolean isDisplayed = managerID.isDisplayed();
        if( isDisplayed){
        System.out.println("Test case : Passed ");
        } else {
        System.out.println("Test case : Failed - Failed to find manager ID element ");
    }

    driver.close();

    }


}
