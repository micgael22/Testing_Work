package utilities;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;
    WebDriver driver;

    public ReadConfig() {
        File src = new File("./configurationFiles/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }
        catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    //Create method for every variable in properties file

    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUserName() {
        String userName = pro.getProperty("username");
        return userName;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromePath() {
        String chromePath = pro.getProperty("chromePath");
        return chromePath;
    }
}
