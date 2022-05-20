package testTwo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class TestLogin {

    public WebDriver driver;

    Login login;
    HomePage objHomePage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }


    /*
    This test case will Login in http://demo.guru99.com/V4/
    Verify login page title as guru99 bank
    Login to application
    Verify the home page using Dashboard messages
     */

    @Test(priority = 0)
    public void test_Home_Appear_Correct() {

        //create Login Page object
        Login objLogin = new Login(driver);

        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //login to application
        objLogin.loginTo("mngr407634", "bazAnug");

        //go the next page
        objHomePage = new HomePage(driver);

        //verify homepage
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr407634"));
    }
}