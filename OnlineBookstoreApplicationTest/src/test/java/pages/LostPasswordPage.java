package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LostPasswordPage {
    WebDriver driver;
    WebDriverWait wait;

    //  Defining Locators for web elements in Register Page.

    By descLocator = By.xpath("//p[contains(text(),'Lost your password?')]");
    By usernameOrEmailLocator = By.id("user_login");
    By resetBtnLocator = By.cssSelector("button[value *= 'Reset password']");
    By errorMsgLocator = By.cssSelector("ul.woocommerce-error > li");

    public LostPasswordPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Defining the methods to perform actions on the web elements

    public String getDescription(){
        return driver.findElement(descLocator).getText();
    }

    public void enterUsernameOrMail(String username){
        driver.findElement(usernameOrEmailLocator).sendKeys(username);
    }

    public void clickOnResetBtn(){
        driver.findElement(resetBtnLocator).click();
    }

    public String  getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
        WebElement errorMsgEl = driver.findElement(errorMsgLocator);
        return errorMsgEl.getText();
    }
}
















