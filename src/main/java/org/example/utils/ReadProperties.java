package org.example.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadProperties {

    public Map<String, Object> getPropertyValue() {
        Map<String, Object> myMap = new HashMap<>();
        try {
            InputStream inputStream = ReadProperties.class.getResourceAsStream(("/config.properties"));
            Properties prop = new Properties();
            if (inputStream == null) {
                System.out.println("Didn't find property file.");
                return null;
            }
            prop.load(inputStream);

            for (String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key);
                myMap.put(key, value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return myMap;
    }
}
