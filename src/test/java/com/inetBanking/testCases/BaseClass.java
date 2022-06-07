package com.inetBanking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass {

    //ReadConfig readConfig = new ReadConfig();
    //public String baseURL = readConfig.getApplicationURL();
    //public String userName = readConfig.getUserName();
    //public String password = readConfig.getPassword();
    //public WebDriver driver;

    public String baseURL = "http://demo.guru99.com/V4/";
    public String userName = "mngr407634";
    public String password = "bazAnug";
    public WebDriver driver;

    public static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @BeforeClass
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         try{
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.ALL);
            logger.addHandler(fh);
        }
         catch (Exception e) {
            logger.log(Level.SEVERE, "File Logger not working");
        }
    }

    /*
    @Parameters("browser")
    @BeforeClass
    public void setup(String br) throws IOException {

        try {
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.ALL);
            logger.addHandler(fh);
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "File Logger not working");
        }

        if(br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        driver.get(baseURL);
    }
     */

   /* @BeforeClass
    public void setup02() {
        //System.setProperty("WebDriver driver", readConfig.getChromePath());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        logger = Logger.getLogger("Project_Testing");
        PropertyConfigurator.configure("Log4j.properties");
    }
    */

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
