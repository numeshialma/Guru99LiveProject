package testScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static testScripts.Util.*;

/**

    @author Numeshi Alma
        Test Script 02

        Test Steps
         1)  Go to http://www.demo.guru99.com/V4/
         2) Enter valid UserId
         3) Enter valid Password
         4) Click Login
         5) Verify the Page Title after login
 */

public class TestScript02 {

    public static void main(String[] args) {

        String username, password;
        String actualTitle;

        //Setup Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);

        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys(USER_NAME);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.name("btnLogin")).click();


        actualTitle = driver.getTitle();
        if( actualTitle.equals(EXPECT_TITLE)){
            System.out.println("Test case : Passed ");
        } else {
            System.out.println("Test case : Failed");
        }

        driver.close();

    }
}
