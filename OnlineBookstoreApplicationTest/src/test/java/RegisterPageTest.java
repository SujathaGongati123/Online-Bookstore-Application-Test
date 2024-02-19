import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.List;

public class RegisterPageTest {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujat\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);

        driver.get("https://therightbookstoreindia.com/");

        WebElement accountEl = driver.findElement(By.xpath("//a[text()='Account']"));
        accountEl.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void registerWithEmptyInputs(){
        registerPage.clickOnRegisterBtn();
        String errMsg = registerPage.getErrorMessage();

        String expErrMsg = "Error: Please provide a valid email address.";

        Assert.assertEquals(errMsg, expErrMsg, "Error Message with empty input fields is not matching..");
    }

    @Test(priority = 2)
    public void registerWithEmptyEmail(){
        registerPage.enterRegPsw("sujatha12345");
        WebElement registerBtnEl = driver.findElement(By.name("register"));
        String strongPswMSg = registerPage.getStrongPswMsg();

        String expStrongPswMSg = "Weak - Please enter a stronger password.";

        Assert.assertEquals(registerBtnEl.isEnabled(), false, "For Weak password register button must be not enable..");
        Assert.assertEquals(strongPswMSg, expStrongPswMSg, "Strong Password message is not matching..");

    }

    @Test(priority = 3)
    public void registerWithEmptyRegPsw(){
        registerPage.enterEmailAddress("sujathagongati4@gmail.com");
        registerPage.clickOnRegisterBtn();
        String errMsg = registerPage.getErrorMessage();

        String expErrMsg = "Error: An account is already registered with your email address. Please log in.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with empty password is not matching..");
    }

//    @Test(priority = 4)
//    public void registerWithIncorrectEmailAndEmptyPsw(){
//        registerPage.enterEmailAddress("sujathaGongati");
//        registerPage.clickOnRegisterBtn();
//        String errMsg = registerPage.getErrorMessage();
//
//        String expErrMsg = "Error: Please provide a valid email address.";
//
//        Assert.assertEquals(errMsg, expErrMsg, "Error message with incorrect mail is not matching..");
//    }

    @Test(priority = 5)
    public void registerWithWeakPsw(){
        registerPage.enterEmailAddress("sujathagongati4@gmail.com");
        registerPage.enterRegPsw("sujatha12345");
        WebElement registerBtnEl = driver.findElement(By.name("register"));
        String strongPswMSg = registerPage.getStrongPswMsg();

        String expStrongPswMSg = "Weak - Please enter a stronger password.";

        Assert.assertEquals(registerBtnEl.isEnabled(), false, "For Weak password register button must be not enable..");
        Assert.assertEquals(strongPswMSg, expStrongPswMSg, "Strong Password message is not matching..");
    }

    @Test(priority = 6)
    public void registerWithInvalidPswLength(){
        registerPage.enterEmailAddress("sujathagongati4@gmail.com");
        registerPage.enterRegPsw("suji123");
        WebElement registerBtnEl = driver.findElement(By.name("register"));
        String strongPswMSg = registerPage.getStrongPswMsg();

        String expStrongPswMSg = "Weak - Please enter a stronger password.";

        Assert.assertEquals(registerBtnEl.isEnabled(), false, "For Weak password register button must be not enable..");
        Assert.assertEquals(strongPswMSg, expStrongPswMSg, "Strong Password message is not matching..");
    }

//    @Test(priority = 7)
//    public void registerWithValidEmailAndPsw(){
//        registerPage.registerToApplication("nagammagongati@gmail.com", "2tuaRLmmf#7DYaJ");
//        List<WebElement> successMessages = driver.findElements(By.cssSelector("div[class *= 'MyAccount-content'] > p"));
//
//        String[] expTexts = {"Hello nagammagongati (not nagammagongati? Log out)","From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details."};
//
//        for(int i=0;i<successMessages.size();i++){
//            Assert.assertEquals(successMessages.get(i).getText(), expTexts[i], "Success login text is not matching..");
//        }
//    }

    @Test(priority = 8)
    public void registerWithExistingEmail(){
        registerPage.registerToApplication("sujathagongati4@gmail.com", "2tuaRLmmf#7DYaJ");
        String errMsg = registerPage.getErrorMessage();

        String expErrMsg = "Error: An account is already registered with your email address. Please log in.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with existing mail is not matching..");

    }

//    @Test(priority = 9)
//    public void RegisterWithLengthyPsw(){
//        registerPage.registerToApplication("sirisuji071@gmail.com", "sdhg6632438rsdhvgfttyDTDahGW2546483@#rhdjhf4rfbdhbhvhdjsfjjdtu4rey888hjjb&@jhfdjkbvhefdjbcndbvhrbjfejbdnbfndsfwerrue687jdgfhsgksgflgdfkugfkjdsfdvhvsd%sdghh63473gdsvdcvxbcsdfterw463457w8");
//        List<WebElement> successMessages = driver.findElements(By.cssSelector("div[class *= 'MyAccount-content'] > p"));
//
//        String[] expTexts = {"Hello sirisuji071 (not sirisuji071? Log out)","From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details."};
//
//        for(int i=0;i<successMessages.size();i++){
//            Assert.assertEquals(successMessages.get(i).getText(), expTexts[i], "Success login text is not matching..");
//        }
//    }

    @Test(priority = 10)
    public void registerWithExistingEmailAndEmptyPsw(){
        registerPage.enterEmailAddress("sujathagongati4@gmail.com");
        registerPage.clickOnRegisterBtn();
        String errMsg = registerPage.getErrorMessage();

        String expErrMsg = "Error: An account is already registered with your email address. Please log in.";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with existing mail is not matching..");

    }
}


























