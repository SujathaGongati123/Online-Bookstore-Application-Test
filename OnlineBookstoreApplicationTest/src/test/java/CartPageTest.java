import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.StorePage;

import java.time.Duration;
import java.util.List;

public class CartPageTest {
    WebDriver driver;
    CartPage cartPage;
    HomePage homePage;
    StorePage storePage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujat\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        storePage = new StorePage(driver);

        driver.get("https://therightbookstoreindia.com/");

        homePage.clickOnCartEl();

        String cartPageUrl = homePage.getCartPageUrl();

        Assert.assertEquals(cartPageUrl, "https://therightbookstoreindia.com/cart-2/", "Expected url is not matching..");
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test(priority = 1)
    public void verifyCartPageUI(){
        String offerText = cartPage.getOfferText();
        String cardHeading = cartPage.getCartHeading();
        String emptyCartText = cartPage.getEmptyCartText();

        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();

        String expOfferText = "Free Shipping on all prepaid orders above ₹799/-";
        String expCartHeading = "Cart";
        String expEmptyCartText = "Your cart is currently empty.";

        Assert.assertEquals(offerText, expOfferText, "Offer text is not matching..");
        Assert.assertEquals(cardHeading, expCartHeading, "Cart heading is not matching..");
        Assert.assertEquals(emptyCartText, expEmptyCartText, "Empty cart text is not matching..");

        Assert.assertTrue(returnToShopBtnEl.isDisplayed(), "Return to Shop button is not displayed.");
    }

    @Test(priority = 2)
    public void verifyingEmptyCart(){
        String emptyCartText = cartPage.getEmptyCartText();
        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();

        String expEmptyCartText = "Your cart is currently empty.";

        Assert.assertEquals(emptyCartText, expEmptyCartText, "Empty cart text is not matching..");

        Assert.assertTrue(returnToShopBtnEl.isDisplayed(), "Return to Shop button is not displayed.");

    }

    @Test(priority = 3)
    public void verifyingNavigationToShop(){
        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();
        returnToShopBtnEl.click();

        String expUrl = "https://therightbookstoreindia.com/store/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected URL is not matching..");
    }

    @Test(priority = 4)
    public void verifyOneItemInCart(){
        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();
        returnToShopBtnEl.click();

        String expUrl = "https://therightbookstoreindia.com/store/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected URL is not matching..");

        WebElement addButton = cartPage.getAddButton();
        //System.out.println(addButton);

        addButton.click();
        String expUrl2 = "https://therightbookstoreindia.com/cart-2/";

        wait.until(ExpectedConditions.urlToBe(expUrl2));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Expected URL2 is not matching..");

    }

    @Test(priority = 5)
    public void verifyingItemDetailsInCart(){
        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();
        returnToShopBtnEl.click();

        String expUrl = "https://therightbookstoreindia.com/store/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected URL is not matching..");

        WebElement addButton = cartPage.getAddButton();
        //System.out.println(addButton);

        addButton.click();
        String expUrl2 = "https://therightbookstoreindia.com/cart-2/";

        wait.until(ExpectedConditions.urlToBe(expUrl2));

        WebElement bookImgEl = cartPage.getBookImgEl();
        String bookTitle = cartPage.getBookTitle();
        String bookPrice = cartPage.getBookPrice();
        String subTotal = cartPage.getSubTotal();

        Assert.assertTrue(bookImgEl.isDisplayed(), "Book image is not displayed");
        Assert.assertEquals(bookTitle, "[Hardcover] Diary Of A Wimpy Kid: No Brainer by Jeff Kinney", "Book title is not matching..");
        Assert.assertEquals(bookPrice, "₹199.00", "Book price is not matching..");
        Assert.assertEquals(subTotal, "₹199.00", "subtotal is not matching..");

    }

    @Test(priority = 6)
    public void verifyingAddItemToCart(){
        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();
        returnToShopBtnEl.click();

        String expUrl = "https://therightbookstoreindia.com/store/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected URL is not matching..");

        WebElement addButton1 = cartPage.getAddButton();
        //System.out.println(addButton);

        addButton1.click();
        String expUrl2 = "https://therightbookstoreindia.com/cart-2/";
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        homePage.clickOnStoreEl();

        expUrl = "https://therightbookstoreindia.com/store/";

        wait.until(ExpectedConditions.urlToBe(expUrl));

        WebElement addButton2 = driver.findElement(By.cssSelector("a[data-product_id='142995']"));
        addButton2.click();

        expUrl2 = "https://therightbookstoreindia.com/cart-2/";
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        List<WebElement> cartItems = driver.findElements(By.cssSelector("tr[class='woocommerce-cart-form__cart-item cart_item']"));

        Assert.assertEquals(cartItems.size(), 2, "Items count in cart is not matching..");


    }

    @Test(priority = 7)
    public void verifyingRemoveFunctionalityOfCart(){
        WebElement returnToShopBtnEl = cartPage.getReturnToShopBtnEl();
        returnToShopBtnEl.click();

        String expUrl = "https://therightbookstoreindia.com/store/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected URL is not matching..");

        WebElement addButton1 = cartPage.getAddButton();
        //System.out.println(addButton);

        addButton1.click();
        String expUrl2 = "https://therightbookstoreindia.com/cart-2/";
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        homePage.clickOnStoreEl();

        expUrl = "https://therightbookstoreindia.com/store/";

        wait.until(ExpectedConditions.urlToBe(expUrl));

        WebElement addButton2 = driver.findElement(By.cssSelector("a[data-product_id='142995']"));
        addButton2.click();

        expUrl2 = "https://therightbookstoreindia.com/cart-2/";
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        List<WebElement> cartItems = driver.findElements(By.cssSelector("tr[class='woocommerce-cart-form__cart-item cart_item']"));

        Assert.assertEquals(cartItems.size(), 2, "Items count in cart is not matching..");

        List<WebElement> removeIcons = driver.findElements(By.cssSelector("td[class='product-remove'] > a > span > svg"));

        removeIcons.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr[class='woocommerce-cart-form__cart-item cart_item']")));

        cartItems = driver.findElements(By.cssSelector("tr[class='woocommerce-cart-form__cart-item cart_item']"));

        Assert.assertEquals(cartItems.size(), 2, "Items count in cart after removing is not matching..");

    }

}













































