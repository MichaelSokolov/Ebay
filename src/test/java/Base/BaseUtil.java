package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseUtil {

    public WebDriver driver;
    public WebDriverWait wait;

    public BaseUtil(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void sendKeys(WebElement element, String data) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.clear();
        element.sendKeys(data);
    }
}

