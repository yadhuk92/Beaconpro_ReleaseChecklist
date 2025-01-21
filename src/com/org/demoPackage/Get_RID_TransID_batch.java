package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class Get_RID_TransID_batch {

	public static void getTransid(String propertyValue) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/RID_BATCH_Details.properties");
		prop.load(input);
		String transid= prop.getProperty("TransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transid);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
		
	}

}
