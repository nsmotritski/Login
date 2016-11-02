import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailLoginTest {
    FileInputStream fis;
    Properties property = new Properties();
    WebDriver driver;
    private String url;
    private String login;
    private String password;

    @Parameters
    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        //reading properties from the properties file
        try {
            fis = new FileInputStream("src/resources/TestSuite.properties");
            property.load(fis);

            this.url = property.getProperty("url");
            login = property.getProperty("login");
            password = property.getProperty("password");

            System.out.println("URL: " + url
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);
        } catch (IOException e) {
            System.err.println("Error: File not found!");
        }
        System.out.println("testClass1: before test");
        //launching the browser and navigating to the web page
        System.out.println(this.url);
        this.driver = new ChromeDriver();
        this.driver.get("https://webmail.itransition.com");

    }

    @AfterTest
    public void doAfterTest() {
        System.out.println("testClass1: after test");
        driver.quit();
    }



    @Test
    public void TestEmailLogin() throws InterruptedException {
        System.out.println("testClass1: test");
        LoginPage.initializeLoginPage(driver);
        LoginPage.typeText(LoginPage.logininput,login);
        LoginPage.typeText(LoginPage.passwordinput,password);
        LoginPage.submitbutton.click();
        Thread.sleep(15000);
        Assert.assertTrue(false);
    }

}
