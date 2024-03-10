package day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String userId = "mngr557645";
        String password = "bahUhyn";
        loginPage.login(userId, password);


        // Verify - Welcome To Manager's Page of Guru99 Bank
        Assert.assertEquals(homePage.getActualWelcomeMessage(), homePage.getExpectedWelcomeMessage(),
                "Welcome message not found or does not match");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
