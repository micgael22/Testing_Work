package com.inetBanking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass {

    public String baseURL = "http://demo.guru99.com/V4/";
    public String userName = "mngr407634";
    public String password = "bazAnug";
    public WebDriver driver;

    public Properties prop;
    public ReadConfig readCon;
    public String path = "src/main/resources/config.properties";

    public BaseClass() throws IOException {
        readCon = new ReadConfig();
    }

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

        prop = readCon.readPropertiesFile(path);
        System.out.println(">>>>> " + prop.getProperty("baseURL") + " <<<<<");
        System.out.println(">>>>> " + prop.getProperty("userName") + " <<<<<");
        System.out.println(">>>>> " + prop.getProperty("password") + " <<<<<");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
