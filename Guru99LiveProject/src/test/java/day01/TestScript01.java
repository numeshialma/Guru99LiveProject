package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**

  @author Numeshi Alma
        Test Script 01

         Test Steps
         1)  Go to http://www.demo.guru99.com/V4/
          2) Enter valid UserId
          3) Enter valid Password
          4) Click Login
 */

public class TestScript01 {
    public static void main(String[] args) {

        //Setup Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.demo.guru99.com/V4/";


        // launch F the Base URL
        driver.get(baseUrl);

        // Enter username
        driver.findElement(By.name("uid")).sendKeys("mngr564921");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("zYtAveg");

        // Click Login
        driver.findElement(By.name("btnLogin")).click();
    }
}
