package pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends BaseUtil {

    public AuthPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//input[contains(@placeholder, 'Email')][@class= 'fld']") WebElement field_login;
    @FindBy(xpath = "//input[@placeholder = 'Password'][@class= 'fld']") WebElement field_password;
    @FindBy(xpath = "//*[@id='sgnBt']") WebElement button_signin;

    public void enterCredentials(String email, String pass){
        sendKeys(field_login, email);
        sendKeys(field_password, pass);
        button_signin.click();
    }


}
