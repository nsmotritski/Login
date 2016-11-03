import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
    public static String title;
    public static WebElement spanOutlookWebAccess;

    public static void initializeInboxPage(WebDriver driver) {
        title = driver.getTitle();
        spanOutlookWebAccess = driver.findElement(By.xpath("span[@aria-label='Microsoft Outlook Web App']"));
    }

    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
