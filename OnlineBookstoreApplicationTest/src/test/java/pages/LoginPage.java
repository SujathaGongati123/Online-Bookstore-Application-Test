package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //  Defining Locators for web elements in Register Page.
    By loginHeadingLocator = By.xpath("h2[text()='Login']");
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtnLocator = By.name("login");
    By errorMsgLocator = By.cssSelector("ul.woocommerce-error > li");
    By lostPswLocator = By.cssSelector("p[class *= 'woocommerce-LostPassword'] > a");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Defining the methods to perform actions on the web elements

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtnLocator).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
        WebElement errorMsgEl = driver.findElement(errorMsgLocator);
        return errorMsgEl.getText();
    }

    public void loginToApplication(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginBtn();
    }

    public void clickOnLostPsw(){
        driver.findElement(lostPswLocator).click();
    }
}

























