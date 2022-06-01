package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass{

    @Test
    public void loginTest() {

        //driver.get(baseURL);

        logger.info("URL is open");

        LoginPage logP = new LoginPage(driver);
        logP.setUserName(userName);
        logger.info("Entered UserName");

        logP.setPassword(password);
        logger.info("Entered password");

        logP.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Login test password");
        }
        else {
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }
}