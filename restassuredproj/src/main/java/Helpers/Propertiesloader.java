package Helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public  class Propertiesloader {
    public  static String readproperty(String key)
    {
        Properties properties = new Properties();

        try {
            properties.load(new BufferedReader(new FileReader("C:\\Users\\Mohamed Mazrouaa\\IdeaProjects\\restassuredproj\\src\\main\\resources\\Config.prop")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);

    }
}
