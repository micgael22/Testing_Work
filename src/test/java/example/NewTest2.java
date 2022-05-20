package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {
    public WebDriver driver;

    @Test
    public void testEasy2() {
        driver.get("https://www.w3schools.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("W3Schools Online Web Tutorials"));
    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
