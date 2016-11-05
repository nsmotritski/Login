package login.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InboxPage {
    public static WebElement userButton;

    public static void initializeInboxPage(WebDriver driver) {
        userButton = driver.findElement(By.xpath("//div[@role='banner']//button[not(@title)]"));
    }

    public static void waitForElementVisible(WebDriver driver,int webDriverTimeout) {
        driver.manage().timeouts().implicitlyWait(webDriverTimeout, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@role='banner']//button[not(@title)]")).isDisplayed();
    }

}
