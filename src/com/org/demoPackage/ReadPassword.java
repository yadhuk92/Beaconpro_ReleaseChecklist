package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadPassword {

	public static String passWord = null;
		public static void ReadPassword(String propertyValue) throws IOException {
			
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
			prop.load(input);
			passWord = prop.getProperty("password");
			Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(passWord);
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}

}
