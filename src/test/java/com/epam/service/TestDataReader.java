package com.epam.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "dev"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
