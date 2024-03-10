package day_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyFileReader;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    PropertyFileReader property=new PropertyFileReader();

    String userIdElement= property.getProperty("LoginPage","user.id.element");
    String passwordElement= property.getProperty("LoginPage","password.element");
    String loginButtonElement= property.getProperty("LoginPage","login.button.element");
    String resetButtonElement= property.getProperty("LoginPage","reset.button.element");



    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HomePage login(String userId, String password) {

        // Wait for the user ID field to be present and visible
        WebElement userIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userIdElement)));
        userIdField.sendKeys(userId);

        // Wait for the password field to be present and visible
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordElement)));
        passwordField.sendKeys(password);

        // Locate and click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loginButtonElement)));
        loginButton.click();

        System.out.println("Login button clicked. Waiting for the HomePage to load.");

        return new HomePage(driver);
    }
}
