package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadCashierManagerPassword {

public static String cashiermanagerPassword = null;
	
	public static void getCashierManagerPassword(String propertyValue) throws IOException {
	
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
		prop.load(input);
		cashiermanagerPassword = prop.getProperty("Cashier_manager_password");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(cashiermanagerPassword);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
}
