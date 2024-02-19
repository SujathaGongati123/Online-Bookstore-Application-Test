package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    //  Defining Locators for web elements in cart Page.

    By offerTextLocator = By.xpath("//p[contains(text(),'Free Shipping')]");
    By cartHeadingLocator = By.xpath("//h1[text() = 'Cart']");
    By returnBtnLocator = By.cssSelector("p.return-to-shop > a");
    By emptyCartTextLocator = By.xpath("//div[@class = 'cart-empty woocommerce-info']");
    By addButtonLocator = By.cssSelector("a[data-product_id='142991']");
    By bookImgLocator = By.cssSelector("td.product-thumbnail > a > img");
    By bookTitleLocator = By.cssSelector("td.product-name > a ");
    By bookPriceLocator = By.cssSelector("td.product-price  bdi ");
    By subtotalLocator = By.cssSelector("td.product-subtotal  bdi ");

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Defining methods to perform actions on web elements

    public String getOfferText(){
        return driver.findElement(offerTextLocator).getText();
    }

    public String getCartHeading(){
        return driver.findElement(cartHeadingLocator).getText();
    }

    public WebElement getReturnToShopBtnEl(){
        return driver.findElement(returnBtnLocator);
    }

    public String getEmptyCartText(){
        return driver.findElement(emptyCartTextLocator).getText();
    }

    public WebElement getAddButton(){
        return driver.findElement(addButtonLocator);
    }

    public WebElement getBookImgEl(){
        return driver.findElement(bookImgLocator);
    }

    public String getBookTitle(){
        return driver.findElement(bookTitleLocator).getText();
    }

    public String getBookPrice(){
        return driver.findElement(bookPriceLocator).getText();
    }


    public String getSubTotal(){
        return driver.findElement(subtotalLocator).getText();
    }
}


























