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
import pages.LoginPage;
import pages.LostPasswordPage;

import java.time.Duration;

public class PasswordResetFunctionalityTest {
    WebDriver driver;
    LostPasswordPage lostPasswordPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujat\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        lostPasswordPage = new LostPasswordPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://therightbookstoreindia.com/");

        WebElement accountEl = driver.findElement(By.xpath("//a[text()='Account']"));
        accountEl.click();

        loginPage.clickOnLostPsw();

        String expUrl = "https://therightbookstoreindia.com/my-account-2/lost-password/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Expected url is not matching..");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void resetWithEmptyUsename(){
        lostPasswordPage.clickOnResetBtn();
        String errMsg = lostPasswordPage.getErrorMsg();

        String expErrMsg = "Enter a username or email address.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty username is not matching..");
    }

    @Test(priority = 2)
    public void resetWithIncorrectMail(){
        lostPasswordPage.enterUsernameOrMail("sujatha");
        lostPasswordPage.clickOnResetBtn();
        String errMsg = lostPasswordPage.getErrorMsg();

        String expErrMsg = "Invalid username or email.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with incorrect mail is not matching..");
    }

    @Test(priority = 3)
    public void resetWithNonRegisteredMail(){
        lostPasswordPage.enterUsernameOrMail("sireeshamaddikari6@gmail.com");
        lostPasswordPage.clickOnResetBtn();
        String errMsg = lostPasswordPage.getErrorMsg();

        String expErrMsg = "Invalid username or email.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with incorrect mail is not matching..");
    }

    @Test(priority = 4)
    public void resetWithNonRegisteredUsername(){
        lostPasswordPage.enterUsernameOrMail("sujatha123");
        lostPasswordPage.clickOnResetBtn();
        String errMsg = lostPasswordPage.getErrorMsg();

        String expErrMsg = "Invalid username or email.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with incorrect mail is not matching..");
    }

//    @Test(priority = 5)
//    public void resetWithValidMail(){
//        lostPasswordPage.enterUsernameOrMail("sujathagongati4@gmail.com");
//        lostPasswordPage.clickOnResetBtn();
//        WebElement successMsgEl = driver.findElement(By.cssSelector("div.woocommerce-message"));
//
//        String expSuccessMsg = "Password reset email has been sent.";
//
//        Assert.assertEquals(successMsgEl.getText(), expSuccessMsg, "Success message is not matching..");
//    }
//
//    @Test(priority = 6)
//    public void resetWithValidUsername(){
//        lostPasswordPage.enterUsernameOrMail("sireeshamaddikari442001");
//        lostPasswordPage.clickOnResetBtn();
//        WebElement successMsgEl = driver.findElement(By.cssSelector("div.woocommerce-message"));
//
//        String expSuccessMsg = "Password reset email has been sent.";
//
//        Assert.assertEquals(successMsgEl.getText(), expSuccessMsg, "Success message is not matching..");
//    }

}
























