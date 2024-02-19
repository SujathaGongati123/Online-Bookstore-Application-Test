package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    //  Defining Locators for web elements in Home Page.

    By logoLocator = By.cssSelector("a[class = 'custom-logo-link']");
    By searchIconLocator = By.cssSelector("a[class *= 'astra-search-icon']");
    By storeLocator = By.xpath("//a[text()='Store']");
    By accountLocator = By.xpath("//a[text()='Account']");
    By contactusLocator = By.xpath("//a[text()='Contact Us']");
    By trackOrderLocator = By.xpath("//a[text()='TRACK YOUR ORDER']");
    By cartLocator = By.cssSelector("div[class *= 'ast-desktop-cart-position'] > i");
    By headingLocator = By.cssSelector("h1[class *= 'elementor-heading-title']");
    By allBooksLocator = By.xpath("//span[text() = 'ALL BOOKS']");
    By searchInputLocator = By.id("dgwt-wcas-search-input-1");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Defining the methods to perform actions on the web elements

    public WebElement getLogoEl(){
        return driver.findElement(logoLocator);
    }

    public void clickOnSearchIcon(){
        WebElement searchIconEl = driver.findElement(searchIconLocator);
        searchIconEl.click();
    }

    public void clickOnStoreEl(){
        WebElement storeEl = driver.findElement(storeLocator);
        storeEl.click();
    }

    public void clickOnAccountEl(){
        WebElement accountEl = driver.findElement(accountLocator);
        accountEl.click();
    }

    public void clickOnContactusEl(){
        WebElement contactusEl = driver.findElement(contactusLocator);
        contactusEl.click();
    }

    public void clickOnTrackOrderEl(){
        WebElement trackOrderEl = driver.findElement(trackOrderLocator);
        trackOrderEl.click();
    }

    public void clickOnCartEl(){
        WebElement cartEl = driver.findElement(cartLocator);
        cartEl.click();
    }

    public String getHeading(){
        return driver.findElement(headingLocator).getText();
    }

    public WebElement getSearchInputEl(){
        clickOnSearchIcon();
        WebElement searchInputEl = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputLocator));

        return searchInputEl;
    }

    public String getStorePageUrl(){
        clickOnStoreEl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(storeLocator));

        return driver.getCurrentUrl();
    }

    public String getAccountPageUrl(){
        clickOnAccountEl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountLocator));

        return driver.getCurrentUrl();
    }

    public String getContactusPageUrl(){
        clickOnContactusEl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactusLocator));

        return driver.getCurrentUrl();
    }

    public String getTrackOrderPageUrl(){
        clickOnTrackOrderEl();
        wait.until(ExpectedConditions.urlToBe("https://therightbookstoreindia.shiprocket.co/"));

        return driver.getCurrentUrl();
    }

    public String getCartPageUrl(){
        clickOnCartEl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator));

        return driver.getCurrentUrl();
    }

    public String getAllBooksUrl(){
        WebElement allBooksEl = driver.findElement(allBooksLocator);
        allBooksEl.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(storeLocator));

        return driver.getCurrentUrl();
    }
}








































