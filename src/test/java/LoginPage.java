import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Николай on 02.11.2016.
 */
public class LoginPage {
    public static WebElement logininput;
    public static WebElement passwordinput;
    public static WebElement submitbutton;

    public static void initializeLoginPage(WebDriver driver) {
        logininput = driver.findElement(By.id("username"));
        passwordinput = driver.findElement(By.id("password"));
        submitbutton = driver.findElement(By.name("SubmitCreds"));
    }

    public static void typeText (WebElement element, String s) {
        element.sendKeys(s);
    }
}