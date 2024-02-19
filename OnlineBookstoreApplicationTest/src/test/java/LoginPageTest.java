import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.*;


public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujat\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        driver.get("https://therightbookstoreindia.com/");

        WebElement accountEl = driver.findElement(By.xpath("//a[text()='Account']"));
        accountEl.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginWithEmptyInputs(){
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: Username is required.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty input fields is not matching..");
    }

    @Test(priority = 2)
    public void loginWithEmptyUsername(){
        loginPage.enterPassword("2tuaRLmmf#7DYaJ");
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: Username is required.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty email field is not matching..");
    }

    @Test(priority = 3)
    public void loginWithEmptyPassword(){
        loginPage.enterUsername("sujathagongati4");
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The password field is empty.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty password is not matching");
    }

    @Test(priority = 4)
    public void loginWithInvalidUsernameAndValidPsw(){
        loginPage.loginToApplication("sujatha", "2tuaRLmmf#7DYaJ");
        String errMSg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The username sujatha is not registered on this site. If you are unsure of your username, try your email address instead.";

        Assert.assertEquals(errMSg, expErrMsg, "Error message with invalid email and valid password is not matching..");
    }

    @Test(priority = 5)
    public void loginWithValidUsernameAndInvalidPsw(){
        loginPage.loginToApplication("sujathagongati4", "sujatha123");
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The password you entered for the username sujathagongati4 is incorrect. Lost your password?";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with valid username and invalid password is not matching..");
    }

    @Test(priority = 6)
    public void loginWithInvalidUsernameAndInvalidPsw(){
        loginPage.loginToApplication("sujatha", "sujatha123");
        String errMSg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The username sujatha is not registered on this site. If you are unsure of your username, try your email address instead.";

        Assert.assertEquals(errMSg, expErrMsg, "Error message with invalid username and invalid password is not matching..");
    }

    @Test(priority = 7)
    public void loginWithNonRegisteredMailAndValidPsw(){
        loginPage.loginToApplication("sireeshamaddikari6@gmail.com", "2tuaRLmmf#7DYaJ");
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Unknown email address. Check again or try your username.";

        Assert.assertEquals(errMsg, expErrMsg, "Error  message with non registered mail is not matching..");
    }

    @Test(priority = 8)
    public void loginWithNonRegisteredMailAndInvalidPsw(){
        loginPage.loginToApplication("sireeshamaddikari6@gmail.com", "sujatha123");
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Unknown email address. Check again or try your username.";

        Assert.assertEquals(errMsg, expErrMsg, "Error  message with non registered mail and invalid password is not matching..");

    }

    @Test(priority = 9)
    public void loginWithNonRegisteredMailAndEmptyPsw(){
        loginPage.enterUsername("sireeshamaddikari6@gmail.com");
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The password field is empty.";

        Assert.assertEquals(errMsg, expErrMsg, "Error  message with non registered mail and empty password is not matching..");

    }

    @Test(priority = 10)
    public void loginWithRegisteredMailAndEmptyPsw(){
        loginPage.enterUsername("sujathagongati4@gmail.com");
        loginPage.clickOnLoginBtn();
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The password field is empty.";

        Assert.assertEquals(errMsg, expErrMsg, "Error  message with registered mail and empty password is not matching..");
    }

    @Test(priority = 11)
    public void loginWithRegisteredMailAndInvalidPsw(){
        loginPage.loginToApplication("sujathagongati4@gmail.com", "sujatha123");
        String errMsg = loginPage.getErrorMessage();

        String expErrMsg = "Error: The password you entered for the email address sujathagongati4@gmail.com is incorrect. Lost your password?";

        Assert.assertEquals(errMsg, expErrMsg, "Error  message with registered mail and invalid password is not matching..");
    }

    @Test(priority = 12)
    public void loginWithValidUsernameAndValidPsw(){
        loginPage.loginToApplication("sujathagongati4", "2tuaRLmmf#7DYaJ");

        List<WebElement> successMessages = driver.findElements(By.cssSelector("div[class *= 'MyAccount-content'] > p"));

        String[] expTexts = {"Hello sujathagongati4 (not sujathagongati4? Log out)","From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details."};

        for(int i=0;i<successMessages.size();i++){
            Assert.assertEquals(successMessages.get(i).getText(), expTexts[i], "Success login text is not matching..");
        }
    }

    @Test(priority = 13)
    public void liginWithValidMailAndInvalidPsw(){
        loginPage.loginToApplication("sujathagongati4@gmail.com", "2tuaRLmmf#7DYaJ");

        List<WebElement> successMessages = driver.findElements(By.cssSelector("div[class *= 'MyAccount-content'] > p"));

        String[] expTexts = {"Hello sujathagongati4 (not sujathagongati4? Log out)","From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details."};

        for(int i=0;i<successMessages.size();i++){
            Assert.assertEquals(successMessages.get(i).getText(), expTexts[i], "Success login text is not matching..");
        }
    }

}































