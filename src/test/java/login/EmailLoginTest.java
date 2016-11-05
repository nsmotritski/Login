package login;

import login.forms.InboxPage;
import login.forms.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    private int webDriverTimeout;
    private String domain;
    private String login;
    private String password;
    private String user;


    @BeforeTest
    @Parameters({"domain","login","password","user"})
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        //reading properties from the properties file
        try {
            fis = new FileInputStream("src/resources/TestSuite.properties");
            property.load(fis);

            url = property.getProperty("url");
            webDriverTimeout = Integer.parseInt(property.getProperty("webDriverTimeout"));
            domain = property.getProperty("domain");
            login = property.getProperty("login");
            password = property.getProperty("password");
            user = property.getProperty("user");
        } catch (IOException e) {
            System.err.println("Error: File not found!");
        }
        System.out.println("EmailLoginTest: before test");
        System.out.println("URL: " + url
                + ", DOMAIN: " + domain
                + ", LOGIN: " + login
                + ", PASSWORD: " + password);
        //launching the browser and navigating to the web page
        System.out.println(this.url);
        this.driver = new ChromeDriver();
        this.driver.get(url);
    }

    @AfterTest
    public void doAfterTest() {
        System.out.println("EmailLoginTest: after test");
        driver.quit();
    }

    @Test
    public void TestEmailLogin() throws InterruptedException {
        System.out.println("EmailLoginTest: test");
        LoginPage.loginToEmail(driver,domain,login,password);
        InboxPage.waitForElementVisible(driver,webDriverTimeout);
        InboxPage.initializeInboxPage(driver);
        Assert.assertEquals(InboxPage.userButton.getAttribute("aria-label"),user);
    }
}
