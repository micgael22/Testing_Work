package testTwo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.Login;

import java.util.concurrent.TimeUnit;

public class TestLoginPageFactory {

    public WebDriver driver;
    Login objLogin;
    HomePage objHomePage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    // This test go to http://demo.guru99.com/V4/
    //Verify Login page title as guru
    //Login to application
    //Verify the homepage using Dashboard message

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct() {
        //create Login Page object
        objLogin = new Login(driver);

        //Verify Login page Title
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //login into application
        objLogin.loginTo("mngr407634", "bazAnug");

        //go the next page
        objHomePage = new HomePage(driver);

        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr407634"));
    }
}
