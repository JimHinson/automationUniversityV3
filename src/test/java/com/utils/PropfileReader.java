package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropfileReader {
	static Properties prop = new Properties();
	
	public static String getUserData(String userDetailsToken) {
		try {
            prop.load(new FileInputStream("src/test/resources/UserData.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
		return prop.getProperty(userDetailsToken);
	}
	
	public static String getSetting(String settingToken) {
		try {
            prop.load(new FileInputStream("src/test/resources/testdata/DefaultSettings.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
		return prop.getProperty(settingToken);
	}
}