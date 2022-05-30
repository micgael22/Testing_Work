package com.inetBanking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class BaseClass {

    public String baseURL = "http://demo.guru99.com/V4/";
    public String userName = "mngr407634";
    public String password = "bazAnug";
    public WebDriver driver;

    //public static Logger logger;
    public static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //logger = logger.getLogger("Project_Testing");
        //PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
