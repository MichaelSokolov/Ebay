package pages;


import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class BasketPage extends BaseUtil{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-cart-n") WebElement number_of_products_in_bag;
    @FindBy(id = "ShopCart") WebElement shopping_cart;
    @FindAll({@FindBy(xpath = "//*[contains(@aria-label, 'Remove')]")})
    private List<WebElement> buttons_remove;

    public void verifyPtoductInTheBasket(String numer_of_products){
        wait.until(ExpectedConditions.titleIs("Your eBay Shopping Cart"));
        Assert.assertEquals(number_of_products_in_bag.getText(), numer_of_products, "Product was not added to basket");
    }

    public void removeItems(){
        for (int i = 0; i < buttons_remove.size(); i++){
            wait.until(ExpectedConditions.elementToBeClickable(buttons_remove.get(i))).click();
        }
    }
}
