package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadUsername {
	public static String userName = null;
	
	public static void ReadUsername(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
		prop.load(input);
		userName = prop.getProperty("username");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(userName);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
}
