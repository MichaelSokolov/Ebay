package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class MainPage extends BaseUtil {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text() = 'Sign in']") WebElement link_sign_in;
    @FindBy(xpath = "//*[@id='gh-ug']") WebElement menu_user;
    @FindBy(xpath = "//*[contains(@id, 'HomepageOverlay')]") WebElement popup_ad;
    @FindBy(xpath = "//*[contains(@id, 'CloseContainer')]") WebElement button_close_popup;
    @FindBy(id = "gh-ac") WebElement field_search;
    @FindBy(xpath = "//*[@value = 'Search']") WebElement button_search;
    @FindBy(id = "gh-cart-n") WebElement number_of_products_in_bag;

    public void closePopup (){
        if (popup_ad.isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(button_close_popup)).click();
        }
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.visibilityOf(link_sign_in));
        link_sign_in.click();
    }

    public void verifyLogin () {
        wait.until(ExpectedConditions.titleIs("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay"));
        Assert.assertTrue(menu_user.isDisplayed(), "User is not sign in");

    }

    public void search (String search_request){
        sendKeys(field_search, search_request);
        button_search.click();
    }
    public boolean checkItemsInBasket(){
        boolean a;
        try{
            wait.until(ExpectedConditions.visibilityOf(number_of_products_in_bag));
            a = number_of_products_in_bag.isDisplayed();
        }catch (Exception err){
            a = false;
        }
        return a;
    }

    public void openBasket(){
        number_of_products_in_bag.click();
    }
}
