package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage {
    WebDriver driver;
    WebDriverWait wait;

    //  Defining Locators for web elements in Store Page.

    By searchBtnLocator = By.cssSelector("button[value = 'Search']");
    By searchInputLocator = By.id("woocommerce-product-search-field-0");
    By categoriesLocator = By.xpath("//h2[text() = 'Browse by Categories']");
    By bestSellersLocator = By.xpath("//h2[text() = 'Our Best Sellers']");
    By resultCountLocator = By.cssSelector("p.woocommerce-result-count");
    By categoriesElsLocator = By.cssSelector("ul.product-categories > li");
    By bestSellersElsLocator = By.cssSelector("ul.product_list_widget > li");
    By booksLocator = By.cssSelector("ul.products > li");

    public StorePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Defining the methods to perform actions on the web elements

    public String getCategoriesHeading(){
        return driver.findElement(categoriesLocator).getText();
    }

    public String getBestSellersHeading(){
        return driver.findElement(bestSellersLocator).getText();
    }

    public WebElement getSearchButtonEl(){
        return driver.findElement(searchBtnLocator);
    }

    public WebElement getSearchInputEl(){
        return driver.findElement(searchInputLocator);
    }

    public String getResultCountText(){
        return driver.findElement(resultCountLocator).getText();
    }

    public List<WebElement> getCategoriesList(){
        List<WebElement> categoriesList = driver.findElements(categoriesElsLocator);
        return categoriesList;
    }

    public List<WebElement> getBestSellersList(){
        List<WebElement> bestSellersList = driver.findElements(bestSellersElsLocator);
        return bestSellersList;
    }

    public List<WebElement> getBooksList(){
        List<WebElement> booksList = driver.findElements(booksLocator);

        return booksList;
    }
}










































