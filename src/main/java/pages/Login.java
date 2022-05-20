package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

    By userName = By.name("uid");
    By password = By.name("password");
    By titleText = By.className("barone");
    By login = By.name("btnLogin");

    public Login (WebDriver driver) {
        this.driver = driver;
    }

    //Set userName in textbox
    public void setUserName(String strUserName) {
        driver.findElement(userName).sendKeys(strUserName);
    }
    //Set userName in textbox
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }
    //Click on Login button
    public void clickLogin() {
        driver.findElement(login).click();
    }

    //Get title Login page
    public String getLoginTitle() {
        return driver.findElement(titleText).getText();
    }

    /* This POM method will be exposed in test case to login in the application
    * @param strUserName        * @param strPassword        *@return        */

    public void loginTo (String strUsername, String strPassword) {
        this.setUserName(strUsername);                              //Fill userName
        this.setPassword(strPassword);                              //Fill userName
        this.clickLogin();                                          //Click login
    }
}
