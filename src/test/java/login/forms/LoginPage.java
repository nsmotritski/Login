package login.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class LoginPage {
    public static WebElement loginInput;
    public static WebElement passwordInput;
    public static WebElement submitButton;

    public static void initializeLoginPage(WebDriver driver) {
        loginInput = driver.findElement(By.id("username"));
        passwordInput = driver.findElement(By.id("password"));
        submitButton = driver.findElement(By.name("SubmitCreds"));
    }

    public static void inputLoginWithDomain(String domain, String login) {
        String fullLogin = domain + File.separator + login;
        typeText(loginInput,fullLogin);
    }

    public static void loginToEmail (WebDriver driver, String domain, String login, String password) {
        LoginPage.initializeLoginPage(driver);
        LoginPage.inputLoginWithDomain(domain,login);
        LoginPage.typeText(LoginPage.passwordInput,password);
        LoginPage.submitButton.click();
    }

    public static void typeText (WebElement element, String s) {
        element.sendKeys(s);
    }
}