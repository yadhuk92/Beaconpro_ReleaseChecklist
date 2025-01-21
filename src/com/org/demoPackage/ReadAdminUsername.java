package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadAdminUsername {
		public static String adminUserName = null;
		
		public static void getAdminUsername(String propertyValue) throws IOException {
			
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
			prop.load(input);
			adminUserName = prop.getProperty("admin_username");
			Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(adminUserName);	
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}

}
