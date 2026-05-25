package com.qentelli.GroupFinalAssessment.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            FileInputStream file =
                    new FileInputStream(
                    "src/main/resources/config/config.properties");

            properties = new Properties();

            properties.load(file);

        } catch (Exception e) {

            throw new RuntimeException(
            "Unable to load config file");
        }
    }

    // Read property value
    public static String getProperty(
            String key) {

        return properties.getProperty(key);
    }
}