package day_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;

public class HomePage {
    private WebDriver driver;
    PropertyFileReader property=new PropertyFileReader();

    String loginAssertionElement= property.getProperty("HomePage","login.assertion.element");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    String getActualWelcomeMessage() {
        return driver.findElement(By.xpath(loginAssertionElement)).getText();
    }

    String getExpectedWelcomeMessage() {
        return "Welcome To Manager's Page of Guru99 Bank";
    }
}
