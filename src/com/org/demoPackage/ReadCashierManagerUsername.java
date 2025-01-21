package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadCashierManagerUsername {
	public static String managercashierUserName = null;
	
	public static void getManagerCashierUsername(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
		prop.load(input);
		managercashierUserName = prop.getProperty("Cashier_manager_username");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(managercashierUserName);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
}
