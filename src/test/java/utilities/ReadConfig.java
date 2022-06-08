package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    public Properties prop;
    public String path;
    public ReadConfig readCon;

    public ReadConfig() throws IOException {
        prop = new Properties();
        path = "src/main/resources/config.properties";
    }

    public Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;

        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            fis.close();
        }
        return prop;
    }
}
