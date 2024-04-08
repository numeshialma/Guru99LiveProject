package testScripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static testScripts.Util.*;

/**
 * SS1: Enter valid userid & password
 *      Expected: Login successful home page shown
 * SS2: Enter invalid userid & valid password
 * SS3: Enter valid userid & invalid password
 * SS4: Enter invalid userid & invalid password
 *      Expected: A pop-up �User or Password is not valid� is shown
 *
 * @throws Exception
 */

public class TestScript03 {

    WebDriver driver;

    @DataProvider(name= "data-set")
    public static Object[][] DataSet(){
        Object[][] obj={
                {"valid","mngr564921","zYtAveg"},
                {"invalid","mngr564921","secret_sauce"},
                {"invalid","standarduser","zYtAveg"},
                {"invalid","",""}
        };
        return obj;
    }

    @Test(dataProvider = "data-set")
    public void DataProvTest(String type,String username,String password ) throws InterruptedException {

        System.out.println(type+ " " +username+ " " +password);
        driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));

        driver.get(BASE_URL);

        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();

        String actualTitle;
        if(type.equals("valid")){
            actualTitle = driver.getTitle();
            if( actualTitle.equals(EXPECT_TITLE)){
                System.out.println("Test case : Passed ");
            } else {
                System.out.println("Test case : Failed");
            }
        }else{
            System.out.println(EXPECT_ERROR);
        }
        Thread.sleep(3000);
        driver.quit();

    }


}
