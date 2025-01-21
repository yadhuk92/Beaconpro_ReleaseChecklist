package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadAdminPassword {
	public static String adminPassword = null;
	
	public static void getAdminPassword(String propertyValue) throws IOException {
	
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
		prop.load(input);
		adminPassword = prop.getProperty("admin_password");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(adminPassword);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
}
