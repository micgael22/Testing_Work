package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    // All WebElements are identified by @FindBy annotation
    WebDriver driver;

    @FindBy(name = "uid")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "barone")
    WebElement titleText;

    @FindBy(name = "btnLogin")
    WebElement login;

    public Login(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Set userName in textbox
    public void setUserName(String strUsername) {
        userName.sendKeys(strUsername);
    }

    //Set password in password textbox
    public void setPassword (String strPassword) {
        password.sendKeys(strPassword);
    }

    //Click on Login button
    public void clickLogin() {
        login.click();
    }

    //Get the title of Login Page
    public String getLoginTitle() {
        return titleText.getText();
    }

    //This POM method will be exposed in test case to login in the application
    //@param strUserName
    //@param strPassword
    //@return

    public void loginTo(String strUserName, String strPassword) {
        this.setUserName(strUserName);                              //Fill userName
        this.setPassword(strPassword);                              //Fill password
        this.clickLogin();                                          //Click Login button
    }
}
