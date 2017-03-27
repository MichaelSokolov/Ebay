package pages;


import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BaseUtil {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ListViewInner") WebElement search_results;
    @FindAll({@FindBy(xpath = "//*[@id = 'ListViewInner']/li/div[1]")})
    private List<WebElement> list_of_search_items;

    public void verifySearchResults (){
        wait.until(ExpectedConditions.visibilityOf(search_results));
    }
    public void selectCompatibleModel (String model){
        driver.findElement(By.xpath("//span[text() = 'For "+ model +"']")).click();
    }

    public void selectNeededProduct(int number_by_order){
        wait.until(ExpectedConditions.elementToBeClickable(list_of_search_items.get(number_by_order-1))).click();
    }


}
