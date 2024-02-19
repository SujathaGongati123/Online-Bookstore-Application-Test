import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujat\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);

        driver.get("https://therightbookstoreindia.com/");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test(priority = 1)
    public void verifyingHomePageHeading(){

        String homePageHeading = homePage.getHeading();

        String expHomePageHeading = "ALL YOUR FAV BOOKS\n" +
                "UNDER ONE ROOF!";

        Assert.assertEquals(homePageHeading, expHomePageHeading,"Home Page heading is not matching..");
    }

    @Test(priority = 2)
    public void verifyingHomePageLogo(){

        WebElement logoImgEl = homePage.getLogoEl();

        Assert.assertTrue(logoImgEl.isDisplayed(), "Logo Image is not displaying..");
    }

    @Test(priority = 3)
    public void verifyingNavigationToSearchPage(){

        WebElement searchInputEl = homePage.getSearchInputEl();

         Assert.assertTrue(searchInputEl.isDisplayed(), "Search input field is not displaying..");

    }

    @Test(priority = 4)
    public void verifyingNavigationToStorePage(){

        String storePageUrl = homePage.getStorePageUrl();
        String expStorePageUrl = "https://therightbookstoreindia.com/store/";

        Assert.assertEquals(storePageUrl, expStorePageUrl, "Store Page url is not matching with expected url");
    }

    @Test(priority = 5)
    public void verifyingNavigationToAccountPage(){
        String accountPageUrl = homePage.getAccountPageUrl();
        String expAccountPageUrl = "https://therightbookstoreindia.com/my-account-2/";

        Assert.assertEquals(accountPageUrl, expAccountPageUrl, "Account page url is not matching..");
    }

    @Test(priority = 6)
    public void verifyingNavigationToContactusPage(){
        String contactusPageUrl = homePage.getContactusPageUrl();
        String expContactusPageUrl = "https://therightbookstoreindia.com/contact-us/";

        Assert.assertEquals(contactusPageUrl, expContactusPageUrl, "Contactus Page url is not matching..");
    }

    @Test(priority = 7)
    public void verifyingNavigationToTrackOrderPage(){
        String trackOrderPageUrl = homePage.getTrackOrderPageUrl();
        String expTrackOrderPageUrl = "https://therightbookstoreindia.shiprocket.co/";

        Assert.assertEquals(trackOrderPageUrl, expTrackOrderPageUrl, "Ttrack Order page url is not matching..");
    }

    @Test(priority = 8)
    public void verifyingNavigationToCartPage(){
        String cartPageUrl = homePage.getCartPageUrl();
        String expCartPageUrl = "https://therightbookstoreindia.com/cart-2/";

        Assert.assertEquals(cartPageUrl, expCartPageUrl, "Cart page url is not matching..");
    }

    @Test(priority = 9)
    public void verifyingNavigateToBooksCatelog(){
        String storePageUrl = homePage.getAllBooksUrl();
        String expStorePageUrl = "https://therightbookstoreindia.com/store/";

        Assert.assertEquals(storePageUrl, expStorePageUrl, "Expected url of store page is not matching..");
    }
}

















