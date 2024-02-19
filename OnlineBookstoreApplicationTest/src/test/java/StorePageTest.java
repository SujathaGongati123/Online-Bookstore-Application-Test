import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StorePage;

import java.time.Duration;
import java.util.List;

public class StorePageTest {
    WebDriver driver;
    StorePage storePage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujat\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        storePage = new StorePage(driver);
        homePage = new HomePage(driver);

        driver.get("https://therightbookstoreindia.com/");

        homePage.clickOnStoreEl();

        String storePageUrl = homePage.getStorePageUrl();

        Assert.assertEquals(storePageUrl, "https://therightbookstoreindia.com/store/", "Expected url is not matching..");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyStorePageUI(){
        String categoriesHeading = storePage.getCategoriesHeading();
        String bestSellersHeading = storePage.getBestSellersHeading();
        String resultCountText = storePage.getResultCountText();

        WebElement searchBtnEl = storePage.getSearchButtonEl();
        WebElement searchInputEl = storePage.getSearchInputEl();

        Assert.assertEquals(categoriesHeading, "Browse by Categories", "Categories heading is not matching..");
        Assert.assertEquals(bestSellersHeading, "Our Best Sellers", "Best sellers heading is not matching..");
        Assert.assertEquals(resultCountText, "Showing 1–12 of 1468 results", "Result count text is not matching..");

        Assert.assertTrue(searchBtnEl.isDisplayed(), "Search button is not displayed..");
        Assert.assertTrue(searchInputEl.isDisplayed(), "Search input field is not displayed..");
    }

    @Test(priority = 2)
    public void verifyCategoriesList(){
        List<WebElement> categoriesList = storePage.getCategoriesList();

        int expectedListCount = 38;

        Assert.assertEquals(categoriesList.size(), expectedListCount, "Categories List count is not matching..");
    }

    @Test(priority = 3)
    public void verifyBestSellersList(){
        List<WebElement> bestSellersList = storePage.getBestSellersList();

        Assert.assertEquals(bestSellersList.size(), 5, "best sellers list count is not matching..");
    }

    @Test(priority = 4)
    public void verifyBooksList(){
        List<WebElement> booksList = storePage.getBooksList();

        Assert.assertEquals(booksList.size(), 12, "Books list count is not matching..");
    }

    @Test(priority = 5)
    public void verifyBookDetails(){
        List<WebElement> booksList = storePage.getBooksList();

        booksList.get(0).click();

        String expUrl = "https://therightbookstoreindia.com/product/jojos-bizarre-adventure-part-1-phantom-blood-combo-3-books/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected url is not matching..");
    }


}
























