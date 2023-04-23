package com.eurowings.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertyReader {

    private static final String PATH = "src/test/resources/config.properties";
    private static Properties properties;

    private PropertyReader() {
    }

    public static String get(String property) {
        try (FileInputStream fileInputStream = new FileInputStream(PATH)) {
            if (properties == null) {
                properties = new Properties();
                properties.load(fileInputStream);
            }
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getInt(String property) {
        String stringProperty = get(property);
        return stringProperty != null ? Integer.parseInt(stringProperty) : 0;
    }
}
