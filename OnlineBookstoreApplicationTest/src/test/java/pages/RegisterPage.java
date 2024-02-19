package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    //  Defining Locators for web elements in Register Page.

    By registerHeadingLocator = By.xpath("//h2[text()='Register']");
    By emailLocator = By.id("reg_email");
    By regPswLocator = By.id("reg_password");
    By registerBtnLocator = By.name("register");
    By errorMsgLocator = By.cssSelector("ul.woocommerce-error > li");
    By strongPswMsgLocator = By.xpath("//div[contains(@class,'woocommerce-password-strength')]");
    
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Defining the methods to perform actions on the web elements

    public void enterEmailAddress(String email){
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void enterRegPsw(String regPsw){
        driver.findElement(regPswLocator).sendKeys(regPsw);
    }

    public void clickOnRegisterBtn(){
        driver.findElement(registerBtnLocator).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
        WebElement errorMsgEl = driver.findElement(errorMsgLocator);
        return errorMsgEl.getText();
    }

    public void registerToApplication(String email,String regPsw){
        enterEmailAddress(email);
        enterRegPsw(regPsw);
        clickOnRegisterBtn();
    }

    public String getStrongPswMsg(){
        WebElement regPswEl = driver.findElement(regPswLocator);
        WebElement strongPswMsgEl = driver.findElement(strongPswMsgLocator);
        boolean isFocused = regPswEl.equals(driver.switchTo().activeElement());
        //System.out.println(isFocused);

        if(isFocused){
            WebElement registerBtnEl = driver.findElement(registerBtnLocator);
            return strongPswMsgEl.getText();
        }else{
            return "";
        }
    }
}



































