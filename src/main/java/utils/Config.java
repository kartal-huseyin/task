package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String getProperty(String key){

        String file = "src/main/resources/Config.properties";
        FileReader fileReader;
        Properties properties;

        try {
             fileReader=new FileReader(file);
             properties= new Properties();
             properties.load(fileReader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);

    }

}
