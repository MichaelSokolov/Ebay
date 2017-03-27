package pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends BaseUtil {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "CenterPanel") WebElement central_panel;
    @FindBy(id = "isCartBtn_btn") WebElement button_add_to_cart;
    @FindBy(xpath = "//*[@id='atcLnk']/a") WebElement button_your_cart;
    @FindAll({@FindBy(xpath = "//select[contains(@id, 'msku-sel')]")})
    private List<WebElement> listbox_attributes;

    public void verifyProductDatails(){
        Assert.assertTrue(central_panel.isDisplayed(), "Product datails not visible");
    }

    public void chooseListboxAttributes(int i){
        for(int z = 0; z < listbox_attributes.size(); z++){
            Select select = new Select(listbox_attributes.get(z));
            select.selectByIndex(i);
        }
    }

    public void clickAddToCart(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(button_add_to_cart)).click();
        } catch (Exception err){
            wait.until(ExpectedConditions.elementToBeClickable(button_your_cart)).click();
            System.out.println("Product already in the basket");
        }
    }


}
