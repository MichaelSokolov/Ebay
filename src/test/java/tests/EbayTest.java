package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;


public class EbayTest {

    public WebDriver driver;

    MainPage mainpage;
    AuthPage authpage;
    SearchPage searchpage;
    ProductPage productpage;
    BasketPage basketpage;


    @BeforeTest
    public void setUpDataBase(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        mainpage = PageFactory.initElements(driver, MainPage.class);
        authpage = PageFactory.initElements(driver, AuthPage.class);
        searchpage = PageFactory.initElements(driver, SearchPage.class);
        productpage = PageFactory.initElements(driver, ProductPage.class);
        basketpage = PageFactory.initElements(driver, BasketPage.class);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void openMainPage(){
        driver.get("http://ebay.com/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay", "Title of web page is wrong. Please check URL" );
    }

    @Test(dependsOnMethods = "openMainPage")
    public void testCase() {
        //close popup if present
        mainpage.closePopup();
        //click Sign In button
        mainpage.clickSignIn();
        //Enter credentials (Login/email, password)
        authpage.enterCredentials("denisa.sufliarska@embedit.cz", "hcichina33");
        // check if main page is opened and user is logined
        mainpage.verifyLogin();
        //Check if basket not empty - clear it
        if (mainpage.checkItemsInBasket()){
            mainpage.openBasket();
            basketpage.removeItems();
        }
        //Enter to search field
        mainpage.search("Iphone Cover");
        //Verify - search results are shown
        searchpage.verifySearchResults();
        //Select compatible model (by model)
        searchpage.selectCompatibleModel("iPhone 6");
        //Verify - search results are shown
        searchpage.verifySearchResults();
        // Click on needed product (count from top)
        searchpage.selectNeededProduct(3);
        // Check product detail shown
        productpage.verifyProductDatails();
        // Select dropbox args (by number of index)
        productpage.chooseListboxAttributes(1);
        // Click Add To Cart
        productpage.clickAddToCart();
        //Check that product added to basket (number of items)
        basketpage.verifyPtoductInTheBasket("1");





    }

}

